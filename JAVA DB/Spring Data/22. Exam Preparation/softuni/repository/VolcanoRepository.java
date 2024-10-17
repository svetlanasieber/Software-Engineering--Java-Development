package softuni.exam.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Volcano;

import java.util.List;
import java.util.Optional;

@Repository
public interface VolcanoRepository extends JpaRepository<Volcano, Long> {

    Optional<Volcano> findByName(String name);

//    @Query(value = "SELECT v FROM Volcano v " +
//            "WHERE v.isActive = true AND v.elevation > 3000 " +
//            "ORDER BY v.elevation desc ")
    List<Volcano> findAllByIsActiveAndElevationGreaterThanAndLastEruptionNotNullOrderByElevationDesc(boolean isActive, Integer elevation);

}
