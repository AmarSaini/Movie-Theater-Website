package com.tutorial.simpleservletform;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
 * Servlet implementation class BuyTicket
 */
@WebServlet("/BuyTicket")
public class BuyTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static int showID = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyTicket() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected boolean buyTicket(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
    	
    	Class.forName("org.sqlite.JDBC");
    	
	    Connection connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/amars/OneDrive/Documents/CSE 111/Theater.db");
	    
	    String name = request.getParameter("name");
	    String gender = request.getParameter("gender");
	    int age = Integer.parseInt(request.getParameter("age"));
	    int quantity = Integer.parseInt(request.getParameter("quantity"));
	    
	    String command = "SELECT max(t_ticketID) as maxID FROM tickets";
	    
	    PreparedStatement ps = connection.prepareStatement(command);
	    
	    ResultSet rs = ps.executeQuery();
	    
	    int maxID = rs.getInt("maxID");
	    maxID++;
	    
	    
	    command = "SELECT sr_capacity - sum(t_quantity) AS openSeats "
	    		+ "FROM tickets, show, showroom "
	    		+ "WHERE s_showID = ? AND t_showID = s_showID AND s_roomID = sr_roomID;";
	    
	    ps = connection.prepareStatement(command);
	    ps.setInt(1, showID);
	    rs = ps.executeQuery();
	    
	    int openSeats = rs.getInt("openSeats");
	    
	    if (quantity > openSeats) {
	    	
	    	connection.close();
	    	return false;
	    	
	    }
	    
	    command = "INSERT INTO customer (c_ticketID, c_name, c_gender, c_age) "
    			+ "VALUES (?, ?, ?, ?);";
    	
    	ps = connection.prepareStatement(command);
    	ps.setInt(1, maxID);
    	ps.setString(2, name);
	    ps.setString(3, gender);
	    ps.setInt(4, age);
	    
	    ps.executeUpdate();
	    
	    command = "SELECT s_movieID, sr_format "
	    		+ "FROM show, showroom "
	    		+ "WHERE s_showID = ? AND s_roomID = sr_roomID;";
	    
	    ps = connection.prepareStatement(command);
	    ps.setInt(1, showID);
	    
	    rs = ps.executeQuery();
	    
	    int movieID = rs.getInt("s_movieID");
	    String sr_format = rs.getString("sr_format");
	    int price = 0;
	    
	    if (sr_format.equals("Normal")) {
	    	price = 15*quantity;
	    }
	    else if (sr_format.equals("3D")) {
	    	price = 20*quantity;
	    }
	    if (sr_format.equals("IMAX")) {
	    	price = 25*quantity;
	    }
	    
	    command = "INSERT INTO tickets (t_ticketID, t_employeeID, t_showID, t_movieID, t_price, t_quantity) "
	    		+ "VALUES (?, 5, ?, ?, ?, ?)";
	    
	    ps = connection.prepareStatement(command);
	    ps.setInt(1, maxID);
	    ps.setInt(2, showID);
	    ps.setInt(3, movieID);
	    ps.setInt(4, price);
	    ps.setInt(5, quantity);
	    
	    ps.executeUpdate();
	    
	    command = "SELECT m_name FROM movie WHERE m_movieID = ?";
	    ps = connection.prepareStatement(command);
	    ps.setInt(1, movieID);
	    rs = ps.executeQuery();
	    
	    String m_name = rs.getString("m_name");
	    
	    command = "SELECT s_roomID, s_startDate, s_startTime, s_duration, sr_format "
	    		+ "FROM show, showroom "
	    		+ "WHERE s_showID = ? AND s_roomID = sr_roomID";
	    
	    ps = connection.prepareStatement(command);
	    ps.setInt(1, showID);
	    rs = ps.executeQuery();
	    String roomID = rs.getString("s_roomID");
	    String startDate = rs.getString("s_startDate");
	    String startTime = rs.getString("s_startTime");
	    String duration = rs.getString("s_duration");
	    String format = rs.getString("sr_format");
	    
	    connection.close();
	    
	    ArrayList<String> buyTicketInfo = new ArrayList<String>();
	    
	    buyTicketInfo.add(m_name);
	    buyTicketInfo.add(Integer.toString(quantity));
	    buyTicketInfo.add(Integer.toString(price));
	    buyTicketInfo.add(roomID);
	    buyTicketInfo.add(startDate);
	    buyTicketInfo.add(startTime);
	    buyTicketInfo.add(duration);
	    buyTicketInfo.add(format);

	    request.setAttribute("buyTicketInfo", buyTicketInfo);
	    
	    return true;
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Selection = request.getParameter("Selection");
		
		if (Selection.contains("Buy")) {
			
			int temp = Selection.indexOf('#');
			Selection = Selection.substring(temp + 1, Selection.length());
			
			showID = Integer.parseInt(Selection);
			
			System.out.println("Going to Buy Ticket");
			
			RequestDispatcher view = request.getRequestDispatcher("BuyTicket.jsp");
			view.forward(request, response);
			
		}
		
		else {
			
			boolean check = false;
			
			try {
				check = buyTicket(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(check) {
				
				System.out.println("Going to Print Receipt");
				
				RequestDispatcher view = request.getRequestDispatcher("printBuyTicket.jsp");
				view.forward(request, response);
				
			}
			
			else {
				
				System.out.println("Going to Main Menu (User tried to buy an invalid amount of tickets)");
				
				RequestDispatcher view = request.getRequestDispatcher("index.jsp");
				view.forward(request, response);
				
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
