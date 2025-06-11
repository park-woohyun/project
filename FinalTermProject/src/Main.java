import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ParkingManager manager = new ParkingManager();

        System.out.println("청주대학교 캠퍼스 주차 안내 시스템");
        System.out.println("총 차량 수: 145대 (모의)");
        System.out.println("총 주차 가능 수: 180대 (모의)\n");

        // 차량 종류 입력
        String carType = "";
        int attempts = 0;
        while (attempts < 3) {
            System.out.print("차량 종류 입력 (전기차 / 승용차 / 트럭): ");
            carType = sc.nextLine().trim();
            if (carType.equals("전기차") || carType.equals("승용차") || carType.equals("트럭")) break;
            attempts++;
            System.out.println("잘못된 입력입니다.");
        }
        if (attempts == 3) {
            System.out.println("잘못 입력하셨습니다. 종료합니다.");
            return;
        }

        boolean needCharging = false;
        if (carType.equals("전기차")) {
            System.out.print("전기차 충전이 필요합니까? (예/아니오): ");
            String ans = sc.nextLine().trim();
            needCharging = ans.equalsIgnoreCase("예");
        }

        // 건물 번호 입력
        int buildingCode = -1;
        attempts = 0;
        while (attempts < 3) {
            System.out.print("방문할 건물 번호를 입력하세요: ");
            try {
                buildingCode = Integer.parseInt(sc.nextLine().trim());
                if (manager.buildingToLots.containsKey(buildingCode)) break;
            } catch (NumberFormatException ignored) {}
            attempts++;
            System.out.println("존재하지 않는 건물 번호입니다.");
        }
        if (attempts == 3) {
            System.out.println("잘못 입력하셨습니다. 종료합니다.");
            return;
        }

        manager.recommendLots(carType, needCharging, buildingCode);

        // 주차장 ID 입력
        String selected = "";
        ParkingLot selectedLot = null;
        attempts = 0;
        while (attempts < 3) {
            System.out.print("\n자세히 보고 싶은 주차장 ID 입력 (예: C): ");
            selected = sc.nextLine().trim().toUpperCase();
            selectedLot = manager.getLotById(selected);
            if (selectedLot != null) break;
            attempts++;
            System.out.println("존재하지 않는 주차장입니다.");
        }
        if (attempts == 3) {
            System.out.println("잘못 입력하셨습니다. 종료합니다.");
            return;
        }

        System.out.println("\n 주차장 세부 정보:");
        selectedLot.showDetails();
        System.out.println("\n 안전 운전하세요!");
    }
}
