<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo 목록</title>
</head>
<body>

<h1>Todo 목록 보기</h1>

<!-- todoList 출력 (예: [Todo 1, Todo 2, Todo 3]) -->
<div>
    ${todoList}
</div>

<!-- 상세보기 링크 -->
<div>
    <a href="view">상세보기</a>
</div>

<!-- 새 Todo 만들기 링크 -->
<div>
    <a href="create">새 Todo</a>
</div>

</body>
</html>
