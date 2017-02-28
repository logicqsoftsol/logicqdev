jQuery(function($){
 
	jQuery('#login').on('click', function(event) {
        event.preventDefault();
		var username=$( "#user" ).val();
		var userpassword=$( "#pass" ).val();
		if(username=='Admin' && userpassword=='Password' ){
			  window.location.href = "admin.html";
		}else{
			window.location.href = "index.html";
		}
    });
	
$(document).ready(function () {

    $("#servicerequestform").validate({
        rules: {
            customername: {
                required: true
            },
			 servicename: {
                required: true
            },
			 servicedate: {
                required: true
            },
			 servicetime: {
                required: true
            },
			 customermob: {
                required: true			
            }
        }
    });
  $("#requestservice").click(function(){  
 		var requestdata=$("#servicerequestform").serializeJSON();
        $.ajax({  
            url:"http://127.0.0.1:8090/homeplus/admin/requestservice",  
            type:'POST',
            data : JSON.stringify(requestdata),      
             dataType: "json",
			  contentType: "application/json",
            success: function(data) {
                     $("#otpmobilenumber").val(data.customermob); 
					 $.session.set("SERVICE_NAME", data.servicename);					 
	                 $("#otppopup").modal('show');
                },
				error : function(e) {
				console.log(e);
			  }
        });  
    });
   $("#otpvalidation").click(function(){  
     var otpdata=$("#otprequestform").serializeJSON();
	 var servicename= $.session.get("SERVICE_NAME");
		$.ajax({  
            url:"http://127.0.0.1:8090/homeplus/admin//validateOTP/"+servicename,  
            type:'POST',
            data : JSON.stringify(otpdata),      
             dataType: "json",
			  contentType: "application/json",
            success: function(data) {
				$("#otppopup").modal('toggle');
				$('#servicerequestform')[0].reset();
                $("#servicerequestsucess").modal('show');
                },
				error : function(e) {
				console.log(e);
			  }
        });  
   });
  
});	
});