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
 * Servlet implementation class CurrentTickets
 */
@WebServlet("/CurrentTickets")
public class CurrentTickets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CurrentTickets() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void getCurrentTickets(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
    	
    	Class.forName("org.sqlite.JDBC");
    	
	    Connection connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/amars/OneDrive/Documents/CSE 111/Theater.db");
	    
    	String name = request.getParameter("name");
    	
    	String command = "SELECT m_name, t_quantity, s_startDate, s_startTime, s_duration, sr_roomID, sr_format "
    			+ "FROM customer, tickets, movie, show, showroom WHERE c_name = ? AND "
    			+ "c_ticketID = t_ticketID AND t_movieID = m_movieID AND t_showID = s_showID AND "
    			+ "s_roomID = sr_roomID;";
    	
    	PreparedStatement ps = connection.prepareStatement(command);
    	ps.setString(1, name);
    	
    	ResultSet rs = ps.executeQuery();
    	
    	ArrayList<String> ticketInfo = new ArrayList<String>();
    	
    	while(rs.next()) {
    		
    		ticketInfo.add(rs.getString("m_name"));
    		ticketInfo.add(rs.getString("t_quantity"));
    		ticketInfo.add(rs.getString("s_startDate"));
    		ticketInfo.add(rs.getString("s_startTime"));
    		ticketInfo.add(rs.getString("s_duration"));
    		ticketInfo.add(rs.getString("sr_roomID"));
    		ticketInfo.add(rs.getString("sr_format"));
    		
    	}
	    
    	connection.close();
    	
    	request.setAttribute("ticketInfo", ticketInfo);
    	
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			getCurrentTickets(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Going to Print Current Tickets");
		
		RequestDispatcher view = request.getRequestDispatcher("printCurrentTickets.jsp");
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
