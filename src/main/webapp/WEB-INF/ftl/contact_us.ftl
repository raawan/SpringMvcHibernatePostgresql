<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<#import "/spring.ftl" as spring/>
<html>
<head>
	<title>CONTACT US</title>
	<link rel="stylesheet" type="text/css" href="<@spring.url '/resources/css/contact_us.css'/>" />
	<link rel="stylesheet" type="text/css" href="<@spring.url '/resources/css/global.css'/>"/>
</head>
<body>
	<div class="header">
		<p>CONTACT US</p>
	</div>

	<div class="content">
		<div class="content-text">
			<div class="address-line-1"> UK Office </div>
			<br>
			<div class="address-line-2"> 
				Mauris turpis nunc, ligula.
				Suspendisse feugiat.
				Ut varius tincidunt libero.
			</div>
			<br>		
			<div class="address-line-3">T:+44(0)9999999999</div>
			<div class="address-line-4">F:+44(0)9999999999</div>
		</div>
	</div>

	<div class="footer">
		<div>
			<span class="footer-element"><a href="<@spring.url '/contact_us'/>">Contact Us</a></span>
			<span class="footer-element"><a href="<@spring.url '/tandc'/>">Terms And Conditions</a></span>	
			<span class="footer-element"><a href="<@spring.url '/newPayment'/>">New Payment</a> </span>	
		</div>
	</div>
</body>
</html>