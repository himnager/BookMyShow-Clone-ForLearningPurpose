
<%@page import="common.CommonFunctions"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="javax.sound.midi.SysexMessage"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@page import="admin.DbHandlerAdmin"%>
<%@page import="admin.ClsTblSeatBooked"%>
<%@page import="java.util.LinkedList"%>
<%@include file="Header.jsp" %>
<title>Seat Registration</title>
 <!-- <link rel="stylesheet" href="css/style.css" /> --> 
<script>
var TtlSilverSeatsSelectedValue=0;
function calculateSilverTicketPrice(id,obj,value) {
	//alert("checkbox selected is : "+id+ " "+ obj+"  value= "+ value);
	console.log("checkbox selected is : "+id+ " "+ obj+"  value= "+ value);
	console.log(obj);
	
	
	
  var checkBox = document.getElementById(id);
  var silverTktPriceId = document.getElementById("intSilverPrice");
  var silverTktPrice=silverTktPriceId.value;
//  alert("silverTktPrice= "+ silverTktPrice);
//alert(checkBox.checked+" icsd is checked ");
 if( checkBox.checked == true)
	 {
	 
	 TtlSilverSeatsSelectedValue=Number(TtlSilverSeatsSelectedValue)+Number(silverTktPrice);
	 //alert("checked TtlSilverSeatsSelectedValue"+ TtlSilverSeatsSelectedValue);
	 }
 if( checkBox.checked == false)
	 {
	 
  	TtlSilverSeatsSelectedValue=Number(TtlSilverSeatsSelectedValue)-Number(silverTktPrice);
  	//alert("now unchecked TtlSilverSeatsSelectedValue"+ TtlSilverSeatsSelectedValue);
	 }
  //document.getElementById("checkBox").disabled= true;
//  checkBox.disabled=true;
  
  var SilverPrice = document.getElementById("SilverPrice");
  if (checkBox.checked == true){
	  SilverPrice.style.display = "block";
	  SilverPrice.innerHTML="total Silver Ticket Price is "+TtlSilverSeatsSelectedValue+" Rs.";
	  document.getElementById("txtTtlSilverPrice").value=TtlSilverSeatsSelectedValue;
  } else {
	  document.getElementById("txtTtlSilverPrice").value=TtlSilverSeatsSelectedValue;
	  SilverPrice.style.display = "none";
  }
}
</script>


<script>
var TtlGoldSeatsSelectedValue=0;
function calculateGoldTicketPrice(id,obj,value) {
	//alert("checkbox selected is : "+id+ " "+ obj+"  value= "+ value);
	console.log("checkbox selected is : "+id+ " "+ obj+"  value= "+ value);
	console.log(obj);
	
	
	
  var checkBox = document.getElementById(id);
  var goldTktPriceId = document.getElementById("intGoldPrice");
  var goldTktPrice=goldTktPriceId.value;
//  alert("silverTktPrice= "+ silverTktPrice);
   if( checkBox.checked == true)
	 {
	 
	 TtlGoldSeatsSelectedValue=Number(TtlGoldSeatsSelectedValue)+Number(goldTktPrice);
	 //alert("checked TtlGoldSeatsSelectedValue"+ TtlGoldSeatsSelectedValue);
	 }
 if( checkBox.checked == false)
	 {
	 
	 TtlGoldSeatsSelectedValue=Number(TtlGoldSeatsSelectedValue)-Number(goldTktPrice);
  //	alert("now unchecked TtlGoldSeatsSelectedValue"+ TtlGoldSeatsSelectedValue);
	 }
  //document.getElementById("checkBox").disabled= true;
 // checkBox.disabled=true;
  
  var GoldPrice = document.getElementById("GoldPrice");
  if (checkBox.checked == true){
	  GoldPrice.style.display = "block";
	  GoldPrice.innerHTML="total Gold Ticket Price is "+TtlGoldSeatsSelectedValue+" Rs.";
	  document.getElementById("txtTtlGoldPrice").value=TtlGoldSeatsSelectedValue;
  } else {
	  document.getElementById("txtTtlGoldPrice").value=TtlGoldSeatsSelectedValue;
	  GoldPrice.style.display = "none";
  }
}
</script>

</head>
<body >
  <%                                                                             
       
      String strMid= session.getAttribute("ssnmid").toString();
        int intGoldPrice=Integer.parseInt(session.getAttribute("ssnGoldPrice").toString());
		int intSilverPrice= Integer.parseInt(session.getAttribute("ssnSilverPrice").toString());
	//	int intGoldPrice=500;
		//int intSilverPrice= 300;
		
		System.out.println("intGoldPrice " +intGoldPrice);
		System.out.println("intSilverPrice " + intSilverPrice);
       
       // String strMid="12"; 
   int mid=Integer.parseInt(strMid);
   	String strSlotChoosen=request.getParameter("selectedSlot"),strDateOfShow=request.getParameter("selctedDate");
 //  	String strSlotChoosen="1518",strDateOfShow="17-APR-2020";
   	//                     inside select seat .jsp   --- mid = 12  date of show 17-APR-2020  slot= 912
       System.out.println("inside select seat .jsp   --- mid = "+ mid +"  date of show "+ strDateOfShow+"  slot= "+strSlotChoosen);
       DbHandlerAdmin objDBA=new DbHandlerAdmin();
       System.out.println("seatregisteraiton -  1");
       
       SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yyyy");
       java.util.Date date = sdf1.parse(strDateOfShow);
       java.sql.Date dt = new java.sql.Date(date.getTime()); 
       //Date dt= Date.valueOf(strDateOfShow);
       //Date dt= Date.valueOf("17-APR-20");
       System.out.println("seatregisteraiton -  2");
       System.out.println("seatregisteraiton -  ");
       ClsTblSeatBooked objClsTblSeatBooked=objDBA.getseatsbookedbyidandtimeandDateOfShowSql(strMid, strSlotChoosen, dt);
       
       int intTtlGoldSeats=objClsTblSeatBooked.getTtlGoldSeats(),
    		   ttlSilverSeats=objClsTblSeatBooked.getTtlSilverSeats();//gs= 30 ,ss= 20
    		   
       
       String SILVERSEATBOOKED=objClsTblSeatBooked.getStrSilverSeatsBooked(),
       GOLDSEATBOOKED=objClsTblSeatBooked.getStrGoldSeatsBooked();
       
    
    		   
    		   
       String occupiedSilverSeats[]=SILVERSEATBOOKED.split(","),
       		  occupiedGoldSeats[]=GOLDSEATBOOKED.split(",");
       int intoccupiedSilverSeats[]=CommonFunctions.stringArrToIntArray(occupiedSilverSeats);
       int intoccupiedGoldSeats[]=CommonFunctions.stringArrToIntArray(occupiedGoldSeats);
       
       
       for(String str:occupiedGoldSeats)
       {
    	   System.out.println(str);
       }
       System.out.println("--gold seats up ------silver seats down---------");
       for(String str:occupiedSilverSeats)
       {
    	   System.out.println(str);
       }
       /* String occupiedSilverSeats[]={"0","2","3","1","25","24","13","14","33","34","39"},
      		  occupiedGoldSeats[]={"1","2","3","13","7","8","14","19","20"}; */
        	
        
        int Sn=occupiedSilverSeats.length,
         	Gn=occupiedGoldSeats.length;
        
        System.out.println(Sn);
        System.out.println(Gn);
        
        int found=0;	  
       %>
       
	<div class="jumbotron text-center bg-dark form-control ">
			<h4 class="text-warning">Book My Show</h4>
		
	</div> 

	 <%@include file="navbar.jsp" %>	 



	<%--  <%@include file="selcetSeat.jsp" %> 	 --%>
	
    <div class="container ">
      <div class="screen"> </div>
      <h4 class="display-4 small text-center">SCREEN</h4>
    
     <h4 class="text-center"  style="margin-top:77px">SILVER Seats</h4>
     <p id="SilverPrice" style="display:none">Checkbox is CHECKED!</p>
     <p id="GoldPrice" style="display:none">Checkbox is CHECKED!</p>
    total Silver Price is :  <input type="text"   id="txtTtlSilverPrice" name="txtTtlSilverPrice">
    total Gold Price is :  <input type="text"   id="txtTtlGoldPrice" name="txtTtlGoldPrice">
    
	<!-- Checkbox: <input type="checkbox" id="myCheck" value="1" onclick="calculateSilverTicketPrice(this.id,this,this.value)"> -->
	<a href="SeatRegisteration.jsp?selctedDate=<%=strDateOfShow%>&selectedSlot=<%=strSlotChoosen%>" class="btn btn-warning">Reset Ticket Booking</a>
     <div class="row ">
     		<pre style="color:white">    0     1      2     3     4     5     6     7      8     9</pre>
     </div>
     
     
       <form action="BookSeat" method="get">
         
         		
				      
					<div class="row">
					<%
					
		 	      		for(int isilverSeats=1 ;isilverSeats<=ttlSilverSeats;isilverSeats++)
			    	 	{		 	      			
		 	      		System.out.println(isilverSeats+" isilverseats ");
			 	      		int notobematched=isilverSeats;				 	   		
				 	   		
				 	   			if(CommonFunctions.isIntInsideArray(intoccupiedSilverSeats, notobematched))
				 	   			{
				 	   			%>
				 	   			&nbsp;&nbsp;<p class="bg-warning">S<%=isilverSeats%></p><input  type="checkbox" checked disabled name="SilverSeatCheckBox" style="background-color: red" id="S<%=isilverSeats%>" value="<%=isilverSeats%>">				 	   		
				 	   		<%
				 	   		} else {
				 	   			%>
&nbsp;&nbsp;<p class="bg-success">S<%=isilverSeats%></p><input  onclick="calculateSilverTicketPrice(this.id,this,this.value)" type="checkbox"  name="SilverSeatCheckBox" style="background-color: green" id="S<%=isilverSeats%>" value="<%=isilverSeats%>">	
				 	   			<%
				 	   		}		 	      		
		 	      			if(isilverSeats%10==0)
		 	      			{
		 	      				%>	  </div>
		 	      					   <div class="row">
		 	      			<%
		 	      			}
		 	      			%>
			 			<%-- <input  type="checkbox"  disabled name="SilverSeatCheckBox" class="seat" id="<%=s%>" value="S<%=s%>"> --%>
						  <%
				 	     }%>		
						</div>
						<div class="row" style="height:100px;">
						</div>
								<div class="row">
					<%					
		 	      		for(int igoldSeats=1 ;igoldSeats<=intTtlGoldSeats;igoldSeats++)
			    	 	{
		 	      		System.out.println(igoldSeats+" igoldSeats ");
		 	      		int notobematched=igoldSeats;
		 	   			if(CommonFunctions.isIntInsideArray(intoccupiedGoldSeats, notobematched))
	 	   				{
		 	      		%>		 	      		
		 	      		&nbsp;&nbsp;<p class="bg-warning">G<%=igoldSeats%></p> <input  type="checkbox" checked disabled name="GoldSeatCheckBox" class="seat" id="G<%=igoldSeats%>" value="<%=igoldSeats%>"> 
		 	      		<%
	 	   				}
		 	   			else
		 	   			{
		 	   				%>
&nbsp;&nbsp;<p class="bg-success">G<%=igoldSeats%></p> <input  type="checkbox" onclick="calculateGoldTicketPrice(this.id,this,this.value)"  name="GoldSeatCheckBox" class="seat" id="G<%=igoldSeats%>" value="<%=igoldSeats%>">
		 	   				<%
		 	   			}
		 	      			if(igoldSeats%10==0)
		 	      			{
		 	      				%>		 	      			
		 	      					   </div>
		 	      					   <div class="row">
		 	      			<%
		 	      			}
		 	      			%>
			 			       	<%-- <input  type="checkbox"  disabled name="SilverSeatCheckBox" class="seat" id="<%=s%>" value="S<%=s%>"> --%>
						  <%	
						 	
				 	     }%>		
						</div>
						<div class="row">
							<div class="col-md-12">
							<input type="hidden" value="<%=intGoldPrice%>" id="intGoldPrice" name="intGoldPrice">
							<input type="hidden" value="<%=intSilverPrice%>" id="intSilverPrice" name="intSilverPrice">
							<input type="hidden" value="<%=strSlotChoosen%>" name="selectedSlot">
							<input type="hidden" value="<%=strDateOfShow%>" name="selctedDate">
							
							
							<input type="submit" value="Book Seats" id="btnBook" class="btn btn-success"/>
							</div>
						</div>
						   	<%-- <%if(found!=1){%>
									<input  type="checkbox" name="SilverSeatCheckBox" class="seat" id="<%=s%>" value="<%=s%>">
							<%} %>  --%>

					   <%-- <%found=0;}%> --%>
      					
      	
		
       </form>
       <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
       ---------------------------------
       <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
       
  

 

   
	
	
	


<%@include file="Footer.jsp"%>
</body>