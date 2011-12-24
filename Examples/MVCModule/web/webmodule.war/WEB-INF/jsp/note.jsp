<%@ page import="ru.ksu.mvc.controller.Constants" %>
<%@ page import="ru.ksu.mvc.model.vo.Note" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Note note = (Note) request.getAttribute(Constants.ATTRIBUTE_NOTE);
    String contextPath = request.getContextPath();
%>
<html>
<head><title>Note</title></head>
<body>
<div style="width:100%;text-align:center;">
    <h3><%=note.getTitle()%>
    </h3>

    <p><%=note.getText()%>
    </p>

    <p><a href="<%=contextPath%>">Back</a></p>

    <br/>
    <br/>

    <form action="<%=contextPath%>/servlet" method="post">
        <input type="hidden" name="<%=Constants.PARAM_ACTION%>" value="<%=Constants.ACTION_DELETE%>">
        <input type="hidden" name="<%=Constants.PARAM_ID%>" value="<%=note.getId()%>">
        <input type="submit" name="submit" value="Delete note" onclick="return confirm('Delete this note?');">
    </form>
</div>
</body>
</html>