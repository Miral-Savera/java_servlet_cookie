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
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/**
 * Servlet implementation class DisplayServlet
 */
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayServlet() {
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
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql:///MCADB","root","");
			Statement st = con.createStatement();
			String sql = "SELECT * FROM StudentInfo";
			ResultSet rs = st.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			int col_count = rsmd.getColumnCount()+2;
			
			out.print("<h4><a href='student_form.html'>Add Student</a></h4>");
			
			out.println("<table border='1'>");
			out.print("<tr>");
			for (int i = 2; i <= col_count; i++) {
				if(i==5) {
					out.println("<td>Edit</td>");
				}
				else if(i==6) {
					out.println("<td>Delete</td>");
				}
				else {
					out.println("<td>"+rsmd.getColumnName(i)+"</td>");
				}
			}
			out.print("</tr>");
			while(rs.next()) {
				out.println("<tr>");
				for (int i = 2; i <= col_count; i++) {
					if(i==5) {
						out.println("<td><a href='EditServelt?roll_no="+rs.getInt(1)+"'>Edit</a></td>");
					}
					else if(i==6) {
						out.println("<td><a href='DeleteServlet?roll_no="+rs.getInt(1)+"'>Delete</a></td>");
					}
					else {
						out.println("<td>"+rs.getString(i)+"</td>");
					}
				}
				out.println("</tr>");
			}
			out.println("</table>");
			
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
