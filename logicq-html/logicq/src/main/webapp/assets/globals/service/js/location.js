var addresslist='';
$(document).ready(function() {
    $.ajax({
		method: 'GET',
        url: "http://127.0.0.1:8090/logicq/app/login",
		 dataType : "json",
		contentType: "application/json",
		cache:true,
		  success: function(response) { 
            addresslist=response;
           }
    });
    
});

function displayResult(item) {
    $('.alert').show().html('You selected <strong>' + item.value + '</strong>: <strong>' + item.text + '</strong>');
}
$('#location').typeahead({
    source: addresslist,
    onSelect: displayResult
});