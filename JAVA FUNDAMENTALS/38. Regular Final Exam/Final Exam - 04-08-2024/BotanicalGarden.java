import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BotanicalGarden {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Plant> plants = new HashMap<>();
        Map<String, Integer> sections = new HashMap<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("EndDay")) {
                break;
            }

            String[] parts = input.split(": ");
            String command = parts[0];
            String[] details = parts[1].split("-");

            switch (command) {
                case "Plant":
                    String plantName = details[0];
                    int waterNeeded = Integer.parseInt(details[1]);
                    String section = details[2];

                    if (!plants.containsKey(plantName)) {
                        plants.put(plantName, new Plant(plantName, waterNeeded, section));
                        sections.putIfAbsent(section, 0);
                        sections.put(section, sections.get(section) + 1);
                    } else {
                        Plant plant = plants.get(plantName);
                        plant.increaseWater(waterNeeded);
                    }
                    break;

                case "Water":
                    plantName = details[0];
                    int waterAmount = Integer.parseInt(details[1]);

                    if (plants.containsKey(plantName)) {
                        Plant plant = plants.get(plantName);
                        plant.decreaseWater(waterAmount);

                        if (plant.isSufficientlyWatered()) {
                            System.out.printf("%s has been sufficiently watered.%n", plantName);
                            sections.put(plant.getSection(), sections.get(plant.getSection()) - 1);
                            if (sections.get(plant.getSection()) == 0) {
                                sections.remove(plant.getSection());
                            }
                            plants.remove(plantName);
                        }
                    }
                    break;
            }
        }

        System.out.println("Plants needing water:");
        for (Plant plant : plants.values()) {
            System.out.printf(" %s -> %dml left%n", plant.getName(), plant.getWaterNeeded());
        }

        System.out.println("Sections with thirsty plants:");
        for (Map.Entry<String, Integer> entry : sections.entrySet()) {
            System.out.printf(" %s: %d%n", entry.getKey(), entry.getValue());
        }
    }

    static class Plant {
        private String name;
        private int waterNeeded;
        private String section;

        public Plant(String name, int waterNeeded, String section) {
            this.name = name;
            this.waterNeeded = waterNeeded;
            this.section = section;
        }

        public String getName() {
            return name;
        }

        public int getWaterNeeded() {
            return waterNeeded;
        }

        public String getSection() {
            return section;
        }

        public void increaseWater(int amount) {
            this.waterNeeded += amount;
        }

        public void decreaseWater(int amount) {
            this.waterNeeded -= amount;
        }

        public boolean isSufficientlyWatered() {
            return this.waterNeeded <= 0;
        }
    }
}
