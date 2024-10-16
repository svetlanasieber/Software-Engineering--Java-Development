package vintageLocos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TrainStation {
    private String name;
    private int capacity;
    private int railGauge;
    private List<Locomotive> locomotives;

    public TrainStation(String name, int capacity, int railGauge) {
        this.name = name;
        this.capacity = capacity;
        this.railGauge = railGauge;
        this.locomotives = new ArrayList<>();
    }

    public void addLocomotive(Locomotive locomotive) {
        if (locomotives.size() >= capacity) {
            System.out.println("This train station is full!");
        } else if (railGauge != locomotive.getGauge()) {
            System.out.println("The rail gauge of this station does not match the locomotive gauge! Difference: " +
                    Math.abs(railGauge - locomotive.getGauge()) + " mm.");
        } else {
            locomotives.add(locomotive);
        }
    }

    public boolean removeLocomotive(String name) {
        for (Locomotive locomotive : locomotives) {
            if (locomotive.getName().equals(name)) {
                locomotives.remove(locomotive);
                return true;
            }
        }
        return false;
    }

    public String getFastestLocomotive() {
        if (locomotives.isEmpty()) {
            return "There are no locomotives.";
        }
        Locomotive fastest = locomotives.stream()
                .max(Comparator.comparingInt(Locomotive::getMaxSpeed))
                .orElse(null);
        return fastest.getName() + " is the fastest locomotive with a maximum speed of " + fastest.getMaxSpeed() + " km/h.";
    }

    public Locomotive getLocomotive(String name) {
        for (Locomotive locomotive : locomotives) {
            if (locomotive.getName().equals(name)) {
                return locomotive;
            }
        }
        return null;
    }

    public int getCount() {
        return locomotives.size();
    }

    public String getOldestLocomotive() {
        if (locomotives.isEmpty()) {
            return "There are no locomotives.";
        }
        Locomotive oldest = locomotives.stream()
                .min(Comparator.comparing(Locomotive::getBuildDate))
                .orElse(null);
        return oldest.getName();
    }

    public String getStatistics() {
        if (locomotives.isEmpty()) {
            return "There are no locomotives departing from " + name + " station.";
        }

        StringBuilder stats = new StringBuilder("Locomotives departed from " + name + ":");
        for (int i = 0; i < locomotives.size(); i++) {
            stats.append("\n").append((i + 1)).append(". ").append(locomotives.get(i).getName());
        }
        return stats.toString();
    }
}
