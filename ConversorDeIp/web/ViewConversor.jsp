<%-- 
    Document   : ViewConversor
    Created on : 19/05/2019, 15:29:37
    Author     : Randolfo Gama
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado na View JSP</title>
    </head>
    <body>
        <%=request.getAttribute("resultado")%>
    </body>
</html>
