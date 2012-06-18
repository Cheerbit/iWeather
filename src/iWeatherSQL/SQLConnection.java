package iWeatherSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConnection {
	
	Connection conn;
	public SQLConnection(){	
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://localhost/IWEATHER";
			conn = DriverManager.getConnection(url, "root", "root");
		}
		catch(ClassNotFoundException ex){System.err.println("1:" + ex.getMessage());}
		catch(IllegalAccessException ex){System.err.println("2:" + ex.getMessage());}
		catch(InstantiationException ex){System.err.println("3:" + ex.getMessage());}
		catch(SQLException ex)          {System.err.println("4:" + ex.getMessage());}
	}
	//Inser function. 
	public void SqlInsert(String query){
		try{
			Statement st = conn.createStatement();
			st.executeUpdate(query);
		}
		catch(SQLException ex){System.err.println("SQLException: " + ex.getMessage());}
	}
	//Update Function
	public void SqlUpdate(String query){
		try{
			Statement st = conn.createStatement();
			st.executeUpdate(query);
		}
		catch(SQLException ex){System.err.println("SQLException: " + ex.getMessage());}
	}
	
	//Select zip function.
	public String SqlSelectZip(String query){
		String result = "";
		try{
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()){
				result += rs.getString("zip"); 
			}
		}
		catch(SQLException ex){System.err.println("SQL: " + ex.getMessage());}
		return result;
	}
	
	public String SqlSelect(String query){
		String result = "";
		try{
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()){
				result += "Zipcode: ";
				result += rs.getString("zipcode");	
				result += "\nCity: ";
				result += rs.getString("location_city");
				result += "\nTemp: ";
				result += rs.getString("condition_temp");
				result += "\nDate: ";
				result += rs.getString("forecast_date");
				result += "\n";
			}
		}
		catch (SQLException ex){System.err.println("SQL: " + ex.getMessage());}
		return result;
	}
	
	//SQL connection close function.
	public void SqlClose(){
		try{
			conn.close();
		}
		catch(SQLException ex){System.err.println("SQLException: " + ex.getMessage());}
	}
	/*
	public static void main(String[] args){
		SQLConnection sql = new SQLConnection();
		System.out.println(sql.SqlSelect("SELECT * FROM WEATHER WHERE ZIPCODE = '60666';"));
		sql.SqlClose();
	}*/
}
