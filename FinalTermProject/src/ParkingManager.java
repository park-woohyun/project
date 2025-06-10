import java.util.*;

public class ParkingManager {
    List<ParkingLot> lots = new ArrayList<>();

    public ParkingManager() {
        lots.add(new ParkingLot("A", "A 주차장", 2, 10, 2, false, false, "2.3m", 1));
        lots.add(new ParkingLot("B", "B 주차장", 1, 8, 1, false, false, "2.2m", 3));
        lots.add(new ParkingLot("C", "C 주차장", 6, 10, 1, true, false, "2.3m", 11)); // 전기차 충전
        lots.add(new ParkingLot("D", "D 주차장", 2, 7, 2, false, false, "2.3m", 14));
        lots.add(new ParkingLot("E", "E 주차장", 2, 6, 2, false, false, "2.2m", 20));
        lots.add(new ParkingLot("F", "F 주차장", 0, 10, 3, false, false, "2.1m", 20));
        lots.add(new ParkingLot("G", "G 주차장", 0, 12, 3, false, false, "2.0m", 13));
        lots.add(new ParkingLot("H", "H 주차장", 2, 15, 2, false, true, "제한 없음", 8));  // 건물 1층
        lots.add(new ParkingLot("I", "I 주차장", 1, 7, 2, false, false, "2.1m", 50));
        lots.add(new ParkingLot("J", "J 주차장", 1, 6, 1, false, false, "2.2m", 38));
        lots.add(new ParkingLot("K", "K 주차장", 1, 5, 2, false, false, "2.3m", 48));
        lots.add(new ParkingLot("L", "L 주차장", 1, 6, 2, false, false, "2.3m", 47));
        lots.add(new ParkingLot("M", "M 주차장", 2, 7, 3, false, false, "2.4m", 51));
    }

    public void recommendLots(String carType, boolean needCharging, int buildingCode) {
        if (carType.equals("전기차") && needCharging) {
            System.out.println("\n  전기차 충전이 필요한 경우 → 추천 주차장: C");
            getLotById("C").showDetails();
            return;
        }

        System.out.println("\n 건물 [" + buildingCode + "] 주변 추천 주차장:");
        lots.sort(Comparator.comparingInt(l -> l.distanceFrom(buildingCode)));

        int count = 0;
        for (ParkingLot lot : lots) {
            if (isCompatible(lot, carType)) {
                System.out.printf("%d. %s (%s) - 남은 자리: %d\n", (count + 1), lot.name, lot.id, getAvailable(lot, carType));
                count++;
            }
            if (count == 3) break;
        }
    }

    private boolean isCompatible(ParkingLot lot, String carType) {
        return switch (carType) {
            case "전기차" -> lot.electricSpots > 0;
            case "일반차" -> lot.generalSpots > 0;
            case "트럭" -> lot.truckSpots > 0;
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
