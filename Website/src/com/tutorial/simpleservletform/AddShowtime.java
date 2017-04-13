package com.tutorial.simpleservletform;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddShowtime
 */
@WebServlet("/AddShowtime")
public class AddShowtime extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddShowtime() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected boolean AddShowtime(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
    	
    	Class.forName("org.sqlite.JDBC");
    	
	    Connection connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/amars/OneDrive/Documents/CSE 111/Theater.db");
 
	    String m_name = request.getParameter("m_name");
	    int s_roomID = Integer.parseInt(request.getParameter("s_roomID"));
	    String s_startDate = request.getParameter("s_startDate");
	    String s_startTime = request.getParameter("s_startTime");
	    int s_duration = Integer.parseInt(request.getParameter("s_duration"));
	    
	    String command = "SELECT m_movieID FROM movie WHERE m_name = ?;";
	    PreparedStatement ps = connection.prepareStatement(command);
	    ps.setString(1, m_name);
	    ResultSet rs = ps.executeQuery();
	    
	    int s_movieID = 0;
	    
	    if (rs.next()) {
	    	
	    	s_movieID = rs.getInt("m_movieID");
	    	
	    }
	    
	    else {
	    	
	    	connection.close();
	    	return false;
	    	
	    }
	    
	    command = "SELECT s_showID FROM show "
	    		+ "WHERE s_movieID = ? AND s_roomID = ? AND s_startDate = ? "
	    		+ "AND s_startTime = ? AND s_duration = ?;";
	    ps = connection.prepareStatement(command);
	    ps.setInt(1, s_movieID);
	    ps.setInt(2, s_roomID);
	    ps.setString(3, s_startDate);
	    ps.setString(4, s_startTime);
	    ps.setInt(5, s_duration);
	    rs = ps.executeQuery();
	    
	    if (rs.next()) {
	    	
	    	connection.close();
	    	return false;
	    	
	    }
	    
	    command = "SELECT max(s_showID) as maxID FROM show;";
	    ps = connection.prepareStatement(command);
	    rs = ps.executeQuery();
	    int s_showID = rs.getInt("maxID");
	    s_showID++;
	    
	    command = "INSERT INTO show (s_showID, s_roomID, s_movieID, s_startTime, s_startDate, s_duration) "
	    		+ "VALUES(?, ?, ?, ?, ?, ?);";
	    ps = connection.prepareStatement(command);
	    ps.setInt(1, s_showID);
	    ps.setInt(2, s_roomID);
	    ps.setInt(3, s_movieID);
	    ps.setString(4, s_startTime);
	    ps.setString(5, s_startDate);
	    ps.setInt(6, s_duration);
	    ps.executeUpdate();
	    
	    connection.close();
	    
	    request.setAttribute("m_name", m_name);
	    return true;
	    
	    
    }   
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean check = false;
		
		try {
			check = AddShowtime(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(check) {
			
			System.out.println("Going to Print Add Showtime");
			
			RequestDispatcher view = request.getRequestDispatcher("printAddShowtime.jsp");
			view.forward(request, response);
			
		}
		
		else {
			
			System.out.println("Going to Main Menu (Showtime already exists or Information not found)");
			
			RequestDispatcher view = request.getRequestDispatcher("index.jsp");
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
