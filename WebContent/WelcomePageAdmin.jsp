<%@include file="Header.jsp" %>
<title>Welcome Admin</title>
</head>
<body>
	
	<div class="jumbotron  bg-dark ">
		<h4 class="muted text-warning">Book My Show</h4>
	</div>
		
	
	<div class="container">
		<div class="row d-flex justify-content-center">
			<div class="col-md-7">
				<a href="UploadMovie.jsp">
					<button type="button" class="btn btn-primary btn-block">UPLOAD MOVIE</button>
				</a>
			</div>
		</div>
		
		<div class="row d-flex justify-content-center" style="padding-top:25px">
			<div class="col-md-7">
				<button type="button" class="btn btn-primary btn-block">EDIT MOVIE</button>
			</div>
		</div>
		
		<div class="row d-flex justify-content-center" style="padding-top:25px">
			<div class="col-md-7">
				<button type="button" class="btn btn-primary btn-block">DELETE MOVIE</button>
			</div>
		</div>
		
		
		<div class="row d-flex justify-content-center" style="padding-top:25px">
			<div class="col-md-7">
				<button type="button" class="btn btn-primary btn-block">GENERATE MOVIE CUPPON CODE</button>
			</div>
		</div>
	</div>
	
	
</body>
<%@include file="Footer.jsp"%>