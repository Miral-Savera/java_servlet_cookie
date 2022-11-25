package com.glsu.a77;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class SetCookieServlet
 */
public class SetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetCookieServlet() {
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
		
		String bg_color = request.getParameter("bg_color");
		String text_color = request.getParameter("text_color");
		
		String bold = "false";
		if(request.getParameter("bold")!=null) {
			 bold = "true";
		}
		
		String italic = "false";
		if(request.getParameter("italic")!=null) {
			italic = "true";
		}

		Cookie bg_cookie = new Cookie("bg_color",bg_color);
		response.addCookie(bg_cookie);
		
		Cookie text_cookie = new Cookie("text_color",text_color);
		response.addCookie(text_cookie);
		
		Cookie bold_cookie = new Cookie("bold",bold);
		response.addCookie(bold_cookie);
		
		Cookie italic_cookie = new Cookie("italic",italic);
		response.addCookie(italic_cookie);
		
		response.sendRedirect("GetCookieServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
