<%@include file="Header/head.jsp"%>
<%@include file="Sidebar/left-sidebar.jsp"%>
<div class="col-sm-8 text-middle">
    <h3>Please enter your userid and password below.</h3>
    <FORM ACTION="j_security_check" METHOD="POST">
        <TABLE>
            <TR><TD>User name: <INPUT TYPE="TEXT" NAME="j_username">
            <TR><TD>Password: <INPUT TYPE="PASSWORD" NAME="j_password">
            <TR><TH><INPUT TYPE="SUBMIT" VALUE="login">
        </TABLE>
    </FORM>
</div>
<%@include file="Sidebar/right-sidebar.jsp"%>
<%@include file="Footer/footer.jsp"%>
