<%@include file="Header.jsp" %>
<title>Upload Movie</title>
</head>
<body>
	
	
</body>
	<div class="jumbotron  bg-dark ">
		<h4 class="muted text-warning">Book My Show</h4>
	</div>
		
	<div class="container" >
		<form action="UploadMovie" method="post">
			<div class="form-group row">
			    <label for="mId" class="col-sm-2 col-form-label">Movie ID</label>
			    <div class="col-sm-7">
			      <input type="number" class="form-control" name="mId" placeholder="enter movie ID">
			    </div>
		  	</div>
		  	
		  	<div class="form-group row">
			    <label for="mNm" class="col-sm-2 col-form-label">MOVIE NAME </label>
			    <div class="col-sm-7">
			      <input type="text" class="form-control" name="mNm" placeholder="enter movie NAME">
			    </div>
		  	</div>
		  	<div class="form-group row">
			    <label for="mStar" class="col-sm-2 col-form-label">STARS </label>
			    <div class="col-sm-7">
					<select class="form-control" name="mStar">
					      <option>1</option>
					      <option>2</option>
					      <option>3</option>
					      <option>4</option>
					      <option>5</option>
				    </select>			    
			    </div>
		  	</div>
		  	<div class="form-group row">
			    <label for="sDate" class="col-sm-2 col-form-label">START DATE </label>
			    <div class="col-sm-7">
			   	 	<input type="date" name="sDate" max="3000-12-31" min="1000-01-01" class="form-control">
				
			    </div>  
		  	</div>
		  	
		  	<div class="form-group row">
			    <label for="eDate" class="col-sm-2 col-form-label">END DATE </label>
			    <div class="col-sm-7">
			   	 	<input type="date" name="eDate" max="3000-12-31" min="1000-01-01" class="form-control">
			    </div>  
		  	</div>
		  	
			<div class="form-group row">
			   <label for="mLang" class="col-sm-2 col-form-label">LANGUAGE</label>
			   <div class="col-sm-7">
			      <input type="text" class="form-control" name="mLang" placeholder="enter movie LANGUAGE">
			    </div>
		  	</div>
			
		  	
		  	<div class="form-group row">
			    <label for="gPrice" class="col-sm-2 col-form-label">GOLD PRICE</label>
			    <div class="col-sm-7">
			      <input type="number" class="form-control" name="gPrice" placeholder="enter GOLD PRICE">
			    </div>
		  	</div>
		  	<div class="form-group row">
			    <label for="sPrice" class="col-sm-2 col-form-label">SILVER PRICE</label>
			    <div class="col-sm-7">
			      <input type="number" class="form-control" name="sPrice" placeholder="enter SILVER PRICE">
			    </div>
		  	</div>
		  	
		  	<div class="form-group row">
			    <label for="slot912" class="col-sm-2 col-form-label">SLOT 9-12</label>
			    <div class="col-sm-7">
			    	<input type="hidden" name="slot912" value="false">
			    	<input type="checkbox" class="form-control" id="slot912" name="slot912" value="true">		
			    </div>
		  	</div>
			
			<div class="form-group row">
			    <label for="slot1215" class="col-sm-2 col-form-label">SLOT 12-15</label>
			    <div class="col-sm-7">
			    	<input type="hidden" name="slot1215" value="false">
			    	<input type="checkbox" class="form-control" id="slot1215" name="slot1215" value="true">		
			    </div>
		  	</div>
		  	
		  	<div class="form-group row">
			    <label for="slot1518" class="col-sm-2 col-form-label">SLOT 15-18</label>
			    <div class="col-sm-7">
			    <input type="hidden" name="slot1518" value="false">
			    	<input type="checkbox" class="form-control" id="slot1518" name="slot1518" value="true">		
			    </div>
		  	</div>
		  	
		  	<div class="form-group row">
			    <label for="slot1821" class="col-sm-2 col-form-label">SLOT 18-21</label>
			    <div class="col-sm-7">
			  		<input type="hidden" name="slot1821" value="false">
			    	<input type="checkbox" class="form-control" id="slot1821" name="slot1821" value="true">		
			    </div>
		  	</div>
		  	
		  	<div class="form-group row">
			    <label for="mInm" class="col-sm-2 col-form-label">IMAGE NAME </label>
			    <div class="col-sm-7">
			      <input type="text" class="form-control" name="mInm" placeholder="enter Image Name">
			    </div>
		  	</div>
		  	
		  	<div class="form-group row">
		  	 	<label for="mImg" class="col-sm-2 col-form-label">MOVIE IMAGE </label>
			  	<div class="col-sm-7">
			  	 <label class="custom-file-label" for="customFile">Choose image</label>
				  	<input type="file" class="custom-file-input" name="mImg"> 
				</div>
			</div>
			
			<div class="row d-flex justify-content-center" style="padding-top: 10px; margin-left:-77px " >
				<div class="col-md-7">
					<input class="form-control btn btn-danger"  type="submit" value="UPLOAD">
				</div>
			</div>
		</form>
	</div>
<%@include file="Footer.jsp"%>