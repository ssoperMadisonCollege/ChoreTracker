<%@include file="Header/head.jsp"%>
<%@include file="Sidebar/left-sidebar.jsp"%>
<div class="col-sm-8 text-middle">
    <h2>Search the chores, Admins Only</h2>
    <div class="container-fluid">
        <h2>Search Results: </h2>
        <table id="choreSearchTable" class="display" style="width:100%">
            <th>Chore Id</th>
            <th>Chore Name</th>
            <th>Chore Date</th>
            <th>Chore Interval</th>
            <th>Chore Assigned To</th>
            <c:forEach items="${chores}" var="chore">
                <tr>
                    <td>${chore.choreId} </td>
                    <td>${chore.choreName} </td>
                    <td>${chore.choreDate} </td>
                    <td>${chore.choreInterval} </td>
                    <td>${chore.assignedToUser} </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<%@include file="Sidebar/right-sidebar.jsp"%>
<%@include file="Footer/footer.jsp"%>
