package com.tutorial.simpleservletform;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.util.ArrayList;

/**
 * Servlet implementation class EmployeeMenu
 */
@WebServlet("/EmployeeMenu")
public class EmployeeMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeMenu() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    protected void getProfits(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
    	
    	Class.forName("org.sqlite.JDBC");
    	
	    Connection connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/amars/OneDrive/Documents/CSE 111/Theater.db");
    	
	    String command = "SELECT m_name, sum(t_price) AS profit "
	    		+ "FROM tickets, movie "
	    		+ "WHERE t_movieID = m_movieID GROUP BY t_movieID;";
	    
	    PreparedStatement ps = connection.prepareStatement(command);
	    
	    ResultSet rs = ps.executeQuery();
	    
	    ArrayList<String> profitsInfo = new ArrayList<String>();
	    
	    while(rs.next()) {
	    	
	    	profitsInfo.add(rs.getString("m_name"));
	    	profitsInfo.add(rs.getString("profit"));
	    	
	    }
	    
	    command = "SELECT sum(t_price) AS total FROM tickets";
	    ps = connection.prepareStatement(command);
	    rs = ps.executeQuery();
	    
	    String total = rs.getString("total");
	    
	    connection.close();
	    
	    profitsInfo.add("Total");
	    profitsInfo.add(total);
    	
	    request.setAttribute("profitsInfo", profitsInfo);
	    
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Selection = request.getParameter("Selection");
		
		if (Selection.equals("View Total Profits")) {
			
			System.out.println("Going to View Total Profits");
			
			try {
				getProfits(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			RequestDispatcher view = request.getRequestDispatcher("Profits.jsp");
			view.forward(request, response);
			
		}
		
		else if (Selection.equals("Add A New Showtime")) {
			
			System.out.println("Going to Add New Showtime");
			
			RequestDispatcher view = request.getRequestDispatcher("AddShowtime.jsp");
			view.forward(request, response);
			
		}
		
		else if (Selection.equals("Add A New Movie")) {
			
			System.out.println("Going to Add New Movie");
			
			RequestDispatcher view = request.getRequestDispatcher("AddMovie.jsp");
			view.forward(request, response);
			
		}
		
		else if (Selection.equals("Back To Main Menu")) {
			
			System.out.println("Going to Back To Main Menu");
			
			RequestDispatcher view = request.getRequestDispatcher("index.jsp");
			view.forward(request, response);
			
		}
		
		else if (Selection.equals("Go Back")) {
			
			System.out.println("Going to Back To Employee Menu");
			
			RequestDispatcher view = request.getRequestDispatcher("EmployeeMenu.jsp");
			view.forward(request, response);
			
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
