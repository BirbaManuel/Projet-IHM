<%-- 
    Document   : edit
    Created on : 28 Oct, 2013, 10:10:49 PM
    Author     : Manuel Birba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Contacts</title>
    </head>
    <body>
        <a href="home">Home</a><br>
        <h1>Edit Contacts</h1>
        <table border="1">
            <tr>
            <td>Email</td>
            <td></td>
            <td></td>                    
            <tr>
            <c:forEach items="${contacts}" var="contact">
                <tr>
                    <td><c:out value="${contact.email}"/></td>
                <td><form method="GET" action="edit">
                        <input name="email" value="${contact.email}" type="hidden"/>
                        <input value="Edit" type="submit">
                    </form>
                    </td>
                    <td><form method="GET" action="delete">
                        <input name="email" value="${contact.email}" type="hidden"/>
                        <input value="Delete" type="submit">
                    </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        
    </body>
    
    
</html>
