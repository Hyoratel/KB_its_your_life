package org.scoula.domain;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Parrot {

    private String name;

    @PostConstruct //의존성 주입이 끝난 후 자동으로 호출되는 초기화 메서드 위에 예) 초기설정, 리소스준비, 데이터 초기화
    public void init() {
        this.name = "Kiki";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
