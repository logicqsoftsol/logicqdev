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
				var token=xhr.getResponseHeader("AUTH-TOKEN");
				$.redirect("/logicq/index.html",{"AUTH-TOKEN": token, user: xhr.name});
				//window.location.href='/logicq/index.html?token='+token+'usrname=';
			  },
			  error: function (res, status, xhr) {
				 $("#basicprofile").hide();
				  window.location.href='/logicq/error.html';
              }
			});
});
});
