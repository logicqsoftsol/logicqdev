function submitForm() {

	var uploadFoler = $("#pathSelect option:selected").text();

	document.getElementById("myForm").action = "http://localhost:8090/commonproject/admin/file/uploadfiles/"
			+ uploadFoler;
	document.getElementById("myForm").submit();
}
function saveForm() {

	var data = {

		"name" : $("#sliderSelect").val(),
		"imagepath" : $("#imageSelect").val(),
		"text1" : $("#text1").val(),
		"text2" : $("#text2").val(),
		"text3" : $("#text3").val(),
		"textextra" : $("#text4").val()
	}

	$('#target').html('sending..');
	$
			.ajax({
				type : 'post',
				url : 'http://localhost:8090/commonproject/admin/content/saveOrUpdateHomeContent',
				contentType : "application/json; charset=utf-8",
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(data) {
					alert('success');
				},

			});

}

function saveAboutUs() {
	var data = {

		"name" : "AboutUs",
		"type" : "HOME",
		"value" : $("#aboutus").val()
	}
	$
			.ajax({
				type : 'post',
				url : 'http://localhost:8090/commonproject/admin/content/saveOrUpdateContent',
				contentType : "application/json; charset=utf-8",
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(data) {
					alert('success');
				},

			});
}
$(document)
		.ready(
				function() {

					$
							.ajax({
								type : 'get',
								url : 'http://localhost:8090/commonproject/admin/content/getContentDetails',
								dataType : 'json',
								success : function(data) {
									var abtuscontent = "";
									for (i = 0; i < data.length; i++) {
										abtuscontent = data[i].value;
									}
									$('#abtus').text(abtuscontent);
								},
								error : function(e) {
									alert('Error: ' + e);
								}

							})
				});