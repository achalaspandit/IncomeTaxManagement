

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/checkin")
public class checkin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public checkin() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		String pn = request.getParameter("Pan_no");
		String e = request.getParameter("Email");
		String p = request.getParameter("Pwd");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/taxsystem", "Achala", "PassworD1@34");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT * FROM taxsystem.indlog WHERE Pan_no='"+pn+"' AND Pwd='"+p+"' AND Email='"+e+"' ");
			if (rs.next()) {
				HttpSession session = request.getSession();
				session.setAttribute("Pan_no", pn);
				response.sendRedirect("Indhome.jsp");
			} else {
				response.sendRedirect("errorlog.jsp");
			}
		} catch (Exception E) {
			E.printStackTrace();
		}


	}

}
