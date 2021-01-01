<%@include file="Header.jsp" %>
<title>HOME</title>
</head>
<body>
	<div class="jumbotron  bg-dark ">
	
		<h4 class="muted text-warning">Book My Show</h4>
		
		<div style="margin-left:90%; ">
			<a href="#" >
				<button type="button" class="btn btn-outline-danger">Sign In</button>
			</a>
		</div>
	</div>
		
	<div class="container" >
		<form action="AuthUser" method="post">
			<div class="row d-flex justify-content-center">
				<div class=" col-md-7 bg-primary text-white text-center" >USER LOGIN</div>
			</div>
			<div class="row d-flex justify-content-center"style="padding-top: 30px">
				<div class="col-md-3">
					User Name
				</div>
		
				<div class="col-md-3">
					<input class="form control " placeholder="Enter Username" type="text" name="uUnm">
				</div>
			</div>
			
			<div class="row d-flex justify-content-center" style="padding-top: 10px ">
				<div class="col-md-3">
					Password
				</div>
		
				<div class="col-md-3">
					<input class="form control" placeholder="Enter Password" type="password" name="uPwd">
				</div>
			</div>
		
			
			<div class="row d-flex justify-content-center" style="padding-top: 10px; margin-left:177px " >
				<div class="col-md-3">
				<input class="form-control btn btn-success"  type="submit" value="LOGIN">
				</div>
			</div>
			
			
		</form>
		
	</div>	
	
	<div class="container" style="padding-top: 30px">
		<form action="AuthAdmin" method="post">
			<div class="row d-flex justify-content-center">
				<div class=" col-md-7 bg-primary text-white text-center" >ADMIN LOGIN</div>
			</div>		
				
			<div class="row d-flex justify-content-center"style="padding-top: 30px">
				<div class="col-md-3">
					User Name
				</div>
		
				<div class="col-md-3">
					<input class="form control " placeholder="Enter Username" type="text" name="aUnm">
				</div>
			</div>
			
			<div class="row d-flex justify-content-center" style="padding-top: 10px ">
				<div class="col-md-3">
					Password
				</div>
		
				<div class="col-md-3">
					<input class="form control" placeholder="Enter Password" type="password" name="aPwd">
				</div>
			</div>
		
			
			<div class="row d-flex justify-content-center" style="padding-top: 10px; margin-left:177px " >
				<div class="col-md-3">
				<input class="form-control btn btn-success"  type="submit" value="LOGIN">
				</div>
			</div>
			
			
		</form>
		
	</div>
</body>
<%@include file="Footer.jsp" %>

