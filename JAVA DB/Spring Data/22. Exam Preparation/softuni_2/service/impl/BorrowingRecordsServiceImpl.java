package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.xml.BookSeedXmlDto;
import softuni.exam.models.dto.xml.BorrowingRecordSeedDto;
import softuni.exam.models.dto.xml.BorrowingRecordSeedRootDto;
import softuni.exam.models.dto.xml.MemberSeedXmlDto;
import softuni.exam.models.entity.Book;
import softuni.exam.models.entity.BorrowingRecord;
import softuni.exam.models.entity.LibraryMember;
import softuni.exam.models.entity.enums.Genre;
import softuni.exam.repository.BookRepository;
import softuni.exam.repository.BorrowingRecordRepository;
import softuni.exam.repository.LibraryMemberRepository;
import softuni.exam.service.BorrowingRecordsService;
import softuni.exam.util.ValidationUtil;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

@Service
public class BorrowingRecordsServiceImpl implements BorrowingRecordsService {

    private static final String FILE_PATH = "src/main/resources/files/xml/borrowing-records.xml";

    private final BorrowingRecordRepository borrowingRecordRepository;
    private final BookRepository bookRepository;
    private final LibraryMemberRepository libraryMemberRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public BorrowingRecordsServiceImpl(BorrowingRecordRepository borrowingRecordRepository, BookRepository bookRepository, LibraryMemberRepository libraryMemberRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.borrowingRecordRepository = borrowingRecordRepository;
        this.bookRepository = bookRepository;
        this.libraryMemberRepository = libraryMemberRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.borrowingRecordRepository.count() > 0;
    }

    @Override
    public String readBorrowingRecordsFromFile() throws IOException {
        return new String(Files.readAllBytes(Path.of(FILE_PATH)));
    }

    @Override
    public String importBorrowingRecords() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        JAXBContext jaxbContext = JAXBContext.newInstance(BorrowingRecordSeedRootDto.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        BorrowingRecordSeedRootDto borrowingRecordSeedRootDto = (BorrowingRecordSeedRootDto) unmarshaller.unmarshal(new File(FILE_PATH));

        for (BorrowingRecordSeedDto borrowingRecordSeedDto : borrowingRecordSeedRootDto.getBorrowingRecordSeedDtoList()) {
            Optional<Book> optionalBook = this.bookRepository.findByTitle(borrowingRecordSeedDto.getBookSeedXmlDto().getTitle());
            Optional<LibraryMember> optionalLibraryMember = this.libraryMemberRepository.findById(borrowingRecordSeedDto.getMemberSeedXmlDto().getId());

            if (!this.validationUtil.isValid(borrowingRecordSeedDto) || optionalBook.isEmpty() || optionalLibraryMember.isEmpty()) {
                sb.append("Invalid borrowing record\n");

                continue;
            }

            BorrowingRecord borrowingRecord = this.modelMapper.map(borrowingRecordSeedDto, BorrowingRecord.class);
            borrowingRecord.setBook(optionalBook.get());
            borrowingRecord.setLibraryMember(optionalLibraryMember.get());

            this.borrowingRecordRepository.saveAndFlush(borrowingRecord);

            sb.append(String.format("Successfully imported borrowing record %s - %s\n",
                    borrowingRecord.getBook().getTitle(),
                    borrowingRecord.getBorrowDate()));
        }


        return sb.toString();
    }

    @Override
    public String exportBorrowingRecords() {
        StringBuilder sb = new StringBuilder();
        Set<BorrowingRecord> records = this.borrowingRecordRepository.findAllByBorrowDateBeforeAndBook_GenreOrderByBorrowDateDesc(LocalDate.parse("2021-09-10"), Genre.SCIENCE_FICTION);

        records.forEach(borrowingRecord -> {
            sb.append(String.format("Book title: %s\n" +
                    "*Book author: %s\n" +
                    "**Date borrowed: %s\n" +
                    "***Borrowed by: %s %s",
                    borrowingRecord.getBook().getTitle(),
                    borrowingRecord.getBook().getAuthor(),
                    borrowingRecord.getBorrowDate().toString(),
                    borrowingRecord.getLibraryMember().getFirstName(),
                    borrowingRecord.getLibraryMember().getLastName()))
                    .append(System.lineSeparator());
        });

        return sb.toString().trim();
    }
}
