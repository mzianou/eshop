import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class signin_costumer extends HttpServlet{
	public int cosID;
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
		String cosname=request.getParameter("username");
		String pas1=request.getParameter("password");
		String fname=request.getParameter("fullname");
		String mail=request.getParameter("email");
		String addre=request.getParameter("address");
		if(con!=null) {
			try{
				Statement stmt=con.createStatement();
				int updateCount=stmt.executeUpdate("INSERT INTO costumers VALUES("+cosID+",'"+cosname+"','"+pas1+"','"+fname+"','"+mail+"','"+addre+"');");
				if (updateCount !=0) {
					out.println("<HTML><HEAD><TITLE>SUCCESSFUL/UNSUCCESSFUL SIGNUP</TITLE>" +
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
					out.println("<h1>DB Update!!!</h1><br>");
					out.println("<p align=center>User Information:</p><center><b>");
					ResultSet rs=stmt.executeQuery("SELECT * FROM costumers WHERE username='"+cosname+"';");
					while(rs.next()) {
						String line=rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4)+","+rs.getString(5)+","+rs.getString(6);
						out.println(line+"<br></center></b>");
						out.println("<p align=center>Successful user registration!</p>");
					}
				} else {
					out.println("<h1>Database update failure</h1>");
				}
				out.println("<a align=center href='signup.html'>"+"New Signup</a>");
				out.println("<br>");
				out.println("<a align=center href='login.html'>"+"<b><i>Home Page</b></i></a><br>");
				out.println("<hr><p align=center>© 2021 Zianou, All Rights Reserved</p>");
				out.println("</body></html>");
			} catch(SQLException e) {
				log("SQL exception" , e );}
		} else {
			out.println("could't connect to DB eshop");
		}
	}
}