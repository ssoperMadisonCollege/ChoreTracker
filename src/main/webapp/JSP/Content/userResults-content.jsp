<div class="col-sm-8 text-middle">
    <h2>Search the users, Admins Only</h2>
    <div class="container-fluid">
        <h2>Search Results: </h2>
        <form action="deleteUser" method="POST">
            <table id="userSearchTable" class="display" style="width:100%">
                <th>User Name</th>
                <th>User Password</th>
                <th>User First Name</th>
                <th>User Last Name</th>
                <th>User Email</th>
                <th>User Phone</th>
                <th>Delete User</th>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.userName} </td>
                        <td>${user.password} </td>
                        <td>${user.firstName} </td>
                        <td>${user.lastName} </td>
                        <td>${user.email} </td>
                        <td>${user.phone} </td>
                        <td><input type="checkbox" name="userCheckbox" value="${user.userName}" /></td>
                    </tr>
                </c:forEach>
            </table>

            <button type="submit">Delete User</button>

        </form>
    </div>
</div>