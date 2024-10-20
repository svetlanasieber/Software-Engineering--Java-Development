package furnitureFactory.repositories;

import furnitureFactory.entities.workshops.Workshop;

public interface WorkshopRepository {
    void add(Workshop workshop);
    boolean remove(Workshop workshop);
    Workshop findByType(String type);
}

