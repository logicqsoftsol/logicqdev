$(document).ready(function(){
 $("#loginsubmit").click(function() {
	 var email = $("#email").val();
	 var password = $("#password").val();
		  $.ajax({
			  type: "POST",
			  beforeSend: function (request)
            {
                request.setRequestHeader("userName", email);
				request.setRequestHeader("password",password);
            },
			  url: "http://127.0.0.1:8090/logicq/api/login",
			  data :'',
			  dataType: "jsonp",
			  contentType: "application/json",
			  success:function(response){
					   $('#login-reg').hide(); 
				$('#basicprofile').show();
			  },
			  error: function (error) {
                 $("div#login-reg").hide(); 
				$("div#basicprofile").show();
              }
			});
});
});