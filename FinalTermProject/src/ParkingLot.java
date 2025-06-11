public class ParkingLot {
    String id;               // A~M
    String name;
    int electricSpots;
    int generalSpots;
    int truckSpots;
    boolean hasCharger;
    boolean isUnderground;
    String heightLimit;
    String nearbyBuilding;

    public ParkingLot(String id, String name, int electricSpots, int generalSpots, int truckSpots,
                      boolean hasCharger, boolean isUnderground, String heightLimit, String nearbyBuilding) {
        this.id = id;
        this.name = name;
        this.electricSpots = electricSpots;
        this.generalSpots = generalSpots;
        this.truckSpots = truckSpots;
        this.hasCharger = hasCharger;
        this.isUnderground = isUnderground;
        this.heightLimit = heightLimit;
        this.nearbyBuilding = nearbyBuilding;
    }

    public void showDetails() {
        System.out.println("주차장: " + name + " (" + id + ")");
        System.out.println("승용차 자리: " + generalSpots);
        System.out.println("전기차 충전 자리: " + electricSpots + (hasCharger ? " (충전 가능)" : ""));
        System.out.println("트럭 자리: " + truckSpots);
        System.out.println("가장 가까운 건물 번호: " + nearbyBuilding);
        System.out.println("위치: " + (isUnderground ? "건물 1층 주차장(H)" : "일반 주차장"));
        System.out.println("차량 높이 제한: " + heightLimit);
    }
}
