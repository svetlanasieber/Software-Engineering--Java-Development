package softuni.exam.models.dto.volcano;

import com.google.gson.annotations.JsonAdapter;
import softuni.exam.models.enums.VolcanoType;
import softuni.exam.util.LocalDateAdapter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

public class VolcanoSeedDto implements Serializable {

    @NotNull
    @Size(min = 2, max = 30)
    private String name;

    @NotNull
    @Positive
    private Integer elevation;

    private VolcanoType volcanoType;

    @NotNull
    private boolean isActive;

    @JsonAdapter(LocalDateAdapter.class)
    private LocalDate lastEruption;

    private Long country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getElevation() {
        return elevation;
    }

    public void setElevation(Integer elevation) {
        this.elevation = elevation;
    }

    public VolcanoType getVolcanoType() {
        return volcanoType;
    }

    public void setVolcanoType(VolcanoType volcanoType) {
        this.volcanoType = volcanoType;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public LocalDate getLastEruption() {
        return lastEruption;
    }

    public void setLastEruption(LocalDate lastEruption) {
        this.lastEruption = lastEruption;
    }

    public Long getCountry() {
        return country;
    }

    public void setCountry(Long country) {
        this.country = country;
    }
}
