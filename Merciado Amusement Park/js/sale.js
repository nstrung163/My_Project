//Daily Admission
$(document).ready(function(){
    $("#select").change(function(){
         
    var a=$("#select").val();
    var nd="";
    if(a=="low")
        nd="$20 <del>$25.99</del>";
    else
        nd="$25.99";        
$("#p1").html(nd);
