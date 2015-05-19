<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<#import "/spring.ftl" as spring/>
<html>
<head>
	<title>New Payment</title>
	<link rel="stylesheet" type="text/css" href="<@spring.url '/resources/css/new_payment.css'/>" />
	<link rel="stylesheet" type="text/css" href="<@spring.url '/resources/css/global.css'/>"/>
</head>
<body>

	<div class="header">
		<p>NEW PAYMENT</p>
	</div>

	<div class="content">
		<p class="content-text">Pay anyone who has a U.K. Bank account with your American Express card</p>
		<form action="" method="POST">
				<input type="submit" value="Make A Payment" class="rounded-corners">	
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