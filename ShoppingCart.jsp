<html>
	<head>
	<meta charset="utf-8">
	<title>Shopping Cart</title>
	<link rel="stylesheet" href="ShoppingCart.css">
	<jsp:useBean id="cart" scope="session" class="eshop.ShoppingCart" />
	</head>
	<body>
		<div class="header">
			<h1>The baby's shop</h1>
			<h2>All you need for your baby.</h2>
		</div>
		<br></br>
		<form>
			<input type="hidden" id="wichRow" name="wichRow" />
			<table width="300" border="1" cellspacing="0"
				cellpadding="2" border="0">
				<h1>Περιεχόμενα Καλαθιού</h1>
				<tr>
					<th align="center" class="style15">ΚΩΔ. ΠΡΟΪΟΝΤΟΣ</th>
					<th align="center" class="style15">ΠΕΡΙΓΡΑΦΗ</th>
					<th align="center" class="style15">ΤΙΜΗ</th>
					<th align="center" class="style15">ΠΟΣΟΤΗΤΑ</th>
					<th align="center" class="style15">ΔΙΑΓΡΑΦΗ</th>
				</tr>
				
				<%
					String row = request.getParameter("wichRow");
					if ( row != null )
					cart.removeItem(row);
					Enumeration e = cart.getEnumeration();
					String[] tmpItem;
					// Iterate over the cart
					int i=0;
					while (e.hasMoreElements()) {
					tmpItem = (String[])e.nextElement();
				%>
				<tr>
					<td align="center"><b><%=tmpItem[0] %></b></td>
					<td align="center"><b><%=tmpItem[1] %></b></td>
					<td align="center"><b><%=tmpItem[2] %> €</b></td>
					<td align="center"><b><%=tmpItem[3] %></b></td>
					<td align="center">
					<input type="button" name="but" value="Delete" onClick="javascript:deleteRow(<%=tmpItem[0]%>); form.submit();"/>
					</td>
				</tr>
				<%i++;}%>
			</table>
			<script>
				function deleteRow(index){
					document.getElementById('wichRow').value=index;
				}
			</script>
			
			<br></br>
			<a align="center"> ΣΥΝΟΛΟ ΠΡΟΪΟΝΤΩΝ: <%=cart.getNumOfItems()%> </a>
			<br></br>
			<a align="center"> ΣΥΝΟΛΙΚΟ ΚΟΣΤΟΣ: <%=cart.getCost()%> €</a> 
			<br></br>
			<p><input type="button" value="ΑΝΤΙΚΑΤΑΒΟΛΗ" name="cash" onClick="javascript:PayCash(this); form.submit();">
			<input type="button" value="ΠΙΣΤΩΤΙΚΗ ΚΑΡΤΑ (PayPal)" name="cart"
				onclick="javascript: PayPal(this); form.submit();"></p>
			<script>
				function PayPal(p){
					window.open('http://www.peypal.com/gr');
				}
				function PayCash(c){
					window.open('paycash.jsp');
				}
			</script>
			<div class="footer">
				<a href="arxikh_sel.html">ΑΡΧΙΚΟ ΜΕΝΟΥ</a>
				<br></br>
				<a href="contact.html">ΕΠΙΚΟΙΝΟΝΙΑ</a>
				<br></br>
				<a href="about.html">ΣΧΕΤΙΚΑ ΜΕ ΕΜΑΣ</a>
				<br></br>
				<a href="loginAdmin.html">ΣΥΝΔΕΣΗ ΔΙΑΧΕΙΡΙΣΤΗ</a>
			</div>
		</form>
	</body>
</html>
		