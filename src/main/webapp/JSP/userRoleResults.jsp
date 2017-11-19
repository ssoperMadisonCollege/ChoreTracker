<%@include file="Header/head.jsp"%>
<%@include file="Sidebar/left-sidebar.jsp"%>
<div class="col-sm-8 text-middle">
    <h2>Search the userRoles, Admins Only</h2>
    <div class="container-fluid">
        <h2>Search Results: </h2>
        <table id="userRoleSearchTable" class="display" style="width:100%">
            <th>UserRole Id</th>
            <th>UserRole Name</th>
            <th>UserRole Role Name</th>
            <c:forEach items="${userRoles}" var="userRole">
                <tr>
                    <td>${userRole.userRoleId} </td>
                    <td>${userRole.userRoleName} </td>
                    <td>${userRole.roleName} </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<%@include file="Sidebar/right-sidebar.jsp"%>
<%@include file="Footer/footer.jsp"%>
