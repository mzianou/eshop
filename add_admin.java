import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

public class add_admin extends HttpServlet{
	public int cosID;
	public int pid;

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
		String pde=request.getParameter("prde");
		float pp=Float.parseFloat(request.getParameter("prp"));
		String pkat=request.getParameter("prkat");
		if (con!=null){
			try {
				Statement stmt = con.createStatement();
				int updateCount=stmt.executeUpdate("INSERT INTO product VALUES("+pid+",'"+pde+"',"+pp+",'"+pkat+"');");
				if (updateCount !=0) {
					out.println("<HTML><HEAD><TITLE>SUCCESSFUL/UNSUCCESSFUL INSETION</TITLE>" +
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
					out.println("<h1>DB UPDATE</h1><br>");
					out.println("<p align=center>PRODUCT DETAILS</p>>");
					ResultSet rs=stmt.executeQuery("SELECT * FROM product WHERE description='"+pde+"';");
					while(rs.next()) { //epomeni egrafi
						String line=rs.getInt(1)+","+rs.getString(2)+","+rs.getFloat(3)+","+rs.getString(4);
						out.println(line+"<br>");
						out.println("<p align=center>INSERTION WAS SUCCESSFUL </p>");
					}
				} else {
					out.println("INSERTION UNSUCCESSFUL <br>");
				}
				out.println("<a align=center href='Admin_home.jsp>"+"NEW INSERTION</a>");
				out.println("<br>");
				out.println("<a align=center href='login.html'>"+"<b><i>LOGOUT</i></b></a>");
				out.println("<hr><p align=center>© 2021 Zianou, All Rights Reserved</p>");
				out.println("</body></html>");
			} catch(SQLException ex) {
				log("SQL exception", ex);
			}
		}
		else{
			out.println("I can't connect to DB!");
		}
	}
}