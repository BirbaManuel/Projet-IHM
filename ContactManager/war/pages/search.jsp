<%-- 
    Document   : addNew
    Created on : 27 Oct, 2013, 3:09:10 PM
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
        <title>Search Contacts</title>
    </head>
    <body>
        <a href="home">Home</a><br>
        <h1>Search Contacts</h1>

        <form method="GET" action="doSearch">
        <table>
            <tbody id="tbody_id">
                <tr>
                    <td>Email :</td>
                    <td><input type="text" name="searchString"></input></td>
                    <td><input value="Search" type="submit"></td>
            </tr>
            
            </tbody>
            
        </table>
    </form>
        
        
	<table>
		
		<c:forEach items="${contacts}" var="contact">
			<tr>
                            <td>Nom:<td>
				<td><c:out value="${contact.nom}"/></td>
                          </tr>
                          <tr>
                              <td>Prenom:<td>
				<td><c:out value="${contact.preNom}"/></td>
                                </tr>
                          <tr>
                              <td>Email:<td>
				<td><c:out value="${contact.email}"/></td>
                                </tr>
                                <tr>
                <td>DateNaissance:</td>
				<td><c:out value="${contact.dateNaissanceString}"/></td>
                                </tr>
                                <tr>
                <td>Actif:</td>
				<td><c:out value="${contact.actif}"/></td>
			</tr>
                 <b></b>
                 
                 <c:forEach items="${contact.adresses}" var="address">
                            <tr>
                <td><b> Adresse: </b></td>
            </tr>    
            <tr>
                <td>numero:</td>
                    <td><c:out value="${address.numero}"/></td>
                </tr>
            <tr>
                <td>rue:</td>
                    <td><c:out value="${address.rue}"/></td>
                </tr>
                <tr>
                <td>codePostal:</td>
                    <td><c:out value="${address.codePostal}"/></td>
                </tr>
                <tr>
                <td>ville:</td>
                    <td><c:out value="${address.ville}"/></td>
                </tr>
            
                <tr>
                <td>-------------------</td>
                    <td>----------------------</td>
                </tr>
                            </c:forEach>
                     
                 
		</c:forEach>
	</table>


        
</body>
</html>
