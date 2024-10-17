package softuni.exam.service.impl;


import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.volcano.VolcanoSeedDto;
import softuni.exam.models.entity.Country;
import softuni.exam.models.entity.Volcano;
import softuni.exam.repository.CountryRepository;
import softuni.exam.repository.VolcanoRepository;
import softuni.exam.service.VolcanoService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Service
public class VolcanoServiceImpl implements VolcanoService {
    private static final String VOLCANO_FILE_PATH = "src/main/resources/files/json/volcanoes.json";
    private final VolcanoRepository volcanoRepository;
    private final CountryRepository countryRepository;
    private final ValidationUtil validationUtil;
    private final StringBuilder stringBuilder;
    private final ModelMapper modelMapper;
    private final Gson gson;

    public VolcanoServiceImpl(VolcanoRepository volcanoRepository, CountryRepository countryRepository, ValidationUtil validationUtil, StringBuilder stringBuilder, ModelMapper modelMapper, Gson gson) {
        this.volcanoRepository = volcanoRepository;
        this.countryRepository = countryRepository;
        this.validationUtil = validationUtil;
        this.stringBuilder = stringBuilder;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return this.volcanoRepository.count() > 0;
    }

    @Override
    public String readVolcanoesFileContent() throws IOException {
        return Files.readString(Path.of(VOLCANO_FILE_PATH));
    }

    @Override
    public String importVolcanoes() throws IOException {
        VolcanoSeedDto[] volcanoSeedDtos = this.gson.fromJson(readVolcanoesFileContent(), VolcanoSeedDto[].class);
        for (VolcanoSeedDto volcanoSeedDto : volcanoSeedDtos) {
            Optional<Volcano> optionalVolcano = this.volcanoRepository.findByName(volcanoSeedDto.getName());
            Optional<Country> optionalCountry = this.countryRepository.findById(volcanoSeedDto.getCountry());

            if (!this.validationUtil.isValid(volcanoSeedDto) || optionalVolcano.isPresent() || optionalCountry.isEmpty()) {
                stringBuilder.append("Invalid volcano\n");
                continue;
            }
            Volcano volcano = this.modelMapper.map(volcanoSeedDto, Volcano.class);
            volcano.setCountry(optionalCountry.get());

            this.volcanoRepository.saveAndFlush(volcano);

            stringBuilder.append(String.format("Successfully imported volcano %s of type %s\n",
                    volcano.getName(), volcano.getVolcanoType()));

        }


        return stringBuilder.toString();
    }

    @Override
    public String exportVolcanoes() {
        List<Volcano> result = this.volcanoRepository.findAllByIsActiveAndElevationGreaterThanAndLastEruptionNotNullOrderByElevationDesc(true, 3000);
        result.forEach(volcano -> {
            stringBuilder.append(String.format("Volcano: %s\n" +
                    "   *Located in: %s\n" +
                    "   **Elevation: %d\n" +
                    "   ***Last eruption on: %s",
                            volcano.getName(),
                            volcano.getCountry().getName(),
                            volcano.getElevation(),
                            volcano.getLastEruption()))
                    .append(System.lineSeparator());
        });


        return stringBuilder.toString().trim();
    }
}