package org.scoula.ex06;

import org.scoula.ex06.command.Command;
import org.scoula.ex06.controller.HomeController;
import org.scoula.ex06.controller.TodoController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DispatcherServlet extends HttpServlet {

    // GET/POST 요청 별 Command 객체를 저장하는 맵
    Map<String, Command> getMap;
    Map<String, Command> postMap;

    // 뷰 파일의 접두어와 접미어 설정
    String prefix = "/WEB-INF/views/";
    String suffix = ".jsp";

    //protected는 상속이 아니면 쓸 수 없어서 public으로 변경해줘야한다!
    @Override
    public void init() {
        getMap = new HashMap<>();
        postMap = new HashMap<>();
        createMap(getMap,postMap); // 이걸 서브클래스가 구현

    }

    protected void createMap(Map<String, Command> map, Map<String, Command> postMap) {
        //자식 클래스가 오버라이딩해서 실제 매핑 정의
    }
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println(req.getRequestURI());  // 디버깅
        //요청에 해당하는 Command 객체 조회
        Command command = getCommand(req);
        if(command != null) {
            //Command가 존재하면 실행
            execute(command, req, resp);
        } else { // 404 에러 처리
            String view = prefix + "404" + suffix;
            //디버깅에 유리
            RequestDispatcher dis = req.getRequestDispatcher(view); //변수에 저장 후 forward()
            dis.forward(req, resp);
            //req.getRequestDispatcher(view).forward(req, resp);
        }

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp); //post로 넘어오면 get으로 넘겨줄게
    }

    private String getCommandName(HttpServletRequest req) {
        String requestURI = req.getRequestURI(); // 예: /ex06/todo/list
        String contextPath = req.getContextPath(); // 예: /ex06
        return requestURI.substring(contextPath.length()); // 예: /todo/list
    }

    // 요청 메서드에 따라 GET/POST 맵에서 Command 검색
    private Command getCommand(HttpServletRequest req) {
        String commandName = getCommandName(req);
        Command command;
        if(req.getMethod().equalsIgnoreCase("GET")) {
            command = getMap.get(commandName);
        } else {
            command = postMap.get(commandName);
        }
        return command;
    }

    // Command 실행 후 반환된 viewName에 따라 포워드 or 리다이렉트
    private void execute(Command command, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewName = command.execute(request, response);
        if(viewName.startsWith("redirect:")) { // redirect 처리
            response.sendRedirect(viewName.substring("redirect:".length()));
        } else { // forward 처리
            String view = prefix + viewName + suffix;
            RequestDispatcher dis = request.getRequestDispatcher(view);
            dis.forward(request, response);
        }
    }

}
