package com.mak;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter printWriter=response.getWriter();

		String name = request.getParameter("Ename");
		double salary = Double.parseDouble(request.getParameter("salary"));
		char grade = request.getParameter("grade").charAt(0);
		double bonus=0;
		if(salary>100000 && grade=='A')
			bonus=salary*0.05;
		else if(salary>=50000 && salary<=100000  && grade=='B')
			bonus=salary*0.07;
		else if(salary<50000  && grade=='C')
			bonus=salary*0.2;
		double tax = salary*0.25;
		printWriter.println("<table><tr>");
		printWriter.println("<td>Employee Name:</td><td>"+name);
		printWriter.println("</td></tr><tr><td>Basic Salary:</td><td>"+salary);
		printWriter.println("</td></tr><tr><td>Bonus:</td><td>"+bonus);
		printWriter.println("</td></tr><tr><td>Tax:</td><td>"+tax);
		printWriter.println("</td></tr><tr><td>Net Salary:</td><td>"+(salary+bonus-tax)+"</td></tr>");
		printWriter.println("</table>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
