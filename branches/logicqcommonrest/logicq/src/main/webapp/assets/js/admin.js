(function($) {
	"use strict";
	var mainApp = {
		main_fun : function() {
			/*====================================
			METIS MENU 
			======================================*/
			$('#main-menu').metisMenu();
			/*====================================
			  LOAD APPROPRIATE MENU BAR
			======================================*/
			$(window).bind("load resize", function() {
				if ($(this).width() < 768) {
					$('div.sidebar-collapse').addClass('collapse')
				} else {
					$('div.sidebar-collapse').removeClass('collapse')
				}
			});
		},
		initialization : function() {
			mainApp.main_fun();
		}
	}
	$(document)
			.ready(
					function() {
						jQuery.support.cors = true;
						mainApp.main_fun();

						$
								.ajax({
									type : 'get',
									url : 'http://localhost:8090/commonproject/admin/content/getContentDetails',
									dataType : 'json',
									success : function(data) {
										var abtuscontent = "";

										for (var i = 0; i < data.length; i++) {

											if (data[i].name == "AboutUs"
													&& data[i].type == "HOME") {
												abtuscontent = data[i].value;
											}
										}
										$('#aboutus').val(abtuscontent);

									},
									error : function(e) {
										$("#p").text('Unable to perform operations');
										$("#statusmessage").modal('show');
									}

								});
						loadSliderContent('Slider1');

					});

}(jQuery));

function loadSliderContent(slider) {

	var imagepath = [];

	$
			.ajax({
				type : 'get',
				url : 'http://localhost:8090/commonproject/admin/content/getHomeContentDetails',
				dataType : 'json',
				success : function(data) {
					var fsc = "";
					var ssc = "";
					var tsc = "";

					for (var i = 0; i < data.length; i++) {
						imagepath[i] = (data[i].imagepath).split("/")[4];;
						if (data[i].name == slider.value
								|| data[i].name == slider) {
							fsc = data[i].text1;
							ssc = data[i].text2;
							tsc = data[i].text3;
						}
					}
					$('#fsc').val(fsc);
					$('#ssc').val(ssc);
					$('#tsc').val(tsc);
					$.each(imagepath, function(i, item) {

						$('#imageSelect').append($('<option>', {
							value : item,
							text : item
						}));

					});

				},
				error : function(e) {
							document.getElementById("#messageheader").innerHTML = "Unable to perform operations";
							$("#statusmessage").modal('show');
				}

			});

}