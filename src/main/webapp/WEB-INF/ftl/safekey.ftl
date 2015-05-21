<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<#import "/spring.ftl" as spring/>
<html>
<head>
	<title>SAFEKEY</title>
	<link rel="stylesheet" type="text/css" href="<@spring.url '/resources/css/safekey.css'/>" />
	<link rel="stylesheet" type="text/css" href="<@spring.url '/resources/css/global.css'/>"/>
</head>
<body>
	<div class="header">
		<p> SAFEKEY </p>
	</div>

	<div class="content">
		<form action="/safekey" method="post">
			<div>
				<label for="safekey">ENTER SAFEKEY</label>
				
			</div>
			<div>
				<input type="password" id="safekey">
			</div>
			<br><br>
			<div>
				<input type="submit" value="CONFIRM" class="rounded-corners">
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