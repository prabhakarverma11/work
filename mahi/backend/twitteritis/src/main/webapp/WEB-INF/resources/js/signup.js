/**
 * Created by cgfu on 10/5/16.
 */
$().ready(function(){
   $("#signup-form").validate({


       rules: {
           username: {
               required: true,
               minlength: 4,
               maxlength: 45
           },
           password: {
               required: true,
               minlength: 4,
               maxlength: 45
           },
           repassword:{
               required:true,
               equalTo:"#password"
           }
       },

       messages: {
           username: {
               required: "please enter a valid username",
               minlenth: "username too small",
               maxlength: "isse jyaada bada kya hi lega"
           },

           password: {
               requried: "Please enter a valid password",
               minlength: "password lenth too small",
               maxlength: "passwrod length too large for db"
           },
           repassword:{
               required:"please reenter the password",
               equalTo:"the password do not match"
           }
       }
   });
});