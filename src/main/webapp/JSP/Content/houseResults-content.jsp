<div class="col-sm-8 text-middle">
    <h2>Search the houses, Admins Only</h2>
    <div class="container-fluid">
        <h2>Search Results: </h2>
        <table id="houseSearchTable" class="display" style="width:100%">
            <th>House id</th>
            <th>House Name</th>
            <c:forEach items="${houses}" var="house">
                <tr>
                    <td>${house.houseId} </td>
                    <td>${house.houseName} </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>