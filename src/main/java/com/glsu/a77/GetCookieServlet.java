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
 * Servlet implementation class GetCookieServlet
 */
public class GetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCookieServlet() {
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
		
		Cookie[] ck = request.getCookies();
		
		String bg_color = "#FFFFFF";
		String text_color = "#000000";
		String font_weight = "normal";
		String font_style = "normal";
		
		if(ck!=null) {
			if(ck.length > 0 && ck[0].getValue()!=null) {
				bg_color = ck[0].getValue();
			}
			if(ck.length > 1 && ck[1].getValue()!=null) {
				text_color = ck[1].getValue();
			}
			if(ck.length > 2 && ck[2].getValue()!=null) {
				if(ck[2].getValue().equals("true")) {
					font_weight = "bold";
				}
			}
			if(ck.length > 3 && ck[3].getValue()!=null) {
				if(ck[3].getValue().equals("true")) {
					font_style = "italic";
				}
			}
		}
		
		
		out.println("<label style='background-color:"+bg_color+";color:"+text_color+";font-weight:"+font_weight+";font-style:"+font_style+";'>Hello World!!</label>");	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
