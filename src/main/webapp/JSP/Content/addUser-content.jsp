<div class="col-sm-8 text-middle">
    <h2>Register as a new user</h2>
    <form action="addUser" method="POST" id="registrationForm">
        <table>
            <tr><td>First Name: <input  type="text"     name="firstName"    id="firstName"></td></tr>
            <tr><td>Last Name: <input   type="text"     name="lastName"     id="lastName"></td></tr>
            <tr><td>User Name: <input   type="text"     name="userName"     id="userName"></td></tr>
            <tr><td>Password: <input    type="password" name="password"     id="password"></td></tr>
            <tr><td>E-mail: <input      type="text"     name="email"        id="email"></td></tr>
            <tr><td>Phone: <input       type="text"     name="phone"        id="phone"></td></tr>
            <tr><td>House name: <input  type="text"     name="houseName"    id="houseName"></td></tr>
            <tr><td><button             type="submit">Register</button></td></tr>
        </table>
    </form>
</div>
<!-- TODO get user registration validation working
<script type="text/javascript" src="../../JS/registrationValidation.js"></script>
-->