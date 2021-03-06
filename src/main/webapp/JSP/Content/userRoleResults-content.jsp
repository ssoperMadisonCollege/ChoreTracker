<div class="col-sm-8 text-middle">
    <h2>Search the userRoles, Admins Only</h2>
    <div class="container-fluid">
        <h2>Search Results: </h2>
        <table id="userRoleSearchTable" class="display" style="width:100%">
            <th>Role Id</th>
            <th>User Name</th>
            <th>Role Name</th>
            <c:forEach items="${userRoles}" var="userRole">
                <tr>
                    <td>${userRole.userRoleId} </td>
                    <td>${userRole.user.userName} </td>
                    <td>${userRole.roleName} </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>