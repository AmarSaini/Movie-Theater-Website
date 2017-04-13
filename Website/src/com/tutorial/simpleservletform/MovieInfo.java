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
 * Servlet implementation class MovieInfo
 */
@WebServlet("/MovieInfo")
public class MovieInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void getMovieInfo(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
    	
    	Class.forName("org.sqlite.JDBC");
    	
	    Connection connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/amars/OneDrive/Documents/CSE 111/Theater.db");

	    String movie_name = request.getParameter("Selection");
	    
	    String command = "SELECT m_releaseDate, a_name, a_gender, a_dateOfBirth "
	    		+ "FROM movie, actor "
	    		+ "WHERE m_name = ? AND m_actorID = a_actorID;";
	    
	    PreparedStatement ps = connection.prepareStatement(command);
	    ps.setString(1, movie_name);
	    
	    ResultSet rs = ps.executeQuery();
	    
	    String releaseDate = rs.getString("m_releaseDate");
	    String name = rs.getString("a_name");
	    String gender = rs.getString("a_gender");
	    String dateOfBirth = rs.getString("a_dateOfBirth");
    	
	    connection.close();
	    
	    request.setAttribute("movie_name", movie_name);
	    request.setAttribute("releaseDate", releaseDate);
	    request.setAttribute("name", name);
	    request.setAttribute("gender", gender);
	    request.setAttribute("dateOfBirth", dateOfBirth);
	    
    }
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			getMovieInfo(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Going to Print Movie Info");
		
		RequestDispatcher view = request.getRequestDispatcher("printMovieInfo.jsp");
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
