<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<#import "/spring.ftl" as spring/>
<html>
<head>
	<title>PAYMENT CONFIRMATION</title>
	<link rel="stylesheet" type="text/css" href="<@spring.url '/resources/css/confirmation.css'/>" />
	<link rel="stylesheet" type="text/css" href="<@spring.url '/resources/css/global.css'/>"/>
</head>
<body>
	<div class="header">
		<p> CONFIRMATION </p>
	</div>

	<div class="content">
		<form action="/confirmation" method="POST">
			
			<div>
				<label for="name">You are paying :</label>
				<input type="text" id="name" readonly="true"  value="${confirmationModel.nameoncard!}">
			</div>
			<br>
			<div>
				<label for="amount">The Sum Of:</label>
				<input type="text" id="amount"  readonly="true"  value="${confirmationModel.amount!}">
			</div>
			<br>
			<div>
				<label for="sortcode">Payee Sortcode:</label>	
				<input type="text" id="sortcode"  readonly="true" value="${confirmationModel.sortcode?string?replace(",","")}">
			</div>
			<br>
			<div>
				<label for="accountnumber">Payee Account:</label>
				<input type="text" id="accountnumber"  readonly="true" value="${confirmationModel.accountnumber!}">
			</div>
			<br>
			<div>
				<label for="reference">Reference:</label>
				<input type="text" id="reference"  readonly="true" value="${confirmationModel.reference!}">
			</div>
			<br>
			<div>
				<label for="paymentdate">Payment Date:</label>
				<input type="text" id="paymentdate"  readonly="true" value="${confirmationModel.dateofpayment?date}">			</div>
			<br><br>
			<div>
				<input type="submit" value="Make Payment" class="rounded-corners">
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
