<%@ page isELIgnored="false"%>

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


		<table style="width: 100%">
			</center>
			<h1>Account Details</h1>
			</center>
			<tr>
				<th>Account Id</th>
				<th>Account Holder Name</th>
				<th>Customer Type</th>
				<th>Balance</th>
			</tr>
			<tbody>
				<tr>
					<td>${account.accountId}</td>
					<td>${account.accountName}</td>
					<td>${account.accountType}</td>
					<td>${account.accountBalance}</td>
				</tr>

			</tbody>


		</table>
	</div>

</body>

</html>