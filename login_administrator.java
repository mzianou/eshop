import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class login_administrator extends HttpServlet{
	public String cosid;
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

	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out=response.getWriter();
		String name= request.getParameter("aname");
		String password =request.getParameter("apassword");
		if(allowUser(name,password,request)==false){
			out.println("<HTML><HEAD><TITLE>Wrong Password!</TITLE>" +
				"<style type=text/css>"+
				" body { background-color: #4CAF50 }"+
				"h1 {background-color: #FCE047}"+
				" h1 {color: #000000}"+
				" h1 {text-align: center}"+
				"div {color: #000000}"+
				"tr {text-align: left}"+
				" input {align: right}"+
				" div {text-align: center}"+
				" </style></HEAD>");
			out.println("<body>");
			out.println("<h1>Username and Password are Wrong!!!</h1><br>");
			out.println("<p align=center>Try again!</p><center><a href=\"loginAdmin.html\"><br> <b>Here</b> </a></center><br>");
			out.println("<hr><p align=center>© 2021 Zianou, All Rights Reserved</p>");
			out.println("</body></html>");
		} else{ 
			HttpSession session=request.getSession();
			session.setAttribute("loginadmin.isDone",name);
			String target=(String) session.getAttribute("Admin_home.target"); 
			if(target!=null) {
				response.sendRedirect(target);
				return;
			}
			response.sendRedirect("Admin_home.html");
		}
	}
	protected boolean allowUser(String user,String password, HttpServletRequest request){
		try {
			HttpSession session=request.getSession();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(
				"SELECT costumer_id " +
				"FROM costumers " +
				"WHERE (username = '" + user + "') " +
				"AND (password = '" + password + "')");
			while (rs.next()) {
				if (rs.getString("costumer_id")!=null){
					cosid = rs.getString("costumer_id");
					session.setAttribute("curUser",cosid);
					return true ;
				}
			}
		}catch (SQLException e) {
			log("SQL Exception", e);	
			System.out.println("SQL Error");
		}
		return false;
	}
	
}