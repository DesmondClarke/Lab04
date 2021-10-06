<%-- 
    Document   : editnote
    Created on : Oct 6, 2021, 2:37:56 PM
    Author     : 507936
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Note</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <br>
        <h2>Edit Note</h2>
        <br>
        <label>Title: </label>
        <input type="text" value="${Title}">
        <br>
        <label>Contents:</label>
        <input type="text" value="${Content}">
    </body>
</html>
