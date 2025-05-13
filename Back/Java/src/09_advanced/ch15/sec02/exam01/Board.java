package ch15.sec02.exam01;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    private String subject;
    private String content;
    private String writer;
}

//위에 내용만 보고 롬복 어떤걸 써야할지 어떻게 알지?
//위 객체는 DTO(데이터 전달 객체)로 보이므로 단순 데이터 담고 전달 용도
//이떄 사용되는 롬복 @Data, @NoArgsConstructor, @AllArgsConstructor
//@Data : 필드 접근용 getter/setter
//@NoArgsConstructor : 기본 생성자
//@AllArgsConstructor : 전체 필드 생성자
