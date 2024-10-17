package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.json.LibraryMemberSeedDto;
import softuni.exam.models.entity.LibraryMember;
import softuni.exam.repository.LibraryMemberRepository;
import softuni.exam.service.LibraryMemberService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
public class LibraryMemberServiceImpl implements LibraryMemberService {

    private static final String FILE_PATH = "src/main/resources/files/json/library-members.json";

    private final LibraryMemberRepository libraryMemberRepository;
    private final ValidationUtil validationUtil;
    private final Gson gson;
    private final ModelMapper modelMapper;

    public LibraryMemberServiceImpl(LibraryMemberRepository libraryMemberRepository, ValidationUtil validationUtil, Gson gson, ModelMapper modelMapper) {
        this.libraryMemberRepository = libraryMemberRepository;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.libraryMemberRepository.count() > 0;
    }

    @Override
    public String readLibraryMembersFileContent() throws IOException {
        return new String(Files.readAllBytes(Path.of(FILE_PATH)));
    }

    @Override
    public String importLibraryMembers() throws IOException {
        StringBuilder sb = new StringBuilder();
        LibraryMemberSeedDto[] libraryMemberSeedDtos = gson.fromJson(readLibraryMembersFileContent(), LibraryMemberSeedDto[].class);

        for (LibraryMemberSeedDto memberSeedDto : libraryMemberSeedDtos) {
            Optional<LibraryMember> byPhoneNumber = this.libraryMemberRepository.findByPhoneNumber(memberSeedDto.getPhoneNumber());

            if (!this.validationUtil.isValid(memberSeedDto) || byPhoneNumber.isPresent()) {
                sb.append("Invalid library member\n");

                continue;
            }

            LibraryMember libraryMember = this.modelMapper.map(memberSeedDto, LibraryMember.class);

            this.libraryMemberRepository.saveAndFlush(libraryMember);

            sb.append(String.format("Successfully imported library member %s - %s\n",
                    memberSeedDto.getFirstName(),
                    memberSeedDto.getLastName()));
        }


        return sb.toString();
    }
}
