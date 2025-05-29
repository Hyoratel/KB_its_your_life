<%--
  Created by IntelliJ IDEA.
  User: abide
  Date: 2025-05-29
  Time: 오후 5:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  // application 영역에서 방문자 수 꺼내기
  Integer count = (Integer) application.getAttribute("count");

  // 값이 없을 경우 대비 (예: count.jsp를 먼저 안 띄웠을 때)
  if (count == null) {
    count = 0;
  }
%>

<html>
<head>
  <title>방문자 수 조회</title>
</head>
<body>
<h1>방문자 수 출력</h1>
<p>현재까지 방문한 사람 수: <%= count %>명</p>
</body>
</html>

