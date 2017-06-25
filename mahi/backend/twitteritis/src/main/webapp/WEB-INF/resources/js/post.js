/**
 * Created by cgfu on 10/5/16.
 */
$().ready(function (){

    $("#post-form").validate({

        rules:{
            string: {
                required: true,
                maxlength: 140
            }
        },


        messages:{
            string:{
                required:"this field can't be empty",
                maxlength:"the maximum allowed tweet length by twitter is 140 chars"
            }
        }
    });

});