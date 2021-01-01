<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css" >
 <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  
  
<link rel="stylesheet" href="mycss/mycss.css" >
<script src="jquery.js"></script>
<script type="text/javascript" src="jquery.js"></script> 
<script type="text/javascript" src="jquery.seat-charts.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<style>

input[type="checkbox"] {
  -webkit-appearance: none;
  -moz-appearance: none;
  appearance: none;

  /* Styling checkbox */
  width: 16px;
  height: 16px;
  background-color: grey;
}

input[type="checkbox"]:checked {
  background-color: Blue;
}

input[type="checkbox"]{
width: 40px;
height: 40px;

}
</style>
<body>
 <script>
 $(document).ready(function() {
  //set initial state.
  $('#textbox1').val($(this).is(':checked'));

  $('#CB1').change(function() {
    $('#textbox1').val($(this).is(':checked'));
  });

  $('#CB1').click(function() {
    if (!$(this).is(':checked')) {
      alert("hhhhh");
      document.getElementById(this).checked=eval(true); 
      
     
  });
});



</script>

<div class="row">
		<header class="col-md-3">
		<img src="images2/book.jpg"/>
		</header>
	</div>
	<div>
	<h1><div class="text-center">Screen</div></h1>
	</div>

 <form  action="Bill" method="post">
<div id="checks">
       
      
        <input id="CB1" name="CB1" type="checkbox" onchange="fun(this.id)" value="300">
        <input id="CB2" name="CB2" type="checkbox" onchange="fun(this.id)" value="300"> 
         <input id="CB3"  name="CB3"type="checkbox" onchange="fun(this.id)" value="300">
          <input id="CB4" name="CB4"type="checkbox" onchange="fun(this.id)" value="300">
           <input id="CB5"name="CB5" type="checkbox" onchange="fun(this.id)" value="300">
            <input id="CB6"name="CB6" type="checkbox"onchange="fun(this.id)" value="300">
             <input id="CB7" type="checkbox" value="300">
             <input type="text" id="textbox1"/>
              <input id="CB8" type="checkbox" value="300"> 
              <input id="CB9" type="checkbox" value="300">
              </div>
              
        <input type="checkbox" id="CB10" value="ON">
    <div class="row" style="margin-top: 25px;">
        <div class="col-md-3">
   <input type="submit"  value="" id="css" class="form-control btn btn-success"/>
   </div>
</div>
</form>
</div>
<script type="text/javascript">
 var true1="true";
 var false1="false";
 var dcSplit, posnEq, firstGrp, lastGrp, posnCB, regEx, i=0;
 dcSplit=document.cookie.split("; ");
 regEx=(/CB\d=/);           
 for(i=0; i<dcSplit.length; i++)
  { posnEq = dcSplit[i].indexOf("=")+1;      
    posnCB=dcSplit[i].search(regEx);
    if(posnCB != -1)
      { firstGrp = dcSplit[i].substring(posnCB, posnEq-1);
        lastGrp = dcSplit[i].substring( posnEq, dcSplit[i].length);  
        document.getElementById(firstGrp).checked=eval(lastGrp); 
      //  alert(firstGrp);
     //  alert(lastGrp);
        if(lastGrp.length==true1.length){
             //    alert(firstGrp);
                   document.getElementById(firstGrp).value=0;
               //  alert("11");
        }
        else if(lastGrp.length==false1.length){
              //  alert(firstGrp);
              //  alert("22");
                }
     }  }     
// ------
 var now=new Date(), tomorrow, allInputs, cookieStr;
 tomorrow=new Date((now.setDate(now.getDate())+(1*24*60*60*1000))).toGMTString(); 
 allInputs=document.getElementById("checks").getElementsByTagName("input");
 for(i=0; i<allInputs.length; i++){ allInputs[i].onclick=writeCookie; }
// --------   
 function writeCookie()
   { cookieStr=this.id+"="+this.checked+"; expires="+tomorrow+"; path=/";       
     document.cookie=cookieStr;
   } 
 // -------     
</script>
<script>
var ssr=300;
var hh="";
var ll="";
var chhh
var total=0;
function fun(id){
	 var sss=parseInt(document.getElementById(id).value);
	 if(sss==300 && ll.length!=0)
		 {
		 ssr=300;
		 var vars=ll.split(",");
		 }
		 alert(vars+"vars");
		 ll="";
		 hh="";
		 
		 for(var i=0;i<vars.length;i++)
			{ alert(vars[i]);
		//	alert('pair of parm and value='+pair+'pair.length='+pair.length);
			if(vars[i]==id)
				{total=total-300;
				ssr=0;
				}
			else if (vars[i]!=id)
				{
				hh=hh+vars[i];
				alert(vars[i]);
				}
			
			
				}
			ll=hh;
			alert(hh+"hh");
			}
		 
         if(ssr==300 && sss==300){
		  alert("111111");
		 
		
		 total=total+sss;
		 alert(total);
		 
		 var dd=id;
		 ll=ll+","+dd+",";
		 
		 alert(ll);
		 }
	 else if(sss==0)
		 {
		 alert("this cannot be selected");
		// document.getElementById(id).checked=true;
		 }
		 }
	
  </script>
  
 


</body>
</html>