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
        <h1>Welcome!!</h1>
        <h2>${Survey}</h2>
        <c:forEach items="${Survey.responses}" var="response">
            <c:forEach items="${response.pages}" var="responsePage">
                <c:forEach items="${responsePage.questions}" var="Question">
                    ${Question}<br>            
                </c:forEach>         
            </c:forEach>         
        </c:forEach>

        <c:forEach items="${Survey.responses}" var="response">
            ${response}<br>            
        </c:forEach>
    </body>
</html>
