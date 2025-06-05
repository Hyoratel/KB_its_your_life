<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Todo 보기</title>
</head>
<body>

<h1>Todo 보기</h1>

<!-- 링크 영역 -->
<div>
  <a href="list">목록보기</a> |
  <a href="update">수정하기</a>
</div>

<!-- 삭제 폼 -->
<form action="delete" method="POST">
  <input type="submit" value="삭제">
</form>

</body>
</html>
