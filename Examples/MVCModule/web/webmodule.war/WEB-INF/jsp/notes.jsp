<%@ page import="ru.ksu.mvc.controller.Constants" %>
<%@ page import="ru.ksu.mvc.model.vo.Note" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Note> notes = (List<Note>) request.getAttribute(Constants.ATTRIBUTE_NOTES);
    String contextPath = request.getContextPath();
%>
<html>
<head><title>Notes</title></head>
<body>
<div style="width:100%;text-align:center;">
    <h3>Notes</h3>
    <ul>
        <%
            for (Note note : notes) {
        %>
        <li>
            <a href="<%=contextPath%>/servlet?<%=Constants.PARAM_ACTION%>=<%=Constants.ACTION_NOTE%>&<%=Constants.PARAM_ID%>=<%=note.getId()%>"><%=note.getTitle()%>
            </a>
        </li>
        <%
            }
        %>

    </ul>

    <br/>
    <br/>

    <h3>Add note</h3>

    <form action="<%=contextPath%>/servlet" method="post">
        <input type="hidden" name="<%=Constants.PARAM_ACTION%>" value="<%=Constants.ACTION_CREATE%>"/>
        <table align="center">
            <tr>
                <td>Title:</td>
                <td><input type="text" name="<%=Constants.PARAM_TITLE%>"/></td>
            </tr>
            <tr>
                <td>Text:</td>
                <td><input type="text" name="<%=Constants.PARAM_TEXT%>"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" name="submit" value="Create">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>