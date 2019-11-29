

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/addindinc1")
public class addindinc1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public addindinc1() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		HttpSession session = request.getSession();
		String Pan_no=(String) session.getAttribute("Pan_no");
		String Salary = request.getParameter("Salary");
		String Ptax = request.getParameter("Ptax");
		String Property = request.getParameter("Property");
		String Mtax = request.getParameter("Mtax");
		String FdInc = request.getParameter("FdInc");
		String Sbinc = request.getParameter("Sbinc");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/taxsystem", "Achala", "PassworD1@34");
			PreparedStatement stmt = con.prepareStatement("INSERT INTO taxsystem.indinc (Pan_no,Salary,Ptax,Property,Mtax,FdInc,Sbinc) values(?,?,?,?,?,?,?)");
			stmt.setString(1,Pan_no);
			stmt.setString(2,Salary);
			stmt.setString(3,Ptax);
			stmt.setString(4,Property);
			stmt.setString(5,Mtax);
			stmt.setString(6,FdInc);
			stmt.setString(7,Sbinc);
			int rs = stmt.executeUpdate();
			String query= "{call calculateinc(?)}";
			CallableStatement cstmt= con.prepareCall(query);
			cstmt.setString(1,Pan_no);
			cstmt.execute();
			if (rs>0) {
				response.sendRedirect("forms.jsp");
			}
		} catch (Exception E) {
			E.printStackTrace();
		
			}
	
	}

}
