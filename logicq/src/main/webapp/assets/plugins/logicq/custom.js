$(document).ready(function(){
	// $("#compsubj").multiselect();
	 //$("#optionalsubj").multiselect();
	 
	 var MAX_OPTIONS = 7;
    $("#feesetup").click(function(){
		var displayfieldemp = document.getElementById("empreg");
		var displayfieldfee = document.getElementById("feesetupsection");
		var clickfield = document.getElementById("feesetup");
		var displayfieldstdt= document.getElementById("studreg");	
		var attandancetable=  document.getElementById("searchAllAttendance");
		var displayfieldcoursesetup=  document.getElementById("coursedetails");	
	  var displayfieldpaymentDetails=  document.getElementById("paymentdetails");
		var displayfieldCalnderSetup=  document.getElementById("calendersetup");	  
	if(displayfieldfee.style.display == "block") {
    		displayfieldfee.style.display = "none";
  	}
	else {
		displayfieldfee.style.display = "block";
		if(displayfieldemp.style.display == "block") {
		displayfieldemp.style.display = "none";
		}if(displayfieldstdt.style.display == "block") {
		displayfieldstdt.style.display = "none";
		}
		if(attandancetable.style.display == "block") {
		attandancetable.style.display = "none";
		}if(displayfieldcoursesetup.style.display == "block") {
		displayfieldcoursesetup.style.display = "none";
		}
		if(displayfieldpaymentDetails.style.display == "block") {
		displayfieldpaymentDetails.style.display = "none";
		}
		if(displayfieldCalnderSetup.style.display == "block") {
		displayfieldCalnderSetup.style.display = "none";
		}
	}
});
$("#empregclick").click(function(){
		var displayfieldemp = document.getElementById("empreg");
		var displayfieldfee = document.getElementById("feesetupsection");
		var displayfieldstdt= document.getElementById("studreg");	
		var clickfield = document.getElementById("empregclick");
		var attandancetable=  document.getElementById("searchAllAttendance");	
		var displayfieldcoursesetup=  document.getElementById("coursedetails");	
		var displayfieldpaymentDetails=  document.getElementById("paymentdetails");
		var displayfieldCalnderSetup=  document.getElementById("calendersetup");		
	if(displayfieldemp.style.display == "block") {
    		displayfieldemp.style.display = "none";
  	}
	else {
		displayfieldemp.style.display = "block";
		if(displayfieldfee.style.display == "block") {
		displayfieldfee.style.display = "none";
		}if(displayfieldstdt.style.display == "block") {
		displayfieldstdt.style.display = "none";
		}if(attandancetable.style.display == "block") {
		attandancetable.style.display = "none";
		}if(displayfieldcoursesetup.style.display == "block") {
		displayfieldcoursesetup.style.display = "none";
		}if(displayfieldpaymentDetails.style.display == "block") {
		displayfieldpaymentDetails.style.display = "none";
		}
		if(displayfieldCalnderSetup.style.display == "block") {
		displayfieldCalnderSetup.style.display = "none";
		}
	}		
    });
	
	$("#stduentregclick").click(function(){
		var displayfieldemp = document.getElementById("empreg");
		var displayfieldfee = document.getElementById("feesetupsection");
		var displayfieldstdt= document.getElementById("studreg");
		var clickfield = document.getElementById("stduentregclick");
		var attandancetable=  document.getElementById("searchAllAttendance");	
		var displayfieldcoursesetup=  document.getElementById("coursedetails");	
		var displayfieldpaymentDetails=  document.getElementById("paymentdetails");	
		var displayfieldCalnderSetup=  document.getElementById("calendersetup");			
	if(displayfieldstdt.style.display == "block") {
    		displayfieldstdt.style.display = "none";
  	}
	else {
		displayfieldstdt.style.display = "block";
		if(displayfieldfee.style.display == "block") {
		displayfieldfee.style.display = "none";
		}
		if(displayfieldemp.style.display == "block") {
		displayfieldemp.style.display = "none";
		}if(attandancetable.style.display == "block") {
		attandancetable.style.display = "none";
		}
		if(displayfieldcoursesetup.style.display == "block") {
		displayfieldcoursesetup.style.display = "none";
		}
		if(displayfieldpaymentDetails.style.display == "block") {
		displayfieldpaymentDetails.style.display = "none";
		}
		if(displayfieldCalnderSetup.style.display == "block") {
		displayfieldCalnderSetup.style.display = "none";
		}
	}		
    });
	
	
	$("#payemntHistory").click(function(){
		var clickpaymenthistory=  document.getElementById("payemntHistory");	
		var displayfieldemp = document.getElementById("empreg");
		var displayfieldfee = document.getElementById("feesetupsection");
		var displayfieldstdt= document.getElementById("studreg");
		var attandancetable=  document.getElementById("searchAllAttendance");	
		var displayfieldcoursesetup=  document.getElementById("coursedetails");	
		var displayfieldpaymentDetails=  document.getElementById("paymentdetails");	
		var displayfieldCalnderSetup=  document.getElementById("calendersetup");		
	if(displayfieldpaymentDetails.style.display == "block") {
    		displayfieldpaymentDetails.style.display = "none";
  	}
	else {
		displayfieldpaymentDetails.style.display = "block";
		if(displayfieldfee.style.display == "block") {
		displayfieldfee.style.display = "none";
		}
		if(displayfieldemp.style.display == "block") {
		displayfieldemp.style.display = "none";
		}if(attandancetable.style.display == "block") {
		attandancetable.style.display = "none";
		}
		if(displayfieldcoursesetup.style.display == "block") {
		displayfieldcoursesetup.style.display = "none";
		}
		if(displayfieldstdt.style.display == "block") {
		displayfieldstdt.style.display = "none";
		}
		if(displayfieldCalnderSetup.style.display == "block") {
		displayfieldCalnderSetup.style.display = "none";
		}
	}		
    });
	
	
	
	$("#coursesetup").click(function(){
		var displayfieldemp = document.getElementById("empreg");
		var displayfieldfee = document.getElementById("feesetupsection");
		var displayfieldstdt= document.getElementById("studreg");
		var clickfield = document.getElementById("coursesetup");
		var attandancetable=  document.getElementById("searchAllAttendance");	
		var displayfieldcoursesetup=  document.getElementById("coursedetails");
		var displayfieldpaymentDetails=  document.getElementById("paymentdetails");	
		var displayfieldCalnderSetup=  document.getElementById("calendersetup");		
	if(displayfieldcoursesetup.style.display == "block") {
    		displayfieldcoursesetup.style.display = "none";
  	}
	else {
		displayfieldcoursesetup.style.display = "block";
		if(displayfieldfee.style.display == "block") {
		displayfieldfee.style.display = "none";
		}
		if(displayfieldemp.style.display == "block") {
		displayfieldemp.style.display = "none";
		}if(attandancetable.style.display == "block") {
		attandancetable.style.display = "none";
		}
		if(displayfieldstdt.style.display == "block") {
		displayfieldstdt.style.display = "none";
		}
		if(displayfieldpaymentDetails.style.display == "block") {
		displayfieldpaymentDetails.style.display = "none";
		}
		if(displayfieldCalnderSetup.style.display == "block") {
		displayfieldCalnderSetup.style.display = "none";
		}
	}		
    });

	
	$("#admincalndersetup").click(function(){
		var displayfieldemp = document.getElementById("empreg");
		var displayfieldfee = document.getElementById("feesetupsection");
		var displayfieldstdt= document.getElementById("studreg");
		var clickfield = document.getElementById("admincalndersetup");
		var attandancetable=  document.getElementById("searchAllAttendance");	
		var displayfieldcoursesetup=  document.getElementById("coursedetails");
		var displayfieldpaymentDetails=  document.getElementById("paymentdetails");	
		var displayfieldCalnderSetup=  document.getElementById("calendersetup");				
	if(displayfieldCalnderSetup.style.display == "block") {
    		displayfieldCalnderSetup.style.display = "none";
  	}
	else {
		displayfieldCalnderSetup.style.display = "block";
		if(displayfieldfee.style.display == "block") {
		displayfieldfee.style.display = "none";
		}
		if(displayfieldcoursesetup.style.display == "block") {
		displayfieldcoursesetup.style.display = "none";
		}
		if(displayfieldemp.style.display == "block") {
		displayfieldemp.style.display = "none";
		}if(attandancetable.style.display == "block") {
		attandancetable.style.display = "none";
		}
		if(displayfieldstdt.style.display == "block") {
		displayfieldstdt.style.display = "none";
		}
		if(displayfieldpaymentDetails.style.display == "block") {
		displayfieldpaymentDetails.style.display = "none";
		}
	}		
    });
	
   $("#addfee").click(function () {
	$("#confirmfeeoper").text("Add");
	$("#coursename").prop("readonly", false);
	$("#coursefee").prop("readonly", false);
	$("#feechargetype").prop("readonly", false);
    });
	
	$("#updatefee").click(function () {
	$("#confirmfeeoper").text("Update");
	$("#coursename").prop("readonly", false);
	$("#coursefee").prop("readonly", false);
		$("#feechargetype").prop("readonly", false);
	
    });
	 $("#deletefee").click(function () {
	$("#confirmfeeoper").text("Delete");
	$("#coursename").prop("readonly", true);
	$("#coursefee").prop("readonly", true);
	$("#feechargetype").prop("readonly", true);
    });
	 $("#search").click(function () {
		 $("#confirmfeeoper").text("Search");
		
	  });
	
	 $("#lastupdate").prop("readonly", true);
		$("#updatedby").prop("readonly", true);	

	//$(".sel-table>tbody").selectable({filter: 'tr'});
	  
	  $("#registertab").click(function () {
		  localStorage.setItem("tabsearchtype", "registertab");
		 $("#tabsearchmodaltitle").text("Looking For Register Details");
		 $('#searchmaintab').modal('show');
	  });
	    $("#attandancetab").click(function () {
		  localStorage.setItem("tabsearchtype", "attandancetab");
		  $("#tabsearchmodaltitle").text("Looking For Attandance Details");
		   $('#searchmaintab').modal('show');
	  });
	   $("#paymenttab").click(function () {
		  localStorage.setItem("tabsearchtype", "paymenttab");
		   $("#tabsearchmodaltitle").text("Looking For Payment History Details");
		    $('#searchmaintab').modal('show');
	  });
	 $("#feeandcoursetab").click(function () {
		  localStorage.setItem("tabsearchtype", "feeandcoursetab");
		  $("#tabsearchmodaltitle").text("Looking For Course & Fee Details");
		   $('#searchmaintab').modal('show');
	  });
	  
	   $("#maintabsearch").click(function () {
		var displayfieldemp = document.getElementById("empreg");
		var displayfieldfee = document.getElementById("feesetupsection");
		var displayfieldstdt= document.getElementById("studreg");
		var displayfieldcoursesetup = document.getElementById("coursedetails");
		var displayfieldpaymentDetails=  document.getElementById("paymentdetails");	
		if(displayfieldemp.style.display == "block") {
			displayfieldemp.style.display = "none";
		}
		if(displayfieldfee.style.display == "block") {
			displayfieldfee.style.display = "none";
		}
		if(displayfieldstdt.style.display == "block") {
			displayfieldstdt.style.display = "none";
		}
		if(displayfieldcoursesetup.style.display == "block") {
			displayfieldcoursesetup.style.display = "none";
		}
		var searchfor= localStorage.getItem("tabsearchtype");
		
		var attandancetable=  document.getElementById("searchAllAttendance");
		
		if("attandancetab"==searchfor){
			if(attandancetable.style.display == "none") {
				attandancetable.style.display = "block";
			}
		}
		if("paymenttab"==searchfor){
			if(displayfieldpaymentDetails.style.display == "none") {
				displayfieldpaymentDetails.style.display = "block";
			}
		}
		$("#searchmaintab").modal('hide');
		
	}); 
    

});