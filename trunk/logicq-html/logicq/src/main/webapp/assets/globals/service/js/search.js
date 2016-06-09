$(document).ready(function () {
	 $("#searchSP").click(function() {
		 var location = $("#locationSearch").val();
		 var entity = $("#entitysearch").val();
			  $.ajax({
				  type: 'GET',
				  url: 'http://127.0.0.1:8090/logicq/search/serviceprovider/getAllSPforlocation/'+location+'/'+entity,
				  dataType: "json",
				  contentType:"application/json",
				  success:function(result){ 
                    if (result.length > 0) {
                         
                        for (var i = 0; i < result.length; i++) {
											$("#accordion").append("<div class='col-sm-12 box-border' id='profiledetails'> <div class='col-sm-2'>"
															+"<img class='user-image img-responsive'"+
																"src='assets/admin1/img/male-doctor.jpg'></div>"+
														"<div class='col-sm-6 doctor-list-show'>"+
															"<h4>"+result[i].fullname+"</h4>"+
															"<p>MBBS , MD - Medicine , DNB (Cardiology)</p>"+
															"<p>Cardiologist</p> <p>11 Years Experience</p>"+
															"<p class='list-show-icon'>"+
																"<img src='assets/admin1/img/vaccinationathome.png'>"+
																"<img src='assets/admin1/img/emergency.png'>"+
																"<img src='assets/admin1/img/familydoctor.png'>"+ 
																"<img src='assets/admin1/img/nurse13.png'> </p></div>"+
																"<div class='col-sm-4'>"+
															"<div class='right-list-show'>"+
																"<p><span><i class='fa fa-thumbs-o-up'></i> 200 </span>Recommendations </p><p>"+
																	"<a href='#'><i class='fa fa-comment'></i> 15 Feedback</a> </p>"+
																"<p><i class='fa fa-map-marker'></i> Pune </p>"+
																"<p id='fees'>"+
																	"<i class='fa fa-inr'></i> 300 </p></div></div>"
														);
                          
                        }
                    }
				},
				  error: function (result) {
					  alert("servvice fail");
	              }
				});
	});
	 var getUrlParameter = function getUrlParameter(sParam) {
		    var sPageURL = decodeURIComponent(window.location.search.substring(1)),
		        sURLVariables = sPageURL.split('&'),
		        sParameterName,
		        i;

		    for (i = 0; i < sURLVariables.length; i++) {
		        sParameterName = sURLVariables[i].split('=');

		        if (sParameterName[0] === sParam) {
		            return sParameterName[1] === undefined ? true : sParameterName[1];
		        }
		    }
		};

		var token = getUrlParameter('token');
		if(token!=null){alert('nihar');}
	 
});