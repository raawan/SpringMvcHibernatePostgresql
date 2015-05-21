<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<#import  "/spring.ftl" as spring/>
<html>
<head>
	<title>CONGRATULATIONS</title>
	<link rel="stylesheet" type="text/css" href="<@spring.url '/resources/css/congratulations.css'/>" />
	<link rel="stylesheet" type="text/css" href="<@spring.url '/resources/css/global.css'/>"/>
</head>
<body>
	<div class="header">
		<p> CONGRATULATIONS! </p>
	</div>
	
	<div class="content">
	<div>
		<p>Congrats Payment Made!</p>
	</div>
		<br>
		<form action="/congratulations" method="post">
			
			<div>
				<input type="submit" value="MAKE ANOTHER PAYMENT" class="rounded-corners">
			</div>
		</form>
	</div>

	<div class="footer">
		<div>
				<span class="footer-element"><a href="<@spring.url '/contact_us'/>">Contact Us</a></span>
			<span class="footer-element"><a href="<@spring.url '/tandc'/>">Terms And Conditions</a></span>
				
		</div>
	</div>
</body>
</html>