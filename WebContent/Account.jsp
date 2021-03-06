<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Banking</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="Myaccount.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>

<body>

    <div class="container-fluid">
        <center>
            <h1>Welcome Online Banking Application</h1>
        </center>
        <div class="row" style="background-color:lavender;">
            <a class="nav-link" href="Index.html">Home</a>
            <a class="nav-link" href="Register.html">Open New Account</a>
            <a class="nav-link" href="Withdraw.html">Withdraw</a>
            <a class="nav-link" href="Deposit.html">Deposit</a>
            <a class="nav-link" href="Fund.html">Fund Transfer</a>
            <a class="nav-link" href="Check.html">CheckBalance</a>
            <a class="nav-link" href="Account.do">Display Account Details</a>
            <a class="nav-link" href="Search.html">Search Account </a>
            <a class="nav-link" href="Delete.html">Delete Account </a>
            <a class="nav-link" href="Update.html">Update Account </a>
            
        </div>
    
        <table style="width:100%">
        </center><h1>Account Details</h1></center>
            <tr>
              <th>Account Id</th>
              <th>Account Holder Name</th>
              <th>Account Type</th>
              <th>Balance</th>
            </tr>
            
            <tbody>
            	<c:forEach var="account" items="${accounts}">
            		<tr>
            			<td>${account.accountId}</td>
            			<td>${account.accountName}</td>
            			<td>${account.accountType}</td>
            			<td>${account.accountBalance}</td>          		
              		</tr>
            	</c:forEach>
            
            </tbody>
            
          </table>
        </div>

</body>

</html>