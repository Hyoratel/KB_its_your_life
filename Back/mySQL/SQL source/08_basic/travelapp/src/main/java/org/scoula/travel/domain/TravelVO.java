package org.scoula.travel.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder //빌더 패턴 자동 생성
// 가독성이 높고, 순서에 구애받지 않음!

public class TravelVO {
    private Long no;
    private String district;
    private String title;
    private String description;
    private String address;
    private String phone;

    private List<TravelImageVO> images;
}

/** travel.csv 한 줄 = TravelVO 하나의 인스턴스로 표현
 * 데이터를 전달하거나 저장할때 사용하는 순수 데이터 객체
 * DB->자바->화면 or CSV->자바->DB  이런 흐르메서 중간 매개체 역할 */
