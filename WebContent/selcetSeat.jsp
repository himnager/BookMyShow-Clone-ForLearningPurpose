
    <div class="container ">
      <div class="screen"> </div>
      <h4 class="display-4 small text-center">SCREEN</h4>
    
     <h4 class="text-center"  style="margin-top:77px">SILVER Seats</h4>
     <div class="row ">
     		<pre style="color:white">    0     1      2     3     4     5     6     7      8     9</pre>
     </div>
     
       <%
       
       String strMid= session.getAttribute("ssnmid").toString();
   int mid=Integer.parseInt(strMid);
       
       System.out.println("inside select seat .jsp   --- mid = "+ mid);
       
       String occupiedSilverSeats[]={"0","2","3","1","25","24","13","14","33","34","39"},
     		  occupiedGoldSeats[]={"1","2","3","13","7","8","14","19","20"};
       	
       
       int Sn=occupiedSilverSeats.length,
        	Gn=occupiedGoldSeats.length;
       
       System.out.println(Sn);
       System.out.println(Gn);
       
       int found=0;	  
    	%>
       
     <form action="">
  
	   <div class="row"> <!-- silver row 1 -->
				      
					<pre style="color:white">0 </pre>
					<%
		 	      		for(int s=0 ;s<10;s++)
			    	 	{
		 	      			for( int os=0;os<Sn;os++)
				    	 	{		
				 	      			if(s==Integer.parseInt(occupiedSilverSeats[os])){%>
			 					        	<input  type="checkbox"  disabled name="SilverSeatCheckBox" class="seat" id="<%=s%>" value="S<%=s%>">
								   <%
								   found=1;
								   break;
				 	      			}%>
				 	      	<%}%>		
						    			
						   	<%if(found!=1){%>
									<input  type="checkbox" name="SilverSeatCheckBox" class="seat" id="<%=s%>" value="<%=s%>">
							<%} %> 

					   <%found=0;}%>
      					
      	</div>
		
		 <div class="row"><!-- silver row 2 -->
				      
				      <pre style="color:white">1 </pre>
						<%
						
		 	      		for(int s=10 ;s<20;s++)
			    	 	{
		 	      			for( int os=0;os<Sn;os++)
				    	 	{		
				 	      			if(s==Integer.parseInt(occupiedSilverSeats[os])){%>
			 					        	<input  type="checkbox"  disabled name="SilverSeatCheckBox" class="seat" id="<%=s%>" value="S<%=s%>">
								   <%
								   found=1;
								   break;
				 	      			}%>
				 	      	<%}%>		
						    			
						   	<%if(found!=1){%>
									<input  type="checkbox" name="SilverSeatCheckBox" class="seat" id="<%=s%>" value="<%=s%>">
							<%} %> 

					   <%found=0;}%>
      						
      	</div>
      	
      	<div class="row"><!-- silver row 3 -->
				      
				       <pre style="color:white">2 </pre>
				      <%
		 	      		for(int s=20 ;s<30;s++)
			    	 	{
		 	      			for( int os=0;os<Sn;os++)
				    	 	{		
				 	      			if(s==Integer.parseInt(occupiedSilverSeats[os])){%>
			 					        	<input  type="checkbox"  disabled name="SilverSeatCheckBox" class="seat" id="<%=s%>" value="S<%=s%>">
								   <%
								   found=1;
								   break;
				 	      			}%>
				 	      	<%}%>		
						    			
						   	<%if(found!=1){%>
									<input  type="checkbox" name="SilverSeatCheckBox" class="seat" id="<%=s%>" value="<%=s%>">
							<%} %> 

					   <%found=0;}%>
      	</div>
      	
      	<div class="row"><!-- silver row 4 -->
				      
				     <pre style="color:white">3 </pre>
				      
				      <%
						for(int s=30 ;s<40;s++)
			    	 	{
		 	      			for( int os=0;os<Sn;os++)
				    	 	{		
				 	      			if(s==Integer.parseInt(occupiedSilverSeats[os])){%>
			 					        	<input  type="checkbox"  disabled name="SilverSeatCheckBox" class="seat" id="<%=s%>" value="S<%=s%>">
								   <%
								   found=1;
								   break;
				 	      			}%>
				 	      	<%}%>		
						    			
						   	<%if(found!=1){%>
									<input  type="checkbox" name="SilverSeatCheckBox" class="seat" id="<%=s%>" value="<%=s%>">
							<%} %> 

					   <%found=0;}%>	
      	</div>
		
		  <h4 class="text-center" style="margin-top:77px" >GOLD Seats</h4>
		  <div class="row ">
     		 <pre style="color:white">    0     1      2     3     4     5     6     7      8     9</pre>
    	  </div>
     
	
		<div class="row"><!-- gold row 1 -->
				      
				     <pre style="color:white">0 </pre>
				      
				      <%
						for(int s=0 ;s<10;s++)
			    	 	{
		 	      			for( int os=0;os<Gn;os++)
				    	 	{		
				 	      			if(s==Integer.parseInt(occupiedGoldSeats[os])){%>
			 					        	<input  type="checkbox"  disabled name="GoldSeatCheckBox" class="seat" id="<%=s%>" value="S<%=s%>">
								   <%
								   found=1;
								   break;
				 	      			}%>
				 	      	<%}%>		
						    			
						   	<%if(found!=1){%>
									<input  type="checkbox" name="GoldSeatCheckBox" class="seat" id="<%=s%>" value="<%=s%>">
							<%} %> 

					   <%found=0;}%>	
      	</div>
				
		<div class="row"><!-- gold row 2 -->
				      
				     <pre style="color:white">1 </pre>
				      
				      <%
						for(int s=10 ;s<20;s++)
			    	 	{
		 	      			for( int os=0;os<Gn;os++)
				    	 	{		
				 	      			if(s==Integer.parseInt(occupiedGoldSeats[os])){%>
			 					        	<input  type="checkbox"  disabled name="GoldSeatCheckBox" class="seat" id="<%=s%>" value="S<%=s%>">
								   <%
								   found=1;
								   break;
				 	      			}%>
				 	      	<%}%>		
						    			
						   	<%if(found!=1){%>
									<input  type="checkbox" name="GoldSeatCheckBox" class="seat" id="<%=s%>" value="<%=s%>">
							<%} %> 

					   <%found=0;}%>	
      	</div>	
				
				
				
				
					 <div class="row align-items-center" style="margin:25px 0px">
				  		<div class=" col text-center">
				  			<input class="btn btn-outline-primary text-center" type="submit" value="BOOK NOW">
				  		</div>	
		  			 </div>
		 </form>
		 
		




 

   