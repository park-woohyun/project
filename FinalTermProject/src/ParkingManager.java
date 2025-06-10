
import java.util.*;

public class ParkingManager {
    List<ParkingLot> lots = new ArrayList<>();

    public ParkingManager() {
        // ▶ 주차장 등록 (임시값)
        lots.add(new ParkingLot("P1 지상A", 3, 10, 2, false, "2.3m"));
        lots.add(new ParkingLot("P2 지하B", 5, 15, 1, true, "2.1m"));
        lots.add(new ParkingLot("P3 건물C", 2, 5, 3, true, "2.5m"));
        lots.add(new ParkingLot("P4 외곽D", 0, 8, 5, false, "제한없음"));
        lots.add(new ParkingLot("P5 옆건물E", 4, 7, 2, false, "2.4m"));
    }
    public void recommendLots(String carType, int buildingCode) {
        System.out.println("\n 건물 번호 [" + buildingCode + "] 근처 추천 주차장:");

        // 간단한 거리 기준: buildingCode의 차이가 가장 적은 주차장 3개 반환
        lots.sort(Comparator.comparingInt(l -> Math.abs(buildingCode - lots.indexOf(l))));

        int count = 0;
        for (ParkingLot lot : lots) {
            if (isCompatible(lot, carType)) {
                System.out.println((count + 1) + ". " + lot.name + " - 남은 자리: " + getAvailable(lot, carType));
                count++;
                if (count >= 3) break;
            }
        }

        if (count == 0) System.out.println("조건에 맞는 주차장이 없습니다.");
    }

}