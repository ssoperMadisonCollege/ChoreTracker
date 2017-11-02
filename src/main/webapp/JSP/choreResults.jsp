<%@include file="head.jsp"%>

<html><body>

<div class="col-sm-8 text-middle">
    <h2>Search the chores, Admins Only</h2>
    <div class="container-fluid">
        <h2>Search Results: </h2>
        <table id="choreSearchTable" class="display" style="width:100%">
            <th>Chore Id</th>
            <th>Chore Name</th>
            <c:forEach items="${chores}" var="chore">
                <tr>
                    <td>${chore.choreId} </td>
                    <td>${chore.choreName} </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

</body>
</html>