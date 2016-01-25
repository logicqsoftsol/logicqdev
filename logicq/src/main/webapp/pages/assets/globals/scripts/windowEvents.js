function syncValuesToControls() {
    
console.log(document.getElementById("tab9_1").className);
console.log(document.getElementById("tab9_2").className);
console.log(document.getElementById("tab9_3").className);
console.log(document.getElementById("tab9_4").className);
console.log(document.getElementById("tab9_5").className);
console.log(document.getElementById("tab9_6").className);

var value = "";

if(document.getElementById("tab9_1").className == "tab-pane active"){
	value = "Doctor";
}
else if(document.getElementById("tab9_2").className == "tab-pane active"){
	value = "Pathology";
}
else if(document.getElementById("tab9_3").className == "tab-pane active"){
	value = "Pharmacy";
}
else if(document.getElementById("tab9_4").className == "tab-pane active"){
	value = "Beauty";
}
else if(document.getElementById("tab9_5").className == "tab-pane active"){
	value = "Yoga";
}
else if(document.getElementById("tab9_6").className == "tab-pane active"){
	value = "Hospital";
}
	
	console.log("Service Type : " + value);
	
	try{
    	document.getElementById("pac-input-location").value = value;
	}
	catch(e){
    	console.log("Exception setting service type : " + e);
	}

if(location.hash == "#tab_form3_tab2")
 {
 try{
     if(document.getElementById("input-specialisation").value == null || document.getElementById("input-specialisation").value == undefined || document.getElementById("input-specialisation").value.length == 0){
   document.getElementById("input-specialisation").value = "Cardiologist"
  }
 }
 catch(e){
     console.log("Exception setting input-specialisation : " + e);
 }
 }

}
window.onhashchange = syncValuesToControls;