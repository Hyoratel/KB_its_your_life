package org.scoula.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * WebConfig 클래스
 * - 기존 web.xml 을 대체하는 역할
 * - DispatcherServlet 및 관련 설정을 자바 코드 기반으로 구성
 */
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * RootConfig 설정 클래스 지정
     * - Root Application Context (비 웹 관련 빈 설정: Service, Repository 등)
     * - 예: DB 설정, 비즈니스 로직 설정 등
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { RootConfig.class };
    }

    /**
     * ServletConfig 설정 클래스 지정
     * - Servlet Application Context (웹 관련 빈 설정: Controller, ViewResolver 등)
     * - DispatcherServlet이 참조하는 설정 클래스
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { ServletConfig.class };
    }

    /**
     * DispatcherServlet 매핑 경로 설정
     * - "/" : 모든 요청을 DispatcherServlet이 처리하도록 설정
     * - ex) http://localhost:8080/ 로 들어오는 요청 처리
     */
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    /**
     * Servlet Filter 설정
     * - 요청과 응답에 대한 문자 인코딩 필터 적용
     * - UTF-8 인코딩 강제 적용 (한글 깨짐 방지)
     */
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8"); // 인코딩 설정
        characterEncodingFilter.setForceEncoding(true); // 강제로 적용
        return new Filter[] { characterEncodingFilter };
    }
}
