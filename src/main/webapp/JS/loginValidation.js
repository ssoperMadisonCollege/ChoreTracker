$(document).ready(function(){

    $('#loginForm').bootstrapValidator({

        fields: {
            j_username: {
                validators: {
                    notEmpty: {
                        message: 'enter your user name'
                    }
                }
            },
            j_password: {
                validators: {
                    notEmpty: {
                        message: 'enter your password'
                    }
                }
            }
        }
    })
});
