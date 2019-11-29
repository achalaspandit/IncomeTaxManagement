
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/checkad")
public class checkad extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public checkad() {
		super();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
		String u = request.getParameter("Uname");
		String p = request.getParameter("Pwd");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/taxsystem", "Achala", "PassworD1@34");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT * FROM taxsystem.adlog WHERE Uname='"+u+"' AND Pwd='"+p+"' ");
			if (rs.next()) {
				HttpSession session = request.getSession();
				session.setAttribute("Uname", u);
				response.sendRedirect("Adhome.jsp");
			} else {
				response.sendRedirect("errorlog.jsp");
			}
		} catch (Exception E) {
			E.printStackTrace();
		}

	}

}
