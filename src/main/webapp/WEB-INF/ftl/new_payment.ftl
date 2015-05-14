<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<#import "/spring.ftl" as spring/>
<html>
<head>
	<title>New Payment</title>
	<link rel="stylesheet" type="text/css" href="<@spring.url '/resources/css/new_payment.css'/>"/>
</head>
<body>
	<div id="header">
		<p>New Payment</p>
	</div>
	<div id="container">
		<p>Pay Anyone who has a U.K. Bank Account with your American Express card</p>
		<form method="POST">
			<fieldset>
				<input type="submit" value="Make A Payment">
			</fieldset>
		</form>
	</div>
	<div id="footer">
		<p>
			<ul>
				<li>Contact Us</li>
				<li>Terms And Conditions</li>
				<li>Legal Disclaimer</li>
			</ul>
		</p>
	</div>
</body>
</html>