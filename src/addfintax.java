

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/addfintax")
public class addfintax extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public addfintax() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		HttpSession session = request.getSession();
		String Pan_no=(String) session.getAttribute("Pan_no");
		String  a= request.getParameter("at");
		String  t= request.getParameter("td");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/taxsystem", "Achala", "PassworD1@34");
			PreparedStatement stmt = con.prepareStatement("INSERT INTO taxsystem.fintax (Pan_no,AdvTax,Tds) values(?,?,?)");
			stmt.setString(1,Pan_no);
			stmt.setString(2,a);
			stmt.setString(3,t);
			stmt.executeUpdate();
			String query= "{call calfinal(?)}";
			CallableStatement cstmt= con.prepareCall(query);
			cstmt.setString(1,Pan_no);
			cstmt.execute();
			PreparedStatement ppstmt = con.prepareStatement("SELECT PayTax FROM taxsystem.fintax WHERE Pan_no=?");
			ppstmt.setString(1,Pan_no);
			ResultSet rss = ppstmt.executeQuery();
			rss.next();
			Integer val= rss.getInt(1);
			session.setAttribute("PayTax",val);
			response.sendRedirect("Display.jsp");
			
		} catch (Exception E) {
			E.printStackTrace();
		
			
	}

	}

}
