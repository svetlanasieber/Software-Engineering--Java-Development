package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.json.BookSeedDto;
import softuni.exam.models.entity.Book;
import softuni.exam.repository.BookRepository;
import softuni.exam.service.BookService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private static final String FILE_PATH = "src/main/resources/files/json/books.json";

    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;

    public BookServiceImpl(BookRepository bookRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }


    @Override
    public boolean areImported() {
        return this.bookRepository.count() > 0;
    }

    @Override
    public String readBooksFromFile() throws IOException {
        return new String(Files.readAllBytes(Path.of(FILE_PATH)));
    }

    @Override
    public String importBooks() throws IOException {
        StringBuilder sb = new StringBuilder();
        BookSeedDto[] bookSeedDto = this.gson.fromJson(readBooksFromFile(), BookSeedDto[].class);

        for (BookSeedDto seedDto : bookSeedDto) {
            Optional<Book> byTitle = this.bookRepository.findByTitle(seedDto.getTitle());

            if (!this.validationUtil.isValid(seedDto) || byTitle.isPresent()) {
                sb.append("Invalid book\n");

                continue;
            }

            Book book = this.modelMapper.map(seedDto, Book.class);
            this.bookRepository.saveAndFlush(book);
            sb.append(String.format("Successfully imported book %s - %s\n", book.getAuthor(), book.getTitle()));
        }
        return sb.toString();
    }
}
