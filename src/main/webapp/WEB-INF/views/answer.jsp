<%-- 
    Document   : survey
    Created on : 05.08.2017, 11:29:53
    Author     : A
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Answer!!</h1>
        <c:forEach items="${answers}" var="answer">
            ${answer}<br>   
        </c:forEach>


    </body>
</html>
