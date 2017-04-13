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
 * Servlet implementation class AddMovie
 */
@WebServlet("/AddMovie")
public class AddMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMovie() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    protected boolean AddMovie(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
    	
    	Class.forName("org.sqlite.JDBC");
    	
	    Connection connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/amars/OneDrive/Documents/CSE 111/Theater.db");
    	
	    String m_name = request.getParameter("m_name");
	    String m_releaseDate = request.getParameter("m_releaseDate");
	    String a_name = request.getParameter("a_name");
	    String a_gender = request.getParameter("a_gender");
	    String a_birthday = request.getParameter("a_birthday");
	    
	    String command = "SELECT count(*) checkMovie FROM movie WHERE m_name = ? AND m_releaseDate = ?;";
	    PreparedStatement ps = connection.prepareStatement(command);
	    ps.setString(1, m_name);
	    ps.setString(2, m_releaseDate);
	    
	    ResultSet rs = ps.executeQuery();
	    int checkMovie = rs.getInt("checkMovie");
	    
	    if (checkMovie != 0) {
	    	
	    	connection.close();
	    	return false;
	    	
	    }
	    
	    
	    command = "SELECT a_actorID FROM actor WHERE a_name = ? AND a_gender = ? AND a_dateOfBirth = ?;";
	    
	    ps = connection.prepareStatement(command);
	    ps.setString(1, a_name);
	    ps.setString(2, a_gender);
	    ps.setString(3, a_birthday);
	    
	    rs = ps.executeQuery();
	    int a_actorID;
	    
	    if (rs.next()) {
	    	
	    	a_actorID = rs.getInt("a_actorID");
	    	
	    }
	    
	    else {
	    	
	    	command = "SELECT max(a_actorID) as maxID FROM actor";
	    	ps = connection.prepareStatement(command);
	    	rs = ps.executeQuery();
	    	a_actorID = rs.getInt("maxID");
	    	a_actorID++;
	    	
	    	command = "INSERT INTO actor (a_actorID, a_name, a_gender, a_dateOfBirth) "
	    			+ "VALUES(?, ?, ?, ?);";
	    	ps = connection.prepareStatement(command);
	    	ps.setInt(1, a_actorID);
	    	ps.setString(2, a_name);
	    	ps.setString(3, a_gender);
	    	ps.setString(4, a_birthday);
	    	ps.executeUpdate();
	    	
	    }
	    
	    command = "SELECT max(m_movieID) as maxID FROM movie";
	    ps = connection.prepareStatement(command);
	    rs = ps.executeQuery();
	    int m_movieID = rs.getInt("maxID");
	    m_movieID++;
	    
	    command = "INSERT INTO movie (m_movieID, m_actorID, m_name, m_releaseDate) "
	    		+ "VALUES(?, ?, ?, ?);";
	    ps = connection.prepareStatement(command);
	    ps.setInt(1, m_movieID);
	    ps.setInt(2, a_actorID);
	    ps.setString(3, m_name);
	    ps.setString(4, m_releaseDate);
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
			check = AddMovie(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(check) {
			
			System.out.println("Going to Print Add Movie");
			
			RequestDispatcher view = request.getRequestDispatcher("printAddMovie.jsp");
			view.forward(request, response);
			
		}
		
		else {
			
			System.out.println("Going to Main Menu (Movie already exists or Information not found)");
			
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
