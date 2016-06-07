$(document).ready(function(){ 
var mobileverified =localStorage.getItem('isMobileVerified');
	if("false"==mobileverified){
		$("#divregister").hide();
		$("#divotpvalidation").show();
	}else{
		$("#divregister").show();
		$("#divotpvalidation").hide();
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
				localStorage.setItem("isMobileVerified", result.isMobileVerified); 				
			  },
			  error: function (error) {
              }
			});
	  });
	  
$("#validateotp").click(function() {
	   var otp = $("#otp").val();
		  $.ajax({
			  type:'POST',
			  url:'http://127.0.0.1:8090/logicq/user/validateOTP',
			  data : JSON.stringify(otp),
			  dataType: "json",
			  contentType: "application/json",
			  success:function(result){
				localStorage.setItem("isMobileVerified", result.isMobileVerified); 				
			  },
			  error: function (error) {
              }
			});
	  });	  
	
});