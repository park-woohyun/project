import java.util.*;

public class ParkingManager {
    List<ParkingLot> lots = new ArrayList<>();
    public Map<Integer, List<String>> buildingToLots = new HashMap<>();

    public ParkingManager() {
        lots.add(new ParkingLot("A", "A 주차장", 2, 10, 2, false, false, "2.3m", 1));
        lots.add(new ParkingLot("B", "B 주차장", 1, 8, 1, false, false, "2.2m", 3));
        lots.add(new ParkingLot("C", "C 주차장", 6, 10, 1, true, false, "2.3m", 11));
        lots.add(new ParkingLot("D", "D 주차장", 2, 7, 2, false, false, "2.3m", 14));
        lots.add(new ParkingLot("E", "E 주차장", 2, 6, 2, false, false, "2.2m", 20));
        lots.add(new ParkingLot("F", "F 주차장", 0, 10, 3, false, false, "2.1m", 20));
        lots.add(new ParkingLot("G", "G 주차장", 0, 12, 3, false, false, "2.0m", 13));
        lots.add(new ParkingLot("H", "H 주차장", 2, 15, 2, false, true, "제한 없음", 8));
        lots.add(new ParkingLot("I", "I 주차장", 1, 7, 2, false, false, "2.1m", 50));
        lots.add(new ParkingLot("J", "J 주차장", 1, 6, 1, false, false, "2.2m", 38));
        lots.add(new ParkingLot("K", "K 주차장", 1, 5, 2, false, false, "2.3m", 48));
        lots.add(new ParkingLot("L", "L 주차장", 1, 6, 2, false, false, "2.3m", 47));
        lots.add(new ParkingLot("M", "M 주차장", 2, 7, 3, false, false, "2.4m", 51));

        buildingToLots.put(1, Arrays.asList("A", "B", "C"));
        buildingToLots.put(2, Arrays.asList("C", "B", "D"));
        buildingToLots.put(3, Arrays.asList("A", "C", "B"));
        buildingToLots.put(4, Arrays.asList("B", "D", "E"));
        buildingToLots.put(5, Arrays.asList("D", "B", "E"));
        buildingToLots.put(6, Arrays.asList("B", "C", "D"));
        buildingToLots.put(7, Arrays.asList("D", "C"));
        buildingToLots.put(8, Arrays.asList("D", "H", "E"));
        buildingToLots.put(9, Arrays.asList("F", "G", "H"));
        buildingToLots.put(10, Arrays.asList("F", "G", "H"));
        buildingToLots.put(11, Arrays.asList("B", "C", "D"));
        buildingToLots.put(12, Arrays.asList("I", "J"));
        buildingToLots.put(13, Arrays.asList("F", "G", "H"));
        buildingToLots.put(14, Arrays.asList("C", "D"));
        buildingToLots.put(16, Arrays.asList("A", "B"));
        buildingToLots.put(18, Arrays.asList("B", "C"));
        buildingToLots.put(20, Arrays.asList("E", "F", "H"));
        buildingToLots.put(23, Arrays.asList("A"));
        buildingToLots.put(26, Arrays.asList("L", "M"));
        buildingToLots.put(31, Arrays.asList("L", "M"));
        buildingToLots.put(32, Arrays.asList("L", "M"));
        buildingToLots.put(35, Arrays.asList("L", "M"));
        buildingToLots.put(36, Arrays.asList("K", "L"));
        buildingToLots.put(37, Arrays.asList("K", "L"));
        buildingToLots.put(38, Arrays.asList("I", "J"));
        buildingToLots.put(39, Arrays.asList("I", "J"));
        buildingToLots.put(40, Arrays.asList("D", "I", "J"));
        buildingToLots.put(42, Arrays.asList("C", "D"));
        buildingToLots.put(43, Arrays.asList("K", "L"));
        buildingToLots.put(46, Arrays.asList("D", "I"));
        buildingToLots.put(47, Arrays.asList("K", "L"));
        buildingToLots.put(48, Arrays.asList("K", "L"));
        buildingToLots.put(49, Arrays.asList("K", "L"));
        buildingToLots.put(50, Arrays.asList("I", "J"));
        buildingToLots.put(51, Arrays.asList("M"));
        buildingToLots.put(93, Arrays.asList("B", "E", "F"));
        buildingToLots.put(98, Arrays.asList("A"));
    }

    public void recommendLots(String carType, boolean needCharging, int buildingCode) {
        if (carType.equals("전기차") && needCharging) {
            System.out.println("\n 전기차 충전이 필요한 경우 → 추천 주차장: C");
            getLotById("C").showDetails();
            return;
        }

        System.out.println("\n  건물 [" + buildingCode + "] 주변 추천 주차장:");
        List<String> recommended = buildingToLots.getOrDefault(buildingCode, new ArrayList<>());
        int count = 0;

        for (String id : recommended) {
            ParkingLot lot = getLotById(id);
            if (lot != null && isCompatible(lot, carType)) {
                System.out.printf("%d. %s (%s) - 남은 자리: %d\n", (count + 1), lot.name, lot.id, getAvailable(lot, carType));
                count++;
            }
        }

        if (count == 0) {
            System.out.println("조건에 맞는 주차장이 없습니다.");
        }
    }

    private boolean isCompatible(ParkingLot lot, String carType) {
        return switch (carType) {
            case "전기차" -> lot.electricSpots > 0;
            case "일반차" -> lot.generalSpots > 0;
            case "트럭" -> lot.truckSpots > 0 && !lot.isUnderground;
            default -> false;
        };
    }

    private int getAvailable(ParkingLot lot, String carType) {
        return switch (carType) {
            case "전기차" -> lot.electricSpots;
            case "일반차" -> lot.generalSpots;
            case "트럭" -> lot.truckSpots;
            default -> 0;
        };
    }

    public ParkingLot getLotById(String id) {
        for (ParkingLot lot : lots) {
            if (lot.id.equalsIgnoreCase(id)) return lot;
        }
        return null;
    }
}
