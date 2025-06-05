package org.scoula.ex06.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeController {

    public String getIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return "index"; //확장자 필요 없음
    }
}
