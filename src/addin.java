import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/addin")
public class addin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public addin() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		PrintWriter out= response.getWriter();
		String pn = request.getParameter("pan");
		String p = request.getParameter("pwd");
		String e = request.getParameter("eml");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/taxsystem", "Achala", "PassworD1@34");
			PreparedStatement stmt = con.prepareStatement("INSERT INTO taxsystem.newlog values(?,?,?)");
			stmt.setString(1,pn); 
			stmt.setString(2,e);
			stmt.setString(3,p);
			int rs = stmt.executeUpdate();
			if (rs>0) {
				response.sendRedirect("wait.jsp");
			} else {
				out.println("something went wrong");
			}
		} catch (Exception E) {
			E.printStackTrace();
		}
	}

}
