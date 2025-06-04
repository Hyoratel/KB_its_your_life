package org.scoula.ex03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 요청 객체(req)에서 사용자 입력값(파라미터) 추출
        String userid = req.getParameter("userid"); //HTML form에서 name = "userid"
        String password = req.getParameter("passwd"); // name = "password"

    // 응답의 컨텐츠 타입을 HTML + UTF-8로 설정
        resp.setContentType("text/html;charset=UTF-8");

    // 응답을 출력할 수 있는 출력 스트림(PrintWriter) 얻기
        PrintWriter out = resp.getWriter();

    // 클라이언트 브라우저에 출력할 HTML 작성
        out.print("<html><body>");
        out.print("아이디값: " + userid + "<br>");
        out.print("비밀번호값: " + password + "<br>");
        out.print("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        doGet(req, resp);
    }
}
