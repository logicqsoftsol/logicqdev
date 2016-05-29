$("#register").submit(function(event) {
	var formData=JSON.stringify(formData);
		  $.ajax({
			  type: "POST",
			  url: "http://127.0.0.1:8090/logicq/user/register",
			  data :formData,
			  dataType: "jsonp",
			  contentType: "application/json",
			  success:function(result){
			    alert("add user sucess  "+result.email);
			  },
			  error: function (error) {
                  alert('error'); 
              }
			});
	  });
    