<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table border="1">
  <tr>
    <th>Id</th>
    <th>Namn</th>
    <th>Telefon Nummer</th>
    <th>Email</th>
  </tr>
  <c:forEach items="${arrangorer}" var="arr">
  <tr>
    <td> <c:out value="${arr.id}"/></td>
    <td> <c:out value="${arr.name}"/> </td>
    <td> <c:out value="${arr.number}"/> </td>
    <td> <c:out value="${arr.email}"/> </td>
  </tr>
  </c:forEach>

</table>
