package softuni.exam.models.entity;


import softuni.exam.models.enums.VolcanoType;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "volcanoes")
public class Volcano extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Integer elevation;

    @Column(name = "volcano_type")
    @Enumerated(value = EnumType.STRING)
    private VolcanoType volcanoType;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @Column(name = "last_eruption")
    private LocalDate lastEruption;

    @ManyToOne
    private Country country;

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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
