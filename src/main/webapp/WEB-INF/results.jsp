<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="head.jsp"%>

<html><body>


<div class="container-fluid">
    <h2>Search Results: </h2>
    <table>
        <tr>
            <th>&nbspID&nbsp</th>
            <th>&nbspFirst Name&nbsp</th>
            <th>&nbspLast Name&nbsp</th>
            <th>&nbspZip Code&nbsp</th>
            <th>&nbspPhone Number&nbsp</th>
            <th>&nbspEmail&nbsp</th>
        </tr>

        <c:if test="${user != null}" >
        <c:forEach var="user" items="${user}">
            <tr><td>&nbsp${user.id}</td>
                <td>&nbsp${user.firstName}</td>
                <td>&nbsp${user.lastName}</td>
                <td>&nbsp${user.zipCode}</td>
                <td>&nbsp${user.phoneNumber}</td>
                <td>&nbsp${user.email}</td>
            </tr>
        </c:forEach>
    </table>
    </c:if>

    <c:forEach var="users" items="${users}">
        <tr><td>&nbsp${users.id}</td>
            <td>&nbsp${users.firstName}</td>
            <td>&nbsp${users.lastName}</td>
            <td>&nbsp${user.zipCode}</td>
            <td>&nbsp${user.phoneNumber}</td>
            <td>&nbsp${user.email}</td>
        </tr>
    </c:forEach>
    </table>
</div>

</body>
</html>
