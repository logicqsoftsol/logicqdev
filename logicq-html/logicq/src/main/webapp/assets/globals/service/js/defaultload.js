$(document).ready(function () {
	  $.ajax({
			type: 'GET',
			url: 'http://127.0.0.1:8090/logicq/search/getAllEntites',
			dataType: "json",
			contentType:"application/json",
			cache:true,
			 success: function(data) { 
	            $("#entitylist").empty();
	            for(var i=0;i<data.length;i++)
	            {
	                $("#entitylist").append("<option value='" + 
	                data[i].value + "'></option>");
	            }
	           }
	    });
	  
	  $.ajax({
			type: 'GET',
			url: 'http://127.0.0.1:8090/logicq/search/getAlllocations',
			dataType: "json",
			contentType:"application/json",
			cache:true,
			 success: function(data) { 
	            $("#locationlist").empty();
	            for(var i=0;i<data.length;i++)
	            {
	                $("#locationlist").append("<option value='" + 
	                data[i].value + "'></option>");
	            }
	           }
	    }); 
});