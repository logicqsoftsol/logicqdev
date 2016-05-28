  $("#login").submit(function(){
		  var formdata=$("#loginform").serializeJSON();
			$.ajax({
			  type: "POST",
			  url: "http://127.0.0.1:8090/logicq/app/login",
			 data : JSON.stringify(formDatadet),
			  dataType: "jsonp",
			  contentType: "application/json",
			  success:function(result){
			    alert("login sucess  "+result.email);
			  }
			});
 });