import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class order extends HttpServlet{
	Connection con;
	private String message;

	public void init(ServletConfig config)
		throws ServletException {
			super.init(config);
				try {
					Class.forName("org.gjt.mm.mysql.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost/eshop?user=root&password=mariazia32524");
				} catch (Exception e) {
					message=e.getMessage();
				}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			
			String cost = request.getParameter("cost");
			String addr=request.getParameter("ADDRESS");
			String d=request.getParameter("DATE");
			String t=request.getParameter("TIME");
			if (con!=null){
				try {
					Statement stmt = con.createStatement();
					HttpSession session=request.getSession();
					String usName=(String) session.getAttribute("login.isDone");
					String sessionId = request.getSession().getId();
					
					String orID = null;
					ResultSet rs=stmt.executeQuery("SELECT max(id) FROM orders");
					while(rs.next()) { //epomeni egrafi
						int id=rs.getInt(1);
						orID = id+1+"";
					}
					
					int updateCount=stmt.executeUpdate("INSERT INTO orders VALUES("+orID+",'"+usName+"',"+cost+",'"+addr+"','"+d+"','"+t+"','"+sessionId+"');");
					if (updateCount !=0) {
						out.println("<HTML><HEAD><TITLE>SUCCESSFUL/UNSUCCESSFUL ORDER</TITLE>" +
							"<style type=text/css>"+
							" body {background-color: #4CAF50}"+
							"h1 {background-color: #FCE047}"+
							" h1 {color: #000000}"+
							" h1 {text-align: center}"+
							"div {color: #000000}"+
							"tr {text-align: left}"+
							" input {align: right}"+
							" div {text-align: center}"+
							" </style></HEAD>");
						out.println("<body>");
						out.println("<h1>DB Update</h1><br>");
						out.println("<p align=center> Order Details:</p><center><b>");
						rs=stmt.executeQuery("SELECT * FROM orders WHERE username='"+usName+"' and sessionId='"+sessionId+"';");
						while(rs.next()) { 
							String line=rs.getInt(1)+","+rs.getString(2)+","+rs.getFloat(3)+","+rs.getString(4)+","+rs.getString(5)+","+rs.getString(6);
							out.println(line+"<br></center></b>");
							out.println("<p align=centerTthe order was successfully placed.</p>");
						}
						//clearing the cart
						Hashtable cart_items =(Hashtable)request.getSession().getAttribute("cart_list");
						cart_items.clear();
					} else {
						out.println("<p align=center>Your order could not be registered</p> <br>");
					}
					out.println("<a href='ProductCatalog.jsp'>"+"<p align=center>New Order</p></a>");
					out.println("<br>");
					out.println("<a href='arxikh_sel.jsp'>"+"<p align=center>Home Page</p></a>");
					out.println("<br>");
					out.println("<a href='login.html?logout=true'>"+"<p align=center>LOGOUT</p></a>");
					out.println("<hr><p align=center>© 2021 Zianou, All Rights Reserved</p>");
					out.println("</body></html>");
				} catch(SQLException e) {
					log("SQL exception" , e );
				}
			} else {
				out.println("could't connect to DB eshop");
			}
	}
}
	