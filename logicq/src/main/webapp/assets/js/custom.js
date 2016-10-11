  
  jQuery(function($){
 /* ----------------------------------------------------------- */
  /*  1. SEARCH FORM
  /* ----------------------------------------------------------- */
   jQuery('#mu-search-icon').on('click', function(event) {
        event.preventDefault();
        $('#mu-search').addClass('mu-search-open');
    });
    
    jQuery('.mu-search-close').on('click', function(event) {
      $("#mu-search").removeClass('mu-search-open');
    });
/* ----------------------------------------------------------- */
/*  2. ABOUT US VIDEO
/* ----------------------------------------------------------- */
    // WHEN CLICK PLAY BUTTON 
    jQuery('#mu-abtus-video').on('click', function(event) {
      event.preventDefault();
      $('body').append("<div id='about-video-popup'><span id='mu-video-close' class='fa fa-close'></span><iframe id='mutube-video' name='mutube-video' frameborder='0' allowfullscreen></iframe></div>");        
      $("#mutube-video").attr("src", $(this).attr("href"));
    });         
    // WHEN CLICK CLOSE BUTTON
    $(document).on('click','#mu-video-close', function(event) {     
      $(this).parent("div").fadeOut(1000);
    });
    // WHEN CLICK OVERLAY BACKGROUND
    $(document).on('click','#about-video-popup', function(event) {
      $(this).remove();
    });
  /* ----------------------------------------------------------- */
  /*  3. TOP SLIDER (SLICK SLIDER)
  /* ----------------------------------------------------------- */    
    jQuery('#mu-slider').slick({
      dots: false,
      infinite: true,
      arrows: true,
      speed: 500,     
      autoplay: true,      
      cssEase: 'linear'
    });
  /* ----------------------------------------------------------- */
  /*  4. ABOUT US (SLICK SLIDER)
  /* ----------------------------------------------------------- */
    jQuery('#mu-testimonial-slide').slick({
      dots: true,
      infinite: true,
      arrows: false,
      speed: 500,
      autoplay: true,          
      cssEase: 'linear'
    });
  

  /* ----------------------------------------------------------- */
  /*  5. LATEST COURSE SLIDER (SLICK SLIDER)
  /* ----------------------------------------------------------- */    

    jQuery('#mu-latest-course-slide').slick({
      dots: true,
      arrows: false,
      infinite: true,
      speed: 300,
      slidesToShow: 3,
      slidesToScroll: 2,
      autoplay: true,
      autoplaySpeed: 2500,
      responsive: [
        {
          breakpoint: 1024,
          settings: {
            slidesToShow: 3,
            slidesToScroll: 3,
            infinite: true,
            dots: true
          }
        },
        {
          breakpoint: 600,
          settings: {
            slidesToShow: 2,
            slidesToScroll: 2
          }
        },
        {
          breakpoint: 480,
          settings: {
            slidesToShow: 1,
            slidesToScroll: 1
          }
        }
        // You can unslick at a given breakpoint now by adding:
        // settings: "unslick"
        // instead of a settings object
      ]
    });

  /* ----------------------------------------------------------- */
  /*  6. TESTIMONIAL SLIDER (SLICK SLIDER)
  /* ----------------------------------------------------------- */    

    jQuery('.mu-testimonial-slider').slick({
      dots: true,      
      infinite: true,
      arrows: false,
      autoplay: true,
      speed: 500,      
      cssEase: 'linear'
    });       

  /* ----------------------------------------------------------- */
  /*  7. COUNTER
  /* ----------------------------------------------------------- */

    jQuery('.counter').counterUp({
        delay: 10,
        time: 1000
    });


  /* ----------------------------------------------------------- */
  /*  8. RELATED ITEM SLIDER (SLICK SLIDER)
  /* ----------------------------------------------------------- */    

    jQuery('#mu-related-item-slide').slick({
      dots: false,
      arrows: true,
      infinite: true,
      speed: 300,
      slidesToShow: 2,
      slidesToScroll: 1,
      autoplay: true,
      autoplaySpeed: 2500,
      responsive: [
        {
          breakpoint: 1024,
          settings: {
            slidesToShow: 2,
            slidesToScroll: 1,
            infinite: true,
            dots: false
          }
        },
        {
          breakpoint: 600,
          settings: {
            slidesToShow: 1,
            slidesToScroll: 1
          }
        },
        {
          breakpoint: 480,
          settings: {
            slidesToShow: 1,
            slidesToScroll: 1
          }
        }
        // You can unslick at a given breakpoint now by adding:
        // settings: "unslick"
        // instead of a settings object
      ]
    });

  /* ----------------------------------------------------------- */
  /*  9. MIXIT FILTER (FOR GALLERY) 
  /* ----------------------------------------------------------- */  

    jQuery(function(){
      jQuery('#mixit-container').mixItUp();
    });

  /* ----------------------------------------------------------- */
  /*  10. FANCYBOX (FOR PORTFOLIO POPUP VIEW) 
  /* ----------------------------------------------------------- */ 

    jQuery(document).ready(function() {
      jQuery(".fancybox").fancybox();
    $.each([1,2,3,4,5,6], function( index, value ) {
	  $("#slidimage"+value).attr('src', "assets/img/slider/"+value+".jpg");
	  $("#slidh4"+value).text("Text Dynamic h4 "+value);
	  $("#slidh2"+value).text("Text Dynamic h2 "+value);
	  $("#slidh3"+value).text("Text Dynamic h3 "+value);
	});
	 $.ajax({
				   type: 'get',
            url: 'http://localhost:8090/commonproject/admin/content/getContentDetails',
			dataType: 'json',
            success: function (data) {
				var abtuscontent="";
			 for (i=0;i < data.length; i++) { 
                abtuscontent= data[i].value;
               }
               $('#abtus').text(abtuscontent);
            },
			error: function(e){  
          alert('Error: ' + e);  
       }
           
        })
});
	
  
  /* ----------------------------------------------------------- */
  /*  11. HOVER DROPDOWN MENU
  /* ----------------------------------------------------------- */ 
  
  // for hover dropdown menu
    jQuery('ul.nav li.dropdown').hover(function() {
      jQuery(this).find('.dropdown-menu').stop(true, true).delay(200).fadeIn(200);
    }, function() {
      jQuery(this).find('.dropdown-menu').stop(true, true).delay(200).fadeOut(200);
    }); 
  /* ----------------------------------------------------------- */
  /*  12. SCROLL TOP BUTTON
  /* ----------------------------------------------------------- */
  //Check to see if the window is top if not then display button
    jQuery(window).scroll(function(){
      if (jQuery(this).scrollTop() > 300) {
        jQuery('.scrollToTop').fadeIn();
      } else {
        jQuery('.scrollToTop').fadeOut();
      }
    });     
    //Click event to scroll to top
    jQuery('.scrollToTop').click(function(){
      jQuery('html, body').animate({scrollTop : 0},800);
      return false;
    });  
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
});

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
  
  
  function submitForm(){
	 
	  var uploadFoler=$("#pathSelect option:selected").text();
	   alert('submit form'+uploadFoler);
	  document.getElementById("myForm").action = "http://localhost:8090/commonproject/admin/file/uploadfiles/"+uploadFoler;
	   document.getElementById("myForm").submit();
	  }
	    function saveForm(){
	 
	  alert('save form');
	     var data = {
			  
            "name": $("#sliderSelect").val(),
            "imagepath":$("#imageSelect").val(),
            "text1":$("#text1").val(),
			 "text2":$("#text2").val(),
			  "text3":$("#text3").val(),
			   "textextra":$("#text4").val()
			   }
			  
			   $('#target').html('sending..');
			  $.ajax({
				   type: 'post',
            url: 'http://localhost:8090/commonproject/admin/content/saveOrUpdateHomeContent',
			contentType: "application/json; charset=utf-8",
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (data) {
                alert('success');
            },
           
        });
			     
			    
        
	  }
	  
	function  saveAboutUs (){
		 var data = {
			  
            "name": "AboutUs",
            "type":"HOME",
			"value":$("#aboutus").val()
			   }
			  $.ajax({
				   type: 'post',
            url: 'http://localhost:8090/commonproject/admin/content/saveOrUpdateContent',
			contentType: "application/json; charset=utf-8",
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (data) {
                alert('success');
            },
           
        });
	}
 