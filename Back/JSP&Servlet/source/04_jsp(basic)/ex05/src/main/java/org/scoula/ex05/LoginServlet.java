package org.scoula.ex05;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("Login Servlet");
        String userid = req.getParameter("userid");
        String passwd = req.getParameter("passwd");

//        System.out.println(userid);
//        System.out.println(passwd);

        //request 객체에 담는다.
        req.setAttribute("userid", userid);
        req.setAttribute("passwd", passwd);

        req.getRequestDispatcher("/login.jsp").forward(req, resp); //req : 요청정보, resp : 응답정보
    }
}
