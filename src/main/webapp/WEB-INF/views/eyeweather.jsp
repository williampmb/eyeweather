
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page isELIgnored="false" %>
<%@ page import="com.pmb.eyeweather.users.User" %>
<html>
<head>
 	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	<title>Home</title>
	<script type="text/javascript" src="resources/eyeweather.js" > </script>
	<script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
		<link rel="stylesheet" href="resources/eyeweather.css" type="text/css"/>
	
    <!-- Bootstrap -->
  
	<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
	
</head>
<body onLoad="getLocation('${user.id}')">	

		<div class="container" >
			<br/>
			<br/>
				<div class="row title">
					<div class="col-md-6 col-xs-6">
						Eye Weather
					</div>
					
					<div class="col-md-6 col-xs-6 to-left">
						<a href="/eyeweather/logout" class="pull-right btn-sm btn-primary">Logout</a>
					</div>
				</div>
				
				<br/>
				<br/>
				<div class="row title">
					<div class= "col-md-12 col-xs-12">
												
							<input class="form-latlon" type="text" id="latText" name="latitude" placeholder="latitude">
							<input class="form-latlon" type="text" id="lonText" name="longitude" placeholder="longitude">							
							<div class="btn btn-sm btn-primary" onclick="createLocation('${user.id}')">Submit</div>
						
					</div>
				</div>
			<br/>			
			<br/>
			
				<div class="row" id="locations">	
					
				</div>
		</div>
  	</body>
</html>
