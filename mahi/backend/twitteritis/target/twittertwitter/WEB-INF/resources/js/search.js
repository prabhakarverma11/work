
$().ready(function (){

    $("#search-form").validate({

        rules:{
            string: {
                required: true,
                maxlength: 140
            }
        },


        messages:{
            string:{
                required:"this field can't be empty",
                maxlength:"length too long"
            }
        }
    });

});