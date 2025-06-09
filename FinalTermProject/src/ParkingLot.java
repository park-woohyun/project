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
}