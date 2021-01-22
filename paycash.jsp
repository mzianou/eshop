<html>
	<head>
		<meta charset="UTF-8">
		<title>Pay Cash</title>
		<link rel="stylesheet" href="paycash.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Sofia">
		<meta name="viewport" content="width=device-width, initial-scale=1">
	</head>
	<body>
		<div class="header">
			<h1>The baby's shop</h1>
			<h2>All you need for your baby.</h2>
		</div>
		<form method="post" action="order">
			<input type="hidden" id="cost" name="cost" value="<%=cart.getCost()%>"/>
			<input type="hidden" id="date" name="date" value="<%=new java.util.Date()%>"/>
			<br></br>
			<a align="center"> ΣΥΝΟΛΟ ΠΡΟΪΟΝΤΩΝ: <%=cart.getNumOfItems()%> </a>
			<br></br>
			<a align="center">ΣΥΝΟΛΙΚΟ ΚΟΣΤΟΣ: <%=cart.getCost()%> €</a> 
			<br></br>
			<a align="center"> Δώσε Διεύθυνση Παράδωσης:<input name="ADDRESS" size=20> </a> 
			<br></br>
			<p><input type="submit" value="ΑΠΟΣΤΟΛΗ ΠΑΡΑΓΓΕΛΙΑΣ"> <input type="Reset" value="ΚΑΘΑΡΙΣΜΟΣ"></p>
		</form>
	</body>
</html>