jQuery(function($) {
	/* ----------------------------------------------------------- */
	/*
	 * 1. SEARCH FORM /*
	 * -----------------------------------------------------------
	 */
	jQuery('#mu-search-icon').on('click', function(event) {
		event.preventDefault();
		$('#mu-search').addClass('mu-search-open');
	});

	jQuery('.mu-search-close').on('click', function(event) {
		$("#mu-search").removeClass('mu-search-open');
	});
	/* ----------------------------------------------------------- */
	/*
	 * 2. ABOUT US VIDEO /*
	 * -----------------------------------------------------------
	 */
	// WHEN CLICK PLAY BUTTON
	jQuery('#mu-abtus-video')
			.on(
					'click',
					function(event) {
						event.preventDefault();
						$('body')
								.append(
										"<div id='about-video-popup'><span id='mu-video-close' class='fa fa-close'></span><iframe id='mutube-video' name='mutube-video' frameborder='0' allowfullscreen></iframe></div>");
						$("#mutube-video").attr("src", $(this).attr("href"));
					});
	// WHEN CLICK CLOSE BUTTON
	$(document).on('click', '#mu-video-close', function(event) {
		$(this).parent("div").fadeOut(1000);
	});
	// WHEN CLICK OVERLAY BACKGROUND
	$(document).on('click', '#about-video-popup', function(event) {
		$(this).remove();
	});
	/* ----------------------------------------------------------- */
	/*
	 * 3. TOP SLIDER (SLICK SLIDER) /*
	 * -----------------------------------------------------------
	 */
	jQuery('#mu-slider').slick({
		dots : false,
		infinite : true,
		arrows : true,
		speed : 500,
		autoplay : true,
		cssEase : 'linear'
	});
	/* ----------------------------------------------------------- */
	/*
	 * 4. ABOUT US (SLICK SLIDER) /*
	 * -----------------------------------------------------------
	 */
	jQuery('#mu-testimonial-slide').slick({
		dots : true,
		infinite : true,
		arrows : false,
		speed : 500,
		autoplay : true,
		cssEase : 'linear'
	});

	/* ----------------------------------------------------------- */
	/*
	 * 5. LATEST COURSE SLIDER (SLICK SLIDER) /*
	 * -----------------------------------------------------------
	 */

	jQuery('#mu-latest-course-slide').slick({
		dots : true,
		arrows : false,
		infinite : true,
		speed : 300,
		slidesToShow : 3,
		slidesToScroll : 2,
		autoplay : true,
		autoplaySpeed : 2500,
		responsive : [ {
			breakpoint : 1024,
			settings : {
				slidesToShow : 3,
				slidesToScroll : 3,
				infinite : true,
				dots : true
			}
		}, {
			breakpoint : 600,
			settings : {
				slidesToShow : 2,
				slidesToScroll : 2
			}
		}, {
			breakpoint : 480,
			settings : {
				slidesToShow : 1,
				slidesToScroll : 1
			}
		}
		// You can unslick at a given breakpoint now by adding:
		// settings: "unslick"
		// instead of a settings object
		]
	});

	/* ----------------------------------------------------------- */
	/*
	 * 6. TESTIMONIAL SLIDER (SLICK SLIDER) /*
	 * -----------------------------------------------------------
	 */

	jQuery('.mu-testimonial-slider').slick({
		dots : true,
		infinite : true,
		arrows : false,
		autoplay : true,
		speed : 500,
		cssEase : 'linear'
	});

	/* ----------------------------------------------------------- */
	/*
	 * 7. COUNTER /* -----------------------------------------------------------
	 */

	jQuery('.counter').counterUp({
		delay : 10,
		time : 1000
	});

	/* ----------------------------------------------------------- */
	/*
	 * 8. RELATED ITEM SLIDER (SLICK SLIDER) /*
	 * -----------------------------------------------------------
	 */

	jQuery('#mu-related-item-slide').slick({
		dots : false,
		arrows : true,
		infinite : true,
		speed : 300,
		slidesToShow : 2,
		slidesToScroll : 1,
		autoplay : true,
		autoplaySpeed : 2500,
		responsive : [ {
			breakpoint : 1024,
			settings : {
				slidesToShow : 2,
				slidesToScroll : 1,
				infinite : true,
				dots : false
			}
		}, {
			breakpoint : 600,
			settings : {
				slidesToShow : 1,
				slidesToScroll : 1
			}
		}, {
			breakpoint : 480,
			settings : {
				slidesToShow : 1,
				slidesToScroll : 1
			}
		}
		// You can unslick at a given breakpoint now by adding:
		// settings: "unslick"
		// instead of a settings object
		]
	});

	/* ----------------------------------------------------------- */
	/*
	 * 9. MIXIT FILTER (FOR GALLERY) /*
	 * -----------------------------------------------------------
	 */

	jQuery(function() {
		jQuery('#mixit-container').mixItUp();
	});

	/* ----------------------------------------------------------- */
	/*
	 * 10. FANCYBOX (FOR PORTFOLIO POPUP VIEW) /*
	 * -----------------------------------------------------------
	 */

	jQuery(document)
			.ready(
					function() {
						jQuery.support.cors = true;
						jQuery(".fancybox").fancybox();
						getImageType("ALL");
						
						$.ajax(
							    {
							        type: "GET",
							        url : 'http://localhost:8090/commonproject/admin/getrecentevents/',
							        data: "{}",
							        contentType: "application/json; charset=utf-8",
							        dataType: "json",
							        cache: false,
							        success: function (data) {
							            
							        var trHTML = '';
							                
							        $.each(data, function (i, item) {
							            
							            trHTML += '<tr><td>' + data.eventname[i] + '</td><td>' + data.eventstartdate[i] + '</td><td>' + data.eventenddate[i] + '</td><td>' + data.eventmessage[i] + '</td></tr>';
							        });
							        
							        $('#eventtable').append(trHTML);
							        
							        },
							        
							        error: function (msg) {
							            
							            alert(msg.responseText);
							        }
							    });
						$.ajax(
							    {
							        type: "GET",
							        url : 'http://localhost:8090/commonproject/admin/getnoticeboarddetails/',
							        data: "{}",
							        contentType: "application/json; charset=utf-8",
							        dataType: "json",
							        cache: false,
							        success: function (data) {
							            
							        var trHTML = '';
							                
							        $.each(data, function (i, item) {
							            
							            trHTML += '<tr><td>' + data.description[i] + '</td></tr>';
							        });
							        
							        $('#noticeboardtable').append(trHTML);
							        
							        },
							        
							        error: function (msg) {
							            
							            alert(msg.responseText);
							        }
							    });
						$.ajax(
							    {
							        type: "GET",
							        url : 'http://localhost:8090/commonproject/admin/getstorydetails/',
							        data: "{}",
							        contentType: "application/json; charset=utf-8",
							        dataType: "json",
							        cache: false,
							        success: function (data) {
							            
							        var trHTML = '';
							                
							        $.each(data, function (i, item) {
							            
							        	trHTML += '<tr><td>' + data.description[i] + '</td></tr>';
							        });
							        
							        $('#storydetails').append(trHTML);
							        
							        },
							        
							        error: function (msg) {
							            
							            alert(msg.responseText);
							        }
							    });
});

	/* ----------------------------------------------------------- */
	/*
	 * 11. HOVER DROPDOWN MENU /*
	 * -----------------------------------------------------------
	 */

	// for hover dropdown menu
	jQuery('ul.nav li.dropdown').hover(
			function() {
				jQuery(this).find('.dropdown-menu').stop(true, true).delay(200)
						.fadeIn(200);
			},
			function() {
				jQuery(this).find('.dropdown-menu').stop(true, true).delay(200)
						.fadeOut(200);
			});
	/* ----------------------------------------------------------- */
	/*
	 * 12. SCROLL TOP BUTTON /*
	 * -----------------------------------------------------------
	 */
	// Check to see if the window is top if not then display button
	jQuery(window).scroll(function() {
		if (jQuery(this).scrollTop() > 300) {
			jQuery('.scrollToTop').fadeIn();
		} else {
			jQuery('.scrollToTop').fadeOut();
		}
	});
	// Click event to scroll to top
	jQuery('.scrollToTop').click(function() {
		jQuery('html, body').animate({
			scrollTop : 0
		}, 800);
		return false;
	});
	jQuery('#login')
			.on(
					'click',
					function(event) {
						event.preventDefault();
						var username = $("#username").val();
						var password = $("#password").val();
						$
								.ajax({
									type : 'get',
									url : 'http://localhost:8090/commonproject/login/loginuser/'
											+ username + "/" + password,
									dataType : 'json',
									success : function(data) {
										if (data == true) {
											window.location.href = "admin.html";
										} else if (data == false) {
											window.location.href = "index.html";
										}
									},
									error : function(e) {
										window.location.href = "index.html";
									}

								});

					});
});

function submitForm() {

	var uploadFoler = $("#pathSelect option:selected").text();

	document.getElementById("myForm").action = "http://localhost:8090/commonproject/admin/file/uploadfiles/"
			+ uploadFoler;
	document.getElementById("myForm").submit();
	var data = {

		"name" : $("#sliderSelect").val(),
		"imagepath" : $("#imageSelect").val(),
		"text1" : "",
		"text2" : "",
		"text3" : "",
		"textextra" : ""
	}
}
function saveForm() {

	var data = {

		"name" : $("#sliderSelect").val(),
		"imagepath" : "assets/img/gallery/small/" + $("#imageSelect").val(),
		"text1" : $("#fsc").val(),
		"text2" : $("#ssc").val(),
		"text3" : $("#tsc").val()

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
					alert('successfully saved');
				},
				error : function(e) {
					alert('Error:Not Saved' + e);
				}

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
					alert('successfully saved');
				},
				error : function(e) {
					alert('Error:Not Saved ' + e);
				}

			});
}

function getImageType(imageType) {

	var type = 'ALL';
	if (imageType == 'ALL') {
		type = 'ALL';
	}
	if (imageType.id == 'all') {

		type = 'ALL';
	}
	if (imageType.id == 'class_room') {
		type = 'CLASSROOM';
	}
	if (imageType.id == 'library') {
		type = 'LIBRARY';
	}
	if (imageType.id == 'sports') {
		type = 'SPORTS';
	}
	if (imageType.id == 'annual_function') {
		type = 'ANNUALFUNCTION';
	}

	var imagepath = [];
	$
			.ajax({
				type : 'get',
				url : 'http://localhost:8090/commonproject/admin/content/getHomeContentDetails/'
						+ type,
				dataType : 'json',
				success : function(data) {
					for (i = 0; i < data.length; i++) {
						imagepath[i] = data[i].imagepath;

					}
					displayImage(imagepath);

				},
				error : function(e) {

				}

			});

}
function displayImage(imagepath) {
	document.getElementById("imagecontainer").innerHTML = "";
	var container = document.getElementById("imagecontainer");

	for (var i = 0; i < imagepath.length; i++) {

		var txt1 = '<li class="col-md-4 col-sm-6 col-xs-12 mix lab"><div class="mu-single-gallery"><div class="mu-single-gallery-item"><div class="mu-single-gallery-img"><a href="#">';
		var txt2 = "'<img alt='img' src=" + imagepath[i] + ">'";
		var txt3 = '</a> <div class="mu-single-gallery-info"> <div class="mu-single-gallery-info-inner"><h4>Image Title</h4><p>Web Design</p>  <a href="assets/img/gallery/big/10.jpg" data-fancybox-group="gallery" class="fancybox"><span class="fa fa-eye"></span></a><a href="#" class="aa-link"><span class="fa fa-link"></span></a></div></div> </div></div> </div></li>';

		container.innerHTML += (txt1 + txt2 + txt3);
	}
}
