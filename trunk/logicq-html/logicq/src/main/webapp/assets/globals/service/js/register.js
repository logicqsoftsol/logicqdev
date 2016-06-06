$(document).ready(function(){ 
$("#registerbutton").click(function() {
	  var formData=$("#registerform").serializeJSON();
		  $.ajax({
			  type:'POST',
			  url:'http://127.0.0.1:8090/logicq/user/register',
			  data : JSON.stringify(formData),
			  dataType: "json",
			  contentType: "application/json",
			  success:function(result){
				  //modeal open bu suddenly it close also.I remove this modal from html
				// $("#bsModal3").modal('show');
			  },
			  error: function (error) {
                  alert('error'); 
              }
			});
	  });
});