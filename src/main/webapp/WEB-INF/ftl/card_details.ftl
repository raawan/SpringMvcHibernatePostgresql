<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<#import "/spring.ftl" as spring/>
<html>
<head>
	<title>CARD DETAILS</title>
	<link rel="stylesheet" type="text/css" href="<@spring.url '/resources/css/card_details.css'/>" />
	<link rel="stylesheet" type="text/css" href="<@spring.url '/resources/css/global.css'/>"/>
</head>
<body>
	<div class="header">
		<p> HOW WILL YOU PAY FOR THIS ? </p>
		<p> (Your Details) </p>		
	</div>

	<div class="content">
		<form action="/card_details" method="POST">
			<div>
				<label for="nameoncard">Name On Card:</label>
				<input type="text" id="nameoncard" name="nameoncard" value="${cardDetails.nameoncard!}">
			</div>
			<br>
			<div>
				<label for="cardnumber">Amount:</label>
				<input type="text" id="cardnumber" name="cardnumber" value="${cardDetails.cardnumber!}">
			</div>
			<br>
			<div>
				<label for="expirydate">Expiry Date (mm/yy):</label>
				<input type="text" id="expirydate" name="expirydate" value="${cardDetails.expirydate!}">
			</div>
			<br>
			<div>
				<label for="cvv">CVV</label>
				<input type="text" id="cvv" name="cvv" value="${cardDetails.cvv!}">
			</div>
			<br>
			<div>
				<label for="emailaddress">EmailAddress:</label>
				<input type="text" id="emailaddress" name="emailaddress" value="${cardDetails.emailaddress!}">
			</div>
			<br>
			<div>
				<label for="totalcost">Total Cost Charged To Your Card:</label>
				<input type="text" id="totalcost" name="totalcost" value="${cardDetails.totalcost!}">
			</div>
			<br><br>
			<div>
				<input type="submit" value="Submit Details" class="rounded-corners">
			</div>	
		</form>

	<div class="footer">
		<div>
			<span class="footer-element"><a href="<@spring.url '/contact_us'/>">Contact Us</a></span>
			<span class="footer-element"><a href="<@spring.url '/tandc'/>">Terms And Conditions</a></span>		
		</div>
	</div>

</body>
</html>