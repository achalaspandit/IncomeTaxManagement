

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/addindet")
public class addindet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public addindet() {
        super();
        
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		HttpSession session = request.getSession();
		String Pan_no=(String) session.getAttribute("Pan_no");
		String uname = request.getParameter("uname");
		String Fathername = request.getParameter("Fathername");
		String dob = request.getParameter("dob");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/taxsystem", "Achala", "PassworD1@34");
			PreparedStatement stmt = con.prepareStatement("INSERT INTO taxsystem.indet (Pan_no,uname,Fathername,dob) values(?,?,?,?)");
			stmt.setString(1,Pan_no);
			stmt.setString(2,uname);
			stmt.setString(3,Fathername);
			stmt.setString(4,dob);
			int rs = stmt.executeUpdate();
			if (rs>0) {
				response.sendRedirect("IncomeDetails.jsp");
			}
		} catch (Exception E) {
			E.printStackTrace();
		
			}
	}
}
	


