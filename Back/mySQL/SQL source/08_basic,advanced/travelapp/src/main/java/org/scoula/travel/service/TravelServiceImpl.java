package org.scoula.travel.service;

import lombok.RequiredArgsConstructor;
import org.scoula.travel.dao.TravelDao;
import org.scoula.travel.domain.TravelVO;
import org.scoula.travel.domain.TravelImageVO;
import java.util.List;
import java.util.Scanner;
import java.util.NoSuchElementException;

// DAO를 주입받아 사용하는 서비스 구현 클래스
@RequiredArgsConstructor
public class TravelServiceImpl implements TravelService {

    // DAO 주입 (생성자 통해 final로 설정됨)
    final TravelDao dao;

    // 사용자 입력 숫자를 받는 메서드
    private int getNumber(String prompt) {
        System.out.print(prompt);
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        return num;
    }

    // 권역 리스트 출력
    private void printDistricts(List<String> districts) {
        for (int i = 0; i < districts.size(); i++) {
            System.out.printf("%d] %s\n", i + 1, districts.get(i));
        }
    }

    // 관광지 리스트 출력 (no, district, title)
    private void printTravels(List<TravelVO> travels) {
        for (TravelVO travel : travels) {
            System.out.printf("%3d %6s %s\n", travel.getNo(), travel.getDistrict(), travel.getTitle());
        }
    }

    // 전체 관광지 목록 출력
    @Override
    public void printTravels() {
        List<TravelVO> travels = dao.getTravels();
        printTravels(travels);
    }

    // 권역별 관광지 목록 출력
    @Override
    public void printTravelsByDistrict() {
        List<String> districts = dao.getDistricts();
        printDistricts(districts);
        int ix = getNumber("선택: ");
        String district = districts.get(ix - 1);
        List<TravelVO> travels = dao.getTravels(district);
        printTravels(travels);
    }

    // 페이지별 관광지 목록 출력
    @Override
    public void printTravelsByPage() {
        int totalPage = (int) Math.ceil(dao.getTotalCount() / 10.0);
        System.out.printf("총 %d 페이지\n", totalPage);
        int page = getNumber(String.format("페이지 선택(1~%d): ", totalPage));
        List<TravelVO> travels = dao.getTravels(page);
        printTravels(travels);
    }

    // 관광지 상세보기 (이미지 포함)
    @Override
    public void printTravel() {
        long no = getNumber("관광지 No: ");
        TravelVO travel = dao.getTravels(no).orElseThrow(NoSuchElementException::new);

        System.out.println("권역: " + travel.getDistrict());
        System.out.println("제목: " + travel.getTitle());
        System.out.println("설명: " + travel.getDescription());
        System.out.println("주소: " + travel.getAddress());
        System.out.println("전화번호: " + travel.getPhone());
        System.out.println("사진들");

        // 이미지 목록 출력 (이미지 정보 포함 조회가 되어야 함)
        for (TravelImageVO image : travel.getImages()) {
            System.out.printf(" [%3d] %s\n", image.getNo(), image.getFilename());
        }
    }
}
