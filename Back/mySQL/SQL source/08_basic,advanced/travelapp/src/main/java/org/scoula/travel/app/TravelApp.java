package org.scoula.travel.app;

import org.scoula.database.JDBCUtil;
import org.scoula.travel.dao.TravelDao;
import org.scoula.travel.dao.TravelDaoImpl;
import org.scoula.travel.service.TravelService;
import org.scoula.travel.service.TravelServiceImpl;

import java.util.Scanner;

// 콘솔 기반 관광지 애플리케이션 실행 클래스
public class TravelApp {

    // 서비스 계층
    TravelService service;

    // 메뉴 항목 배열 (메뉴 이름 + 실행할 메서드)
    MenuItem[] menu;

    // 사용자 입력을 위한 Scanner
    Scanner sc = new Scanner(System.in);

    // 생성자: DAO 생성 → 서비스 주입 → 메뉴 배열 구성
    public TravelApp() {
        TravelDao dao = new TravelDaoImpl();                   // DAO 구현체 생성
        service = new TravelServiceImpl(dao);                  // Service에 DAO 주입
        menu = new MenuItem[]{                                 // 콘솔 메뉴 구성
                new MenuItem("전체목록", service::printTravels),
                new MenuItem("페이지목록", service::printTravelsByPage),
                new MenuItem("권역별목록", service::printTravelsByDistrict),
                new MenuItem("상세보기", service::printTravel),
                new MenuItem("종료", this::exit),
        };
    }

    // 종료 처리: Scanner, DB 연결 해제 후 프로그램 종료
    public void exit() {
        sc.close();           // 입력 스트림 종료
        JDBCUtil.close();     // DB 연결 해제
        System.exit(0);       // 프로그램 종료
    }

    // 메뉴 출력
    public void printMenu() {
        System.out.println("==========================================================================");
        for (int i = 0; i < menu.length; i++) {
            MenuItem menuItem = menu[i];
            System.out.printf("%d) %s ", i + 1, menuItem.getTitle()); // ex: 1) 전체목록
        }
        System.out.println();
        System.out.println("==========================================================================");
    }

    // 사용자로부터 메뉴 번호 입력받기
    public int getMenuIndex() {
        System.out.print("선택: ");
        String line = sc.nextLine();               // 사용자 입력
        int ix = Integer.parseInt(line) - 1;       // 배열 인덱스로 변환
        return ix;
    }

    // 프로그램 메인 루프: 메뉴 출력 → 입력 → 해당 기능 실행
    public void run() {
        while (true) {
            printMenu();                           // 메뉴 표시
            int ix = getMenuIndex();               // 메뉴 선택
            Runnable command = menu[ix].getCommand(); // 해당 명령 가져오기
            command.run();                         // 실행
        }
    }

    // main 메서드: 프로그램 시작 지점
    public static void main(String[] args) {
        TravelApp app = new TravelApp();           // 앱 객체 생성
        app.run();                                 // 실행
    }
}
