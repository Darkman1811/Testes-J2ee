<%-- 
    Document   : index
    Created on : 21 juin 2016, 14:48:57
    Author     : Super
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        Context Path:${pageContext.servletContext.contextPath} <br>
        Local Adresse:${pageContext.request.localAddr} <br>
        Local Port:${pageContext.request.localPort} <br>
    </body>
</html>
