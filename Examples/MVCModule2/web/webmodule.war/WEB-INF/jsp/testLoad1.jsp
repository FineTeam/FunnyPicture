<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String date = (String) request.getAttribute("date");
%>
<p>
    Current time: <%=date%>
</p>