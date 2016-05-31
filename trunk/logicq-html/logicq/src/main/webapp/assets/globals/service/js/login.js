$(document).ready(function(){
 $("#loginsubmit").click(function() {
	 var email = $("#email").val();
	 var password = $("#password").val();
		  $.ajax({
			  type: 'POST',
			  beforeSend: function (request)
            {
				request.setRequestHeader("contentType", "application/json");
                request.setRequestHeader("userName", email);
				request.setRequestHeader("password",password);
            },
			  url: 'http://127.0.0.1:8090/logicq/api/login',
			  dataType: "json",
			  contentType:"application/json",
			  success:function(res, status, xhr){ 
				window.location.href='/logicq/index.html';
			  },
			  error: function (res, status, xhr) {
				 $("#basicprofile").hide();
				  window.location.href='/logicq/error.html';
              }
			});
});
});
