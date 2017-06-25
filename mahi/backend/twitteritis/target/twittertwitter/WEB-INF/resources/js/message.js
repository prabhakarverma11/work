/**
 * Created by cgfu on 10/5/16.
 */

$().ready(function (){

    $("#message-form").validate({

        rules:{
            handle: {
                required: true,
                maxlength: 15
            },

            mesg:{
                required:true,
                maxlength:140
            }
        },


        messages:{
            string:{
                required:"this field can't be empty",
                maxlength:"length too long"
            },

            mesg:{
                required:"this field can't be empty",
                maxlength:"length too long"
            }
        }
    });

});