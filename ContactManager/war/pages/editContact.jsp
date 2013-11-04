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
        <title>Add Contact</title>
        <script
src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script>
$(document).ready(function() {
    
    $('#addAdresse').click(function() {
        
        var addIndex = (($('#adresseId tr').length)/5);
        $('#adresseId').append(
                '<tr><td><b> Adresse: </b></td><td>delete<input type="checkbox" name="adresses[' + addIndex + '].delete"></td></tr><tr>'+ 
                '<td>numero:</td><td><input type="text" name="adresses[' + addIndex + '].numero"></input></td></tr>' +
                '<tr><td>rue:</td><td><input type="text" name="adresses['+ addIndex +'].rue"></input></td></tr>' +
                '<tr><td>codePostal:</td><td><input type="text" name="adresses['+ addIndex +'].codePostal"></input></td></tr>' +
                '<tr><td>ville:</td><td><input type="text" name="adresses['+ addIndex +'].ville"></input></td></tr>');
    });
     
});
</script>
</head>
    <body>
        <a href="home">Home</a><br>
        <h1>Edit Contact</h1>

        <form:form method="POST" modelAttribute="contact" action="doEdit">
        <table>
            <tbody id="tbody_id">
                <tr>
                    <td>Nom:</td>
                    <td><form:input path="nom"></form:input></td>
            </tr>
            <tr>
                <td>Prenom:</td>
                <td><form:input path="preNom"></form:input></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><form:input path="email" readonly="true"></form:input></td>
            </tr>
            <tr>
                <td>DateNaissance:</td>
                <td><form:input type="date" path="dateNaissanceString"></form:input></td>
            </tr>
            <tr>
                <td>Actif:</td>
                <td><form:checkbox path="actif"></form:checkbox></td>
            </tr>
            
            <table id="adresseId">
            <c:forEach items="${contact.adresses}" varStatus="i">
            
            <tr>
                <td><b> Adresse: </b></td><td>delete<form:checkbox path="adresses[${i.index}].delete"></form:checkbox></td>
            </tr>    
            <tr>
                <td>numero:</td>
                    <td><form:input path="adresses[${i.index}].numero"></form:input></td>
                </tr>
            <tr>
                <td>rue:</td>
                    <td><form:input path="adresses[${i.index}].rue"></form:input></td>
                </tr>
                <tr>
                <td>codePostal:</td>
                    <td><form:input path="adresses[${i.index}].codePostal"></form:input></td>
                </tr>
                <tr>
                <td>ville:</td>
                    <td><form:input path="adresses[${i.index}].ville"></form:input></td>
                </tr>
                
   
            </c:forEach>
                </table>
            <br>
                     <input id="addAdresse" type="button" value="Add Another Adresse" />
            </tbody>
            
        </table>
                <br><br><br>
                <input value="Save" type="submit">
    </form:form>

</body>
</html>
