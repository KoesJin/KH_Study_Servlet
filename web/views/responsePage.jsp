<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <% //스크립틀릿(scriptlet) -> html문서내에서 자바코드를 쓸 수 있는 영역 String name =
        (String)request.getAttribute("name"); // 넘어올때 Object 타입으로 오기떄문에 String으로 변경해야함 그리고 키를
        //넣어야 값이 나옴 int age = (int)request.getAttribute("age"); %>

        <h1>개인정보 응답화면</h1>
        <span><%= name %>님은 <%=age%>살이며 ~에 삽니다.</span>
    </body>
</html>
