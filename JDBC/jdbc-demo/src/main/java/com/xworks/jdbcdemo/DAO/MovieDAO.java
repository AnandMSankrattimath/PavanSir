package com.xworks.jdbcdemo.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MovieDAO { // Data Access Object -- DAO
	String query = "SELECT mv.name FROM movie mv WHERE id=2"; // mv is the aliase name for Movie.
	String query1 = "SELECT * FROM movie";
	
	
	Connection connection = null;
	Statement statement=null;
	ResultSet resultSet=null;
	
	//Get Operations started.
	//1) getNameByMovieId()
	public void getNameByMovieId() {
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","2580");
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);  // resultset has data which is not directly from database but which data came from the cursor.
														// cursor is the temprory memory from mysql.
			
			while(resultSet.next()) {
				String mName= resultSet.getString("name");
				System.out.println("Movie Name : "+mName);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// task use property in getconnection & check transaction cl 
		
		
		
	}
	
	//2) getAllDetails()
	public void getAllDetails() {
		System.out.println("inside getAll()");
		try {
			resultSet = statement.executeQuery(query1);
			
			while(resultSet.next()) {
				//int mid=resultSet.getInt("id");
				String mName= resultSet.getString("name");
				double mrating=resultSet.getDouble("rating");
				String mlang=resultSet.getString("language");
				long mbudget=resultSet.getLong("budget");
				System.out.println("MovieDetails : Movie Name=" + mName + ", Language=" + mlang+ ", Budget = " +mbudget  + ", Rating = " + mrating) ;
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end of  getAll()");

	}
	
	
	//3) getAlldetailsById()
	public void getAllByMovieId(int id) {
		System.out.println("Inside getAllByMovieId()");
		String query2 = "select * from movie where id = "+id;
		try {
			resultSet=statement.executeQuery(query2);
			if(resultSet.next()) {
				System.out.println("record is present");
				System.out.println("MovieDetails : Movie Name=" +resultSet.getString("name") + 
						", Language=" + resultSet.getString("language")+ ","
								+ " Budget = " +resultSet.getLong("budget") + ", "
										+ "Rating = " + resultSet.getDouble("rating")) ;
			}
			else {
				System.out.println("Record not present");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("End of getAllByMovieId()");
	}
		
		//4)getAllDetailsByMovieName()
		public void getAllDetailsByMovieName(String name) {
			System.out.println("Inside getAllDetailsByMovieName()");
			String query3 = "SELECT * FROM movie where name=('" + name + "')";
			try {
				resultSet=statement.executeQuery(query3);
				if(resultSet.next()) {
					System.out.println("record is present");
					System.out.println("MovieDetails : Movie Name=" +resultSet.getString("name") + 
							", Language=" +resultSet.getString("language")+ ","
									+ " Budget = " +resultSet.getLong("budget")  + ", "
											+ "Rating = " + resultSet.getDouble("rating")) ;
				}
				else
				{
					System.out.println("Record is not present");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("End of getAllDetailsByMovieName()");
			
	}
		
		//5)getLaunguageAndBudgetByMovieName
		public void getLaunguageAndBudgetByMovieName(String name) {
			System.out.println("Inside getLaunguageAndBudgetByMovieName()");
			String query4="select language,budget from movie where name=('"+ name +"')";
			
			try {
				resultSet=statement.executeQuery(query4);
				if (resultSet.next()) {
					System.out.println("Record is present");
					System.out.println("Movie Language = "+resultSet.getString("language")+ " Movie Budget = "+resultSet.getLong("budget")+"rs");
				}
				else {
					System.err.println("Record not found");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {// close resources 
				try {
				if (resultSet!=null) 
						resultSet.close();
				if(statement!=null)
					statement.close();
				if (connection!=null) 
					connection.close();
				
				}catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			System.out.println("End of getLaunguageAndBudgetByMovieName()");
			}
		
		}
		

