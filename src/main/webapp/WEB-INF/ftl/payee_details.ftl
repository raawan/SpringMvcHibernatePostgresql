<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<#import "/spring.ftl" as spring/>
<html>
<head>
	<title>PAYEE DETAILS</title>
	<link rel="stylesheet" type="text/css" href="<@spring.url '/resources/css/payee_details.css'/>" />
	<link rel="stylesheet" type="text/css" href="<@spring.url '/resources/css/global.css'/>"/>
</head>
<body>
	<div class="header">
		<p> WHO ARE YOU PAYING </p>
		<p> (Your Payee's Details) </p>		
	</div>

	<div class="content">
		<form name = "payee" action="/payee_details" method="POST">
			<div>
				<label for="acctholdername">Bank Account Holder's Name :</label>
				<input type="text" name="acctholdername" id="acctholdername" value="${payee.acctholdername!}">
			</div>
			<br>
			<div>
				<label for="amount">Amount:</label>
				<input type="text" id="amount" name="amount" value="${payee.amount!}" >
			</div>
			<br>
			<div>
				<label for="reference">Reference Memo:</label>	
				<input type="text"  id="reference" name="reference" value="${payee.reference!}">
			</div>
			<br>
			<div>
				<label for="bankname">Bank Name:</label>
				<input type="text"  id="bankname" name="bankname" value="${payee.bankname!}">
			</div>
			<br>
			<div>
				<label for="bankaddress">Bank Address:</label>
				<textarea id="bankaddress" name="bankaddress" value="${payee.bankaddress!}"></textarea>
			</div>
			<br>
			<div>
				<label for="sortcode">Sortcode:</label>
				<input type="text"  id="sortcode" name="sortcode" value="${payee.sortcode!}" >
			</div>
			<br>
			<div>
				<label for="accountnumber">A/C Number:</label>
				<input type="text"  id="accountnumber" name="accountnumber" value="${payee.accountnumber!}" >
			</div>
			<br>
			<div>
				<label for="dateofpayment">Payment Date:</label>
				<input type="date" id="dateofpayment" name="dateofpayment" value="${payee.dateofpayment!}" >
			</div>
			<br><br>
			<div>
				<input type="submit" value="Submit Details"  class="rounded-corners">
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