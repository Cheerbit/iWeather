package rmi.iWeather.server;

import iWeather.zipcode.ZipcodeProcess;
import iWeatherSQL.SQLConnection;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import rmi.iWeather.common.RemoteWeather;
import iWeather.xml.*;

public class RemoteWeatherImpl extends UnicastRemoteObject implements
		RemoteWeather {
	
	public RemoteWeatherImpl() throws RemoteException{
		
	}

	@Override
	public String sayHi(String hi) throws RemoteException {
		System.out.println("Say hi to the damm it RMI.");
		return "Say hi to the damm it RMI." + hi;
	}
	
	@Override
	public String getWeather(String zipcode) throws RemoteException{
		SQLConnection sql = new SQLConnection();
		String query = "SELECT * FROM WEATHER WHERE ZIPCODE = '" + zipcode + "' ORDER BY forecast_date desc limit 1;";
		String result = sql.SqlSelect(query);
		sql.SqlClose();
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			Registry r = LocateRegistry.getRegistry();
			r.rebind("iWeather", new RemoteWeatherImpl());
			System.out.println("===iWeather Server is ready===");
		}catch (Exception e){
			e.printStackTrace();
		}
		
		//Get weather data process;
		//ZipcodeProcess zip = new ZipcodeProcess();
		
		//Get weather
		/*
		SQLConnection sql  = new SQLConnection();
		
		for(int i = 0; i < 499; i++){
			String query   = "SELECT ZIP FROM ZIPCODE LIMIT " + i + ",1";
			String zipcode = sql.SqlSelectZip(query);
			String url     = "http://xml.weather.yahoo.com/forecastrss?p="+ zipcode + "&u=f";
			System.out.println(url);//::test
			WeatherProcess object = new WeatherProcess(url, zipcode);
		}
		
		sql.SqlClose();
		*/
	}
}
