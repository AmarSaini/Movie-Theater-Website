package com.tutorial.simpleservletform;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;

/**
 * Servlet implementation class CustomerMenu
 */
@WebServlet("/CustomerMenu")
public class CustomerMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerMenu() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void getShowtimes(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
    	
    	Class.forName("org.sqlite.JDBC");
    	
	    Connection connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/amars/OneDrive/Documents/CSE 111/Theater.db");
    	
	    String command = "SELECT m_name, s_startDate, s_startTime, s_duration, sr_format, "
	    		+ "sr_capacity - sum(t_quantity) AS openSeats, s_showID "
	    		+ "FROM tickets, movie, show, showroom "
	    		+ "WHERE t_showID = s_showID AND m_movieID = s_movieID AND s_roomID = sr_roomID "
	    		+ "GROUP BY s_showID "
	    		+ "ORDER BY m_name;";
	    
	    PreparedStatement ps = connection.prepareStatement(command);
	    
	    ResultSet rs = ps.executeQuery();
	    
	    ArrayList<String> showtimesInfo = new ArrayList<String>();
	    
	    while(rs.next()) {
	    	
	    	showtimesInfo.add(rs.getString("m_name"));
	    	showtimesInfo.add(rs.getString("s_startDate"));
	    	showtimesInfo.add(rs.getString("s_startTime"));
	    	showtimesInfo.add(rs.getString("s_duration"));
	    	showtimesInfo.add(rs.getString("sr_format"));
	    	showtimesInfo.add(rs.getString("openSeats"));
	    	showtimesInfo.add(rs.getString("s_showID"));
	    	
	    }
	    
	    connection.close();
	    
	    request.setAttribute("showtimesInfo", showtimesInfo);
	    
    }
    
    protected void getMovies(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
    	
    	Class.forName("org.sqlite.JDBC");
    	
	    Connection connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/amars/OneDrive/Documents/CSE 111/Theater.db");
    	
	    String command = "SELECT DISTINCT m_name FROM movie;";
	    
	    PreparedStatement ps = connection.prepareStatement(command);
	    
	    ResultSet rs = ps.executeQuery();
	    
	    ArrayList<String> movies = new ArrayList<String>();
	    
	    while(rs.next()) {
	    	
	    	movies.add(rs.getString("m_name"));
	    	
	    }
	    
	    connection.close();
	    
	    request.setAttribute("movies", movies);
	    
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Selection = request.getParameter("Selection");
		
		if(Selection.equals("View Your Current Tickets")) {
			
			System.out.println("Going to View Current Tickets");
			
			RequestDispatcher view = request.getRequestDispatcher("CurrentTickets.jsp");
			view.forward(request, response);
			
		}
		
		else if(Selection.equals("View Showtimes/Buy A Ticket")) {
			
			System.out.println("Going to View Showtimes");
			
			try {
				getShowtimes(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			RequestDispatcher view = request.getRequestDispatcher("Showtimes.jsp");
			view.forward(request, response);
			
		}
		
		else if(Selection.equals("View A Movie's Information")) {
			
			System.out.println("Going to View Movie Info");
			
			try {
				getMovies(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
			RequestDispatcher view = request.getRequestDispatcher("MovieInfo.jsp");
			view.forward(request, response);
			
		}
		
		else if(Selection.equals("Back To Main Menu")) {
			
			System.out.println("Going Back To Main Menu");
			
			RequestDispatcher view = request.getRequestDispatcher("index.jsp");
			view.forward(request, response);
			
		}
		
		else if(Selection.equals("Go Back")) {
			
			System.out.println("Going Back To Customer Menu");
			
			RequestDispatcher view = request.getRequestDispatcher("CustomerMenu.jsp");
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
