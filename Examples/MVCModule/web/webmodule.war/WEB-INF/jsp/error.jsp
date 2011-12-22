<%@ page import="ru.ksu.mvc.controller.Constants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String message = (String) request.getAttribute(Constants.ATTRIBUTE_MESSAGE);
    String contextPath = request.getContextPath();
%>
<html>
<head>
    <title>Error</title></head>
<body>
<div style="width:100%;text-align:center;">
    <p style="font-weight:bold;color:red;"><%=message%>
    </p>

    <p><a href="<%=contextPath%>">Back</a></p>
</div>
</body>
</html>