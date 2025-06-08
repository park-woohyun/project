public class ParkingLot {
    String name;
    int electricSpots;
    int generalSpots;
    int truckSpots;
    boolean underground;
    String heightLimit;

    public ParkingLot(String name, int electricSpots, int generalSpots, int truckSpots, boolean underground, String heightLimit) {
        this.name = name;
        this.electricSpots = electricSpots;
        this.generalSpots = generalSpots;
        this.truckSpots = truckSpots;
        this.underground = underground;
        this.heightLimit = heightLimit;
    }

    public void showDetails() {
        System.out.println(" 주차장: " + name);
        System.out.println(" 일반차 자리: " + generalSpots);
        System.out.println(" 전기차 충전 자리: " + electricSpots);
        System.out.println(" 트럭 자리: " + truckSpots);
        System.out.println(" 지하 주차장 여부: " + (underground ? "예" : "아니오"));
        System.out.println(" 차량 높이 제한: " + heightLimit);
    }
}
