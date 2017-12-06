<div class="col-sm-8 text-middle">
    <h2>Add a new chore</h2>
    <form action="addChore" method="POST">
        <table>
            <tr><td>Chore name: <input      type="text" name="choreName"        id="choreName"></td></tr>
            <tr><td>Date: <input            type="text" name="choreDate"        id="choreDate" placeholder="yyyy-mm-dd"></td></tr>
            <tr><td>Time interval: <input   type="text" name="choreInterval"    id="choreInterval"></td></tr>
            <tr><td>Assigned to: <input     type="text" name="assignedToUser"   id="assignedToUser"></td></tr>
            <tr><td><button                 type="submit">Add new chore</button></td></tr>
        </table>
    </form>
</div>