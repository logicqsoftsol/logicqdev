$(document)
		.ready(
				function() {
				
					$
							.ajax({
								type : 'GET',
								url : 'http://127.0.0.1:8090/logicq/search/getAllEntites',
								dataType : "json",
								contentType : "application/json",
								cache : true,
								success : function(data) {
									$("#entitylist").empty();
									for (var i = 0; i < data.length; i++) {
										$("#entitylist").append(
												"<option value='"
														+ data[i].value
														+ "'></option>");
									}
								}
							});

					$
							.ajax({
								type : 'GET',
								url : 'http://127.0.0.1:8090/logicq/search/getAlllocations',
								dataType : "json",
								contentType : "application/json",
								cache : true,
								success : function(data) {
									$("#locationlist").empty();
									for (var i = 0; i < data.length; i++) {
										$("#locationlist").append(
												"<option value='"
														+ data[i].value
														+ "'></option>");
									}
								}
							});


	var token =localStorage.getItem('token');
	var profilekey =localStorage.getItem('email');
      
		if (token != null) {
									$("#basicprofile").show();
									$("#displayprofile").show();
									$("#userlogin").hide();
									$("#register").hide();
			var div = $("#username");
			div.innerHTML =  "'"+profilekey+"'"+div.innerHTML;
								} else {
									$("#basicprofile").hide();
									$("#displayprofile").hide();
									$("#userlogin").show();
									$("#register").show();
								}

				});