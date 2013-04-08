<%@page language="java" contentType="text/html"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
  <head>
    <title>Alla arrangorer i systemet</title>
  </head>
  <body>
    <table border="1">
      <tr><td>Arrangorer</td><td>Namn</td><td>values</td></tr>
      <c:forEach items="${Arrangorer}" var="arran"><tr>
        <td>$arran.id </td>
        <td>$arran.Name </td>
      </tr>
      </c:forEach> 
     </table>
  </body></html>
