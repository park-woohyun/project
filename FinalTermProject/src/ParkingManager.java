
import java.util.*;

public class ParkingManager {
    List<ParkingLot> lots = new ArrayList<>();

    public ParkingManager() {
        // ▶ 주차장 등록
        lots.add(new ParkingLot("P1 지상A", 3, 10, 2, false, "2.3m"));
        lots.add(new ParkingLot("P2 지하B", 5, 15, 1, true, "2.1m"));
        lots.add(new ParkingLot("P3 건물C", 2, 5, 3, true, "2.5m"));
        lots.add(new ParkingLot("P4 외곽D", 0, 8, 5, false, "제한없음"));
        lots.add(new ParkingLot("P5 옆건물E", 4, 7, 2, false, "2.4m"));
    }
}