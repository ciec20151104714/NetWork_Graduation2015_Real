package com.qst.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.qst.bean.UserBean;
import com.qst.dao.UserDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");

		UserBean userbean = new UserBean();
		userbean.setUsername(username);
		userbean.setPwd(pwd);
		
		UserDao sd = new UserDao();
		UserBean rs = sd.login(userbean);
		

			if (rs != null) 
				{
				HttpSession session = request.getSession(); 
				session.setAttribute("user",username);
				request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			else
				{
				response.sendRedirect("Login.jsp");
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