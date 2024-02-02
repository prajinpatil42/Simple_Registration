package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.RegisterDao;
import com.Db.ConnectionProvider;
import com.Entity.Student;


public class RegisterServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String dob = request.getParameter("dob");
			String address = request.getParameter("address");
			String phno = request.getParameter("phno");
			String gender = request.getParameter("gender");
			String password = request.getParameter("password");
			
			
			System.out.println(name+" "+email+" "+dob+" "+address+" "+phno+" "+gender+" "+password);
			
			Student st=new Student();
			
			st.setName(name);
			st.setEmail(email);
			st.setDob(dob);
			st.setAddress(address);
			st.setPhno(phno);
			st.setGender(gender);
			st.setPassword(password);
			
			RegisterDao dao=new RegisterDao(ConnectionProvider.getConnection());
			boolean f=dao.StudentRegister(st);
			
			HttpSession session=request.getSession();
			 
			
			if(f)
			{
				session.setAttribute("Sucessmsg","Registration Sucessfully....!");
				response.sendRedirect("index.jsp");
			}else { 
				
				session.setAttribute("Errormsg","Something went wrong on server....!");
				response.sendRedirect("index.jsp");
			}
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
