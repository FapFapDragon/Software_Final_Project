<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login In</title>
<style>
@import url('https://fonts.googleapis.com/css?family=Quicksand');

* {
	font-family: 'Quicksand', sans-serif;
	transition: .5s ease;
}

.container {
	align-items: center;
	position: absolute;
	top: 50%;
	left: 50%;
	width: 30%;
	transform: translate(-50%, -50%);
}

.container label {
	font-size: 1.4rem;
	font-weight: bold;
	color: rgba(150, 150, 220, .9);
	line-height: 2rem;
}

.container img.profile {
	border: 4px solid rgba(150, 150, 220, .9);
	display: block;
	margin: 0 auto;
	width: 90%;
	height: auto;
	border-radius: 50%;
	margin-bottom: 20px;
}

.container .message-warning {
	opacity: 0;
	width: 90%;
	left: 140%;
	top: 50px;
	position: absolute;
	display: flex;
	flex-flow: row nowrap;
	justify-content: space-around;
	align-items: flex-start;
}

.container .message-warning img {
	display: inline-flex;
	margin-right: 5px;
	width: 60px;
	height: 60px;
}

.container .message-warning div {
	border-radius: 5px;
	color: rgba(240, 240, 240, 1);
	background-color: rgba(50, 50, 50, .9);
	padding: .4rem;
	font-family: 'Quicksand', sans-serif;
	font-size: 1.1rem;
}

.container .container-input input:invalid {
	color: rgba(250, 100, 100, .7);
}

.container input {
	background-color: white;
	padding-left: .9rem;
	padding-right: .9rem;
	padding-top: 1.4rem;
	padding-bottom: .9rem;
	position: relative;
	display: block;
	width: 100%;
	border-radius: 4px;
	font-size: 1.2rem;
	border: 2px solid rgba(127, 127, 127, .9);
	font-weight: bold;
	color: rgba(60, 60, 210, .9);
}

.container-input input:focus {
	outline: none;
	box-shadow: none;
	border: 2px solid rgba(0, 0, 0, 1);
}

.container-input input:focus ~.sub-placeholder {
	transform: scale(.9);
	top: .4rem;
	left: .4rem;
	color: rgba(200, 200, 250, 1);
}

.container-input input:valid ~.sub-placeholder {
	transform: scale(.9);
	top: .4rem;
	left: .4rem;
	color: rgba(200, 200, 250, 1);
}
/*
.container-input input:invalid{
  border: 2px solid rgba(250, 79, 79, .9);
  animation: error .8s infinite ease, error-tresh .2s infinite ease;
}*/
.container-input input:valid {
	border: 2px solid rgba(79, 250, 79, .9);
}

.container-input {
	position: relative;
}

.sub-placeholder {
	position: absolute;
	top: 1.1rem;
	left: 1.1rem;
	color: rgba(200, 200, 250, 1);
}

.container .loginin {
	margin-left: 1.2rem;
	width: 100%;
	margin-top: 20px;
	background-color: rgba(110, 110, 220, .9);
	cursive: pointer;
	color: white;
	text-align: center;
	padding: 20px;
}

@
keyframes error { 0%{ //
	transform: translate(0px, 0px);
	border: 2px solid white;
}

50%{
//
transform
:
 
translate
(-2px
,
0
px
);

    
border
:
2px
 
solid
 
rgba
(250
,
120,
120,
.4
);

  
}
95%{
border
:
2px
 
solid
 
rgba
(250
,
120,
120,
.4
);

  
}
}
@
keyframes error-tresh { 0%{
	transform: translate(0px, 0px); //
	background-color: white;
}
50%{
transform
:
 
translate
(-1px
,
0
px
);
//background-color
:
 
rgba
(250
,
120,
//120,
.4
);

  
}
95%{
//
background-color
:
 
rgba
(250
,
120,
//120,
.4
);

    
transform
:
 
translate
(1px
,
0
px
);

  
} 
}
</style>
</head>
<body>
	<div class="container">
		<div class="message-warning">
		</div>
		<form action="Login" method="post">
			<label for="uname">UserName</label>
			<div class="container-input">
				<input id="uname" class="uname" type="text" name="uname"></input> <span class="sub-placeholder">UserName</span>
			</div>
			<label for="password">Password</label>
			<div class="container-input">
				<input id="password" class="password" type="password" name="password"></input> <span
					class="sub-placeholder">your password</span>
			</div>
			<input class="loginin" type="submit" value="Login">
			</form>
	</div>
</body>
</html>