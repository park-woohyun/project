import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ParkingManager manager = new ParkingManager();

        System.out.println("🚘 캠퍼스 주차장 안내 시스템 실행");
        System.out.println("총 차량 대수: 150대 (모의 데이터)");
        System.out.println("총 주차 가능 대수: 200대 (모의 데이터)\n");

        System.out.print("차량 차종을 선택하세요 (전기차/일반차/트럭): ");
        String carType = sc.nextLine();

        System.out.print("방문할 건물 번호 (예: 06): ");
        int buildingCode = sc.nextInt(); sc.nextLine();

        manager.recommendLots(carType, buildingCode);

        System.out.print("\n상세 정보를 볼 주차장을 입력하세요 (예: P2 지하B): ");
        String selectedLot = sc.nextLine();


        ParkingLot lot = manager.getLotByName(selectedLot);
        if (lot != null) {
            System.out.println("\n📄 선택한 주차장 세부 정보:");
            lot.showDetails();
        } else {
            System.out.println("❌ 해당 이름의 주차장이 없습니다.");
        }

        System.out.println("\n프로그램 종료. 안전운전하세요!");
    }
}
