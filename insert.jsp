<html>
	<head>
	<meta charset="utf-8">
	<title>Insert Products</title>
	<link rel="stylesheet" href="insert.css">
	</head>
	<body>
		<form method="post" action="add_admin">
		<div class="header">
			<h1>The baby's shop</h1>
			<h2>All you need for your baby.</h2>
		</div>
		<br></br>
		<table style="width=50%">
			<tr>
				<th>ΠΡΟΣΘΗΚΗ ΠΡΟΪΟΝΤΩΝ</th>
			</tr>
			<td>ΔΩΣΕ ΠΕΡΙΓΡΑΦΗ: <input type="text" name="prde" size=20></td>
			<br></br>
			<td>ΔΩΣΕ ΤΙΜΗ: <input type="text" name="prp" size=10></td>
			<br></br>
			<td>ΔΩΣΕ ΚΑΤΗΓΟΡΙΑ: 
				<select name="prcat">
					<option>Choose</option>
					<option>clothes</option>
					<option>shoes</option>
					<option>babycare</option>
					<option>babythings</option>
					<option>food</option>
				</select>
			</td>
			<br></br>
			<input type="Submit" value="ΠΡΟΣΘΗΚΗ">
		</table>
		<br></br>
		<div class="footer">
			<a href="Admin_home.html">ΑΡΧΙΚΟ ΜΕΝΟΥ</a>
			<br></br>
			<a href="contact.html">ΕΠΙΚΟΙΝΟΝΙΑ</a>
			<br></br>
			<a href="about.html">ΣΧΕΤΙΚΑ ΜΕ ΕΜΑΣ</a>
		</div>
		</form>
	</body>
</html>