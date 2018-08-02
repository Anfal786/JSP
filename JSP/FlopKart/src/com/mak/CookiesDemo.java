package com.mak;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.dc.pr.PRError;


/**
 * Servlet implementation class CookiesDemo
 */
@WebServlet("/CookiesDemo")
public class CookiesDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookiesDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @throws IOException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter printWriter= response.getWriter();
		Cookie[] ck =request.getCookies();
		if(ck==null) {
			printWriter.println("<body bgcolor=\"yellow\">");
			Cookie c = new Cookie("location", "bangalore");
//			c.setMaxAge(24*60*60);
			response.addCookie(c);
			printWriter.println("Cookies Stored for One Day");
			printWriter.println("Welcome for Visiting First Time</body>");
		}
		else
		{
			for(Cookie c : ck) {
				printWriter.println("<body bgcolor=\"pink\">");
				printWriter.print("Name: "+c.getName()+" and Value: "+c.getValue()+"<br>");
				if(c.getName().equals("location") && c.getValue().equals("bangalore")){
					printWriter.println("Thanks for Visitng Again</body>");
				}
			}
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
