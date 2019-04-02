<!DOCTYPE html>
<html lang="en">

<head>
<title>Banking</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="Myaccount.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>

<body>

	<div class="container-fluid">


		<form action="updateDetails.do" method ="post">
			<label for="text">Account number:</label> 
			<input type="text" class="form-control"  name="accountId" value="${account.accountId}" readonly>
				 <label for="Name">Account Holder Name</label> 
				 <input type="text" class="form-control" name="accountHolderName" value="${account.accountName}"> <br>
			<label for="Account Type">Account Type</label>
			 <select name="accountType" >
			 <option>${account.accountType}</option>
				<option value="Savings">Savings</option>
				<option value="Current">Current</option>
			</select> 
			<br>
			<label for="Balance">Account Balance</label>
            <input type ="text" class = "form-control" name="accountBalance" value="${account.accountBalance}" readonly>
            <br>
			<button type="submit" class="btn btn-primary">Update Account</button>

		</form>
	</div>

</body>

</html>