

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/addformded")
public class addformded extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public addformded() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		HttpSession session = request.getSession();
		String Pan_no=(String) session.getAttribute("Pan_no");
		PrintWriter out= response.getWriter();
		String  fc= request.getParameter("fc");
		String  fcc= request.getParameter("fcc");
		String  fccd= request.getParameter("fccd");
		String  fd= request.getParameter("fd");
		String  fdd= request.getParameter("fdd");
		String  fddb= request.getParameter("fddb");
		String  fe= request.getParameter("fe");
		String  fee= request.getParameter("fee");
		String  fg= request.getParameter("fg");
		String  fgg= request.getParameter("fgg");
		String  fgga= request.getParameter("fgga");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/taxsystem", "Achala", "PassworD1@34");
			PreparedStatement stmt = con.prepareStatement("INSERT INTO taxsystem.formded (Pan_no,F80c,F80cc,F80ccd,F80d,F80dd,F80ddb,F80e,F80ee,F80g,F80gg,F80gga) values(?,?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1,Pan_no);
			stmt.setString(2,fc);
			stmt.setString(3,fcc);
			stmt.setString(4,fccd);
			stmt.setString(5,fd);
			stmt.setString(6,fdd);
			stmt.setString(7,fddb);
			stmt.setString(8,fe);
			stmt.setString(9,fee);
			stmt.setString(10,fg);
			stmt.setString(11,fgg);
			stmt.setString(12,fgga);
			int rs = stmt.executeUpdate();
			String query= "{call calculateform(?)}";
			CallableStatement cstmt= con.prepareCall(query);
			cstmt.setString(1,Pan_no);
			cstmt.execute();
			if (rs>0) {
				response.sendRedirect("Final.jsp");
			} else {
				out.println("something went wrong");
			}
		} catch (Exception E) {
			E.printStackTrace();
		
			
	}

	}
}
