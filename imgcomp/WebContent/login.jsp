<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<script type="text/javascript">
function passMatch(){
    
	var password=document.forms["regForm"]["txtFldPword"].value;
	var repassword=document.forms["regForm"]["txtFldRPword"].value;

	if(password!=repassword){
		alert("Password not match");
		document.getElementById("txtFldRPword").focus();
	}
}
</script>
<body>
<div class="col-sm-4 col-sm-offset-1">
				<div class="login-form">
					<!--login form-->
					<h2>Login to your account</h2>
					<form action="LoginServlet" name="loginform"
					 method="post" enctype="multipart/form-data">
						<input name="txtFldEmail" value="" type="text" id="txtFldEmail"
							placeholder="E-mail Address" required/> <input name="txtFldPass"
							value="" type="password" id="txtFldPass" placeholder="Password" required/>
						<!-- <span> <input type="checkbox" class="checkbox">
							Keep me signed in
						</span> -->
				
						<button type="submit" class="btn btn-default" >Login</button>
					</form>
					
				</div>
				<!--/login form-->
			</div>
<div class="col-sm-4">
					<div class="signup-form"><!--sign up form-->
						<h2>New User Signup!</h2>
						<p style="color: green;">${RegisterSuccess}</p>
						<form action="register.jsp" method="post" name="regForm" enctype="application/x-www-form-urlencoded">
							<input type="text" placeholder="Name" name="txtFldFullname" value="" id="txtFldFullname" required="required"/>
							<input type="email" placeholder="Email Address" name="txtFldEmail" value="" id="txtFldEmail"  required="required"/>
							<input type="password" placeholder="Password" name="txtFldPword" value="" id="txtFldPword" required="required">
							<input type="password" placeholder="Confirm Password" name="txtFldRPword" value="" onchange="passMatch()" id="txtFldRPword" required="required">
							<input type="text" placeholder="Mobile" name="txtFldMobile" value="" id="txtFldMobile" required="required">
							<button type="submit" class="btn btn-default">Signup</button>
						</form>
					</div><!--/sign up form-->
				</div>
</body>
</html>