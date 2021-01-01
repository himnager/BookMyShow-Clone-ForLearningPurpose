<%@include file="Header.jsp" %>
<title>SUCCESS</title>

</head>
<body>
	<div class="jumbotron  bg-dark ">
		<h4 class="muted text-warning">Book My Show</h4>
	</div>
		
	
	<div class="container">
		<div class="row d-flex justify-content-center">
			<div class="col-md-7">
			
			<% String what=request.getParameter("what"); %>
			
			<h1><%=what %> SUCCESFULLY</h1>
			
			
			</div>
		</div>
	</div>

</body>
<%@include file="Footer.jsp"%>