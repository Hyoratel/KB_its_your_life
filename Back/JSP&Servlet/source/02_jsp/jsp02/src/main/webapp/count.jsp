<%--
  Created by IntelliJ IDEA.
  User: abide
  Date: 2025-05-29
  Time: 오후 5:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // application 범위에서 방문자 수를 가져옴
    Integer count = (Integer) application.getAttribute("count");

    // 최초 접속 시 초기화
    if (count == null) {
        count = 1;
    } else {
        count = count + 1;
    }

    // 다시 application 범위에 저장
    application.setAttribute("count", count);
%>

<html>
<head>
    <title>방문자 수 카운트</title>
</head>
<body>
<h1>현재까지 방문한 사람 수: <%= count %>명</h1>
</body>
</html>

