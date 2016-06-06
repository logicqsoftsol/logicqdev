$(document).ready(function () {
	 $("#searchSP").click(function() {
		 var location = $("#locationSearch").val();
		 var entity = $("#entitysearch").val();
			  $.ajax({
				  type: 'GET',
				  url: 'http://127.0.0.1:8090/logicq/search/serviceprovider/getAllSPforlocation/'+location+'/'+entity,
				  dataType: "json",
				  contentType:"application/json",
				  success:function(res, status, xhr){ 
					alert("servvice call");
				  },
				  error: function (res, status, xhr) {
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