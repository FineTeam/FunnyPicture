<%@page import="java.util.*" %>
<%String str = request.getParameter("login");

session.setAttribute("sessUserName", request.getParameter("login"));%>
<html>
    <head>
        <title>Picture</title>
        P {
		color: black;
		font-family: Arial;
		font-size: 90%;
		text-align: right;
		}
    </head>
    <body>
        <p>Logged in as <b><%= session.getAttribute( "sessUserName" ) %></b><p>
        <% if (session.getAttribute("sessUserName").equals("")){%>
<a href="login.jsp"><b>Login </b></a>
<%}
else{%>
<a href="logout.jsp"><b>Logout</b></a>
<%}
%>