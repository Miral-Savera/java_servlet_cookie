package Crud;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		int roll_no = Integer.parseInt(request.getParameter("roll_no"));
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String city = request.getParameter("city");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql:///MCADB","root","");
			Statement st = con.createStatement();
			String sql = "UPDATE StudentInfo SET name='"+name+"',age='"+age+"',city='"+city+"' WHERE roll_no="+roll_no;
			int r = st.executeUpdate(sql);
			
			if(r!=0) {
				response.sendRedirect("DisplayServlet");
			}
			else {
				out.println("Problem to Update Student");
				RequestDispatcher rd = request.getRequestDispatcher("DisplayServlet");
				rd.include(request, response);
			}
		}
		catch(Exception e) {
			out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
