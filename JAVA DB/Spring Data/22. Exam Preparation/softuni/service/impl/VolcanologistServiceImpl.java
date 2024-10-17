package softuni.exam.service.impl;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.volcanologist.VolcanologistSeedDto;
import softuni.exam.models.dto.volcanologist.VolcanologistSeedRootDto;
import softuni.exam.models.entity.Volcano;
import softuni.exam.models.entity.Volcanologist;
import softuni.exam.repository.VolcanoRepository;
import softuni.exam.repository.VolcanologistRepository;
import softuni.exam.service.VolcanologistService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
public class VolcanologistServiceImpl implements VolcanologistService {

    private static final String VOLCANOLOGIST_FILE_PATH = "src/main/resources/files/xml/volcanologists.xml";
    private final VolcanologistRepository volcanologistRepository;
    private final VolcanoRepository volcanoRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final StringBuilder stringBuilder;

    public VolcanologistServiceImpl(VolcanologistRepository volcanologistRepository, VolcanoRepository volcanoRepository, ValidationUtil validationUtil, ModelMapper modelMapper, StringBuilder stringBuilder, XmlParser xmlParser) {
        this.volcanologistRepository = volcanologistRepository;
        this.volcanoRepository = volcanoRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.stringBuilder = stringBuilder;
    }

    @Override
    public boolean areImported() {
        return this.volcanologistRepository.count() > 0;
    }

    @Override
    public String readVolcanologistsFromFile() throws IOException {
        return Files.readString(Path.of(VOLCANOLOGIST_FILE_PATH));
    }

    @Override
    public String importVolcanologists() throws IOException, JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(VolcanologistSeedRootDto.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        VolcanologistSeedRootDto volcanologistSeedRootDto = (VolcanologistSeedRootDto) unmarshaller.unmarshal(new File(VOLCANOLOGIST_FILE_PATH));

        for (VolcanologistSeedDto volcanologistSeedDto : volcanologistSeedRootDto.getVolcanologistSeedDtoList()) {
            Optional<Volcanologist> byFirstName = this.volcanologistRepository.findByFirstName(volcanologistSeedDto.getFirstName());
            Optional<Volcanologist> byLastName = this.volcanologistRepository.findByLastName(volcanologistSeedDto.getLastName());
            Optional<Volcano> optionalVolcano = this.volcanoRepository.findById(volcanologistSeedDto.getExploringVolcanoId());

            if (!this.validationUtil.isValid(volcanologistSeedDto) || byFirstName.isPresent() || byLastName.isPresent() || optionalVolcano.isEmpty()) {
                stringBuilder.append("Invalid volcanologist\n");
                continue;
            }
            Volcanologist volcanologist = this.modelMapper.map(volcanologistSeedDto, Volcanologist.class);
            volcanologist.setVolcano(optionalVolcano.get());

            this.volcanologistRepository.saveAndFlush(volcanologist);

            stringBuilder.append(String.format("Successfully imported volcanologist %s %s\n",
                    volcanologist.getFirstName(), volcanologist.getLastName()));


        }


        return stringBuilder.toString();
    }
}