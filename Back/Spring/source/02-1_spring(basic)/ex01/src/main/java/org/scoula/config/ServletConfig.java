package org.scoula.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Spring MVC 설정 클래스
 * - DispatcherServlet이 참조하는 설정 클래스 (ServletConfig)
 * - WebMvcConfigurer 인터페이스 구현 → 설정 커스터마이징 가능
 */
@EnableWebMvc // Spring MVC 활성화 (핸들러 매핑, 어댑터 등 기본 설정 자동 등록)
@ComponentScan(basePackages = "org.scoula.controller") // 지정한 패키지에서 @Controller, @RestController 클래스 자동 스캔
public class ServletConfig implements WebMvcConfigurer {

    /**
     * 정적 리소스 경로 매핑 설정
     * - 브라우저에서 /resources/** 경로로 요청 시 /resources/ 폴더의 리소스를 반환
     * 예: /resources/css/style.css → /resources/css/style.css 파일 제공
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**") // URL 패턴
                .addResourceLocations("/resources/"); // 실제 리소스 경로
    }

    /**
     * ViewResolver 설정
     * - 컨트롤러에서 반환한 뷰 이름을 실제 JSP 파일 경로로 변환
     * - JSP 파일은 /WEB-INF/views/ 폴더에 위치하고 확장자는 .jsp 사용
     * 예: "home" → "/WEB-INF/views/home.jsp"로 매핑
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setViewClass(JstlView.class); // JSTL 지원 View 사용 (EL 표현식 사용 가능)
        bean.setPrefix("/WEB-INF/views/"); // 뷰 파일 경로 prefix
        bean.setSuffix(".jsp"); // 뷰 파일 확장자 suffix
        registry.viewResolver(bean); // ViewResolver 등록
    }
}
