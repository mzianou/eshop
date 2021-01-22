import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class del_admin extends HttpServlet{
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
			int delpr=Integer.parseInt(request.getParameter("delID"));
			if (con!=null){
				try {
					Statement stmt = con.createStatement();
					int updateCount=stmt.executeUpdate("DELETE FROM product WHERE product_id='"+delpr+"';");
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
						out.println("<h1>DB UPDATE!!!</h1><br>");
						out.println("<p align=center>Product deleted</p>");
					} else {
						out.println("Delete Failed<br>");
					}
					out.println("<a href='Admin_home.jsp'>"+"<p align=center>New Delete</p></a>");
					out.println("<br>");
					out.println("<a align=center href='login.html'>"+"<p align=center> LOGOUT</p></a>");
					out.println("<hr><p align=center>© 2021 Zianou, All Rights Reserved</p>");
					out.println("</body></html>");
				} catch(SQLException ex) {
					log("SQL exertion", ex);
				}
			}
			else
				out.println("I can't conect to DB eshop in MySQL");
			}
		}
		