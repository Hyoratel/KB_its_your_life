<%--
  Created by IntelliJ IDEA.
  User: abide
  Date: 2025-05-29
  Time: 오후 4:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ko">
<head>
  <title>스크립트릿실습</title>
</head>
<body>
<h1>현재날짜출력실습</h1>
<!-- 스크립트릿 실습(HTML 주석) -->
<%-- 현재 날짜(JSP 주석) : <%= d %> --%>
<% Date d = new Date();%> 현재 날짜 : <%=d %>
</body>
</html>
