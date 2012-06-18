package iWeather.zipcode;

import iWeatherSQL.SQLConnection;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.MatchResult;

public class ZipcodeProcess {
	
	public ZipcodeProcess(){
		extractZipcode();
	}

	private void extractZipcode(){
		try{
			Scanner zipcode = new Scanner(new File("src/initial_zipcode.txt"));
			for(int i = 0; i < 499; i++){
				zipcode.findInLine(",(\\d+),(\\w+),(\\D+),");
				MatchResult result = zipcode.match();
				String query = "Insert into ZIPCODE values('" + result.group(1) + "','" + 
								result.group(2) + "','" + result.group(3) + "');";
				//String query = "Insert into WEATHER(zipcode) values('" + result.group(1) + "');";
				//System.out.println(query);
		
				SQLConnection sql = new SQLConnection();
				sql.SqlInsert(query);
				sql.SqlClose();
				zipcode.nextLine();
			}
			zipcode.close();
		}
		catch(IOException ex){System.err.println(ex.getMessage());}
	}
	/**
	 * @param args
	 */
	/*
	public static void main(String[] args) {
		ZipcodeProcess test = new ZipcodeProcess();

	}
*/
}
