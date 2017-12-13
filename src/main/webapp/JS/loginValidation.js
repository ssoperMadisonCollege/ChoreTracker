// TODO get login validation working
$(document).ready(function(){

    $('#loginForm').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
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
    .on('success.form.bv', function(e) {
        $('#success_message').slideDown({ opacity: "show" }, "slow")
        $('#loginForm').data('bootstrapValidator').resetForm();

        // Prevent form submission
        e.preventDefault();

        // Get the form instance
        var $form = $(e.target);

        // Get the BootstrapValidator instance
        var bv = $form.data('bootstrapValidator');

        // Use Ajax to submit form data
        $.post($form.attr(''), $form.serialize(), function(result) {
            console.log(result);
        }, 'json');
    });
});
