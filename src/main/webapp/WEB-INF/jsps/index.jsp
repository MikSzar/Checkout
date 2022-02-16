<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <title>Checkout your basket</title>
</head>
<body>
<h2>Enter userID</h2>

<form action="/success" method="get">
    <label>UserID:</label><br/>
    <input type="text" name="userId"/><br/>
    <input type="submit" value="Checkout basket"/>
</form>
<br/>
<br/>
<br/>
<h3>Search user by userID</h3>
<form action="/details" method="get">
    <label>UserID:</label><br/>
    <input type="text" name="userId"/><br/>
    <input type="submit" value="Show User"/>
</form>
<br/>
<br/>
<br/>
<h3>Search item by itemID</h3>
<form action="/details_item" method="get">
    <label>ItemID:</label><br/>
    <input type="text" name="itemId"/><br/>
    <input type="submit" value="Show Item"/>
</form>

</body>
</html>