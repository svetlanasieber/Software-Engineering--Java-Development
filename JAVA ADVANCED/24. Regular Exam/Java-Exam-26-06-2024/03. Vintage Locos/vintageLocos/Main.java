package vintageLocos;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        TrainStation deptford = new TrainStation("Deptford Train station", 5, 1435);
        TrainStation euston = new TrainStation("Euston", 2, 1524);

        Locomotive puffingBilly = new Locomotive("Puffing Billy", "Jonathan Forster", LocalDate.of(1814, 1, 1), 1524, 8250, 8);
        Locomotive flyingScotsman = new Locomotive("Flying Scotsman", "Doncaster Works", LocalDate.of(1923, 2, 14), 1435, 96250, 161);
        Locomotive cityOfTruro = new Locomotive("City of Truro", "GWR Swindon Works", LocalDate.of(1903, 4, 1), 1435, 56200, 160);

        deptford.addLocomotive(flyingScotsman);
        deptford.addLocomotive(puffingBilly);
        deptford.addLocomotive(cityOfTruro);

        euston.addLocomotive(puffingBilly);

        System.out.println(euston.removeLocomotive("Puffing Billy"));
        System.out.println(euston.removeLocomotive("Silver Star"));
        System.out.println(deptford.getFastestLocomotive());
        System.out.println(euston.getFastestLocomotive());
        System.out.println(euston.getOldestLocomotive());
        System.out.println(deptford.getLocomotive("Flying Scotsman"));
        System.out.println(deptford.getOldestLocomotive());
        System.out.println(deptford.getCount());
        System.out.println(deptford.getStatistics());
        System.out.println(euston.getStatistics());
    }
}
