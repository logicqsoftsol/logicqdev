$(document).ready(function(){ 
var mobileverified =localStorage.getItem('phoneverified');
	if("false"==mobileverified){
		$("#divregister").hide();
		$("#divotpvalidation").show();
		document.getElementById("mobilenumber").value = localStorage.getItem('phonenumber');
	}else{
		if("true"==mobileverified){
			window.location = localStorage.getItem('redirect');
		}else{
			$("#divregister").show();
			$("#divotpvalidation").hide();	
		}
		
	}
$("#registerbutton").click(function() {
	  var formData=$("#registerform").serializeJSON();
		  $.ajax({
			  type:'POST',
			  url:'http://127.0.0.1:8090/logicq/user/register',
			  data : JSON.stringify(formData),
			  dataType: "json",
			  contentType: "application/json",
			  success:function(result){
				localStorage.setItem("phonenumber", result.phone); 	
                localStorage.setItem("phoneverified",false);				
			  },
			  error: function (error) {
              }
			});
	  });
	  
$("#validateotp").click(function() {
	   var otp = $("#otp").val();
	   var mobilenumber = $("#mobilenumber").val();
		  $.ajax({
			  type:'POST',
			  url:'http://127.0.0.1:8090/logicq/user/validateOTP/'+otp+"/"+mobilenumber,
			  data : '',
			  dataType: "json",
			  contentType: "application/json",
			  success:function(res, status, xhr){
				localStorage.setItem("phoneverified", "true"); 
				localStorage.setItem("redirect", xhr.getResponseHeader("redirect")); 				
			  },
			  error: function (error) {
				  
              }
			});
	  });	  
	
});