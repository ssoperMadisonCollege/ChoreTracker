//TODO get registration validation working
$(document).ready(function(){

    $('#registrationForm').bootstrapValidator({

        fields: {
            firstName: {
                validators: {
                    notEmpty: {
                        message: 'enter your first name'
                    }
                }
            },
            lastName: {
                validators: {
                    notEmpty: {
                        message: 'enter your last name'
                    }
                }
            },
            userName: {
                validators: {
                    notEmpty: {
                        message: 'enter a user name'
                    }
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: 'enter a password'
                    }
                }
            },
            email: {
                validators: {
                    notEmpty: {
                        message: 'enter your email'
                    }
                }
            },
            phone: {
                validators: {
                    notEmpty: {
                        message: 'enter your phone number'
                    }
                }
            },
            houseName: {
                validators: {
                    notEmpty: {
                        message: 'enter your house name'
                    }
                }
            }
        }
    })
});
