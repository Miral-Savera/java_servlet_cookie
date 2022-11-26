package Crud;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Servlet implementation class EditServelt
 */
public class EditServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServelt() {
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

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql:///MCADB","root","");
			Statement st = con.createStatement();
			String sql = "SELECT * FROM StudentInfo WHERE roll_no="+roll_no;
			ResultSet rs = st.executeQuery(sql);
			
			if(rs!=null) {
				rs.next();
				out.print("<form action='UpdateServlet'>");
				out.println("<input type='hidden' name='roll_no' value='"+rs.getInt(1)+"'>");
				out.println("<table>\r\n"
						+ "	<caption><b>Student Form</b></caption>"
						+ "	<tr>"
						+ "		<td>Student Name : </td>"
						+ "		<td><input type='text' name='name' value='"+rs.getString(2)+"'></td>"
						+ "	</tr>"
						+ "	<tr>"
						+ "		<td>Student Age : </td>"
						+ "		<td><input type='text' name='age' value='"+rs.getString(3)+"'></td>"
						+ "	</tr>"
						+ "	<tr>"
						+ "		<td>Student City : </td>"
						+ "		<td><input type='text' name='city' value='"+rs.getString(4)+"'></td>"
						+ "	</tr>"
						+ "	<tr>"
						+ "		<td colspan='2'><input type='submit'></td>"
						+ "	</tr>"
						+ "	</table>");
				out.print("<form>");
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
