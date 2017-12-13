<div class="col-sm-8 text-middle">
    <h2>Search the chores, Admins Only</h2>
    <div class="container-fluid">
        <h2>Search Results: </h2>
        <form action="deleteChore" method="post">
            <table id="choreSearchTable" class="display" style="width:100%">
                <th>Chore Id</th>
                <th>Chore Name</th>
                <th>Chore Date</th>
                <th>Chore Interval</th>
                <th>Chore Assigned To</th><br>
                <th>Delete chore</th>
                <c:forEach items="${chores}" var="chore">
                    <tr>
                        <td>${chore.choreId} </td>
                        <td>${chore.choreName} </td>
                        <td>${chore.choreDate} </td>
                        <td>${chore.choreInterval} </td>
                        <td>${chore.assignedToUser} </td>
                        <td><input type="checkbox" name="choreCheckbox" value="${chore.choreId}" /></td>
                    </tr>
                </c:forEach>
            </table>

            <button type="submit">Delete Chore</button>

        </form>
    </div>
</div>
