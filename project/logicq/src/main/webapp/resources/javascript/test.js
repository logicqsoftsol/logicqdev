$(function() {
  var availableTags = [
    "Pune", "Bhubaneswar", "Delhi", "Mumbai", "Kolkata", "Balasore",
    "Clojure", "COBOL", "ColdFusion", "Erlang", "Fortran",
    "Groovy", "Haskell", "Java", "JavaScript", "Lisp", "Perl",
    "PHP", "Python", "Ruby", "Scala", "Scheme"
  ];
  var availableTags1 = [
                       "Doctor", "Plumber"
                     ];
  
  
  $("#userlocation").autocomplete({
    source: availableTags
  });
  $("#searcserviceprovider").autocomplete({
	    source: availableTags1
	  });
});