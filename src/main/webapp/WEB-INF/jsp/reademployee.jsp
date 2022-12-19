<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Read Employees</h1>
<table border="2" width="70%" cellpadding="2">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Country</th>
        <th>Department</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.name}</td>
            <td>${employee.email}</td>
            <td>${employee.country}</td>
            <td>${employee.department}</td>
            <td><a href="/update-employee/${employee.id}">Update</a></td>
            <td><a href="/delete-employee/${employee.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="/create-employee">Create Employee</a>
