package iWeather.xml;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class WeatherProcess extends DefaultHandler{
	public WeatherProcess(String xmlUrl, String zipcode){
		try{
			URL input = new URL(xmlUrl);
			URLConnection yc = input.openConnection();
			InputStream in = yc.getInputStream();
			SAXParserFactory factory = SAXParserFactory.newInstance();
			factory.setValidating(false);
			SAXParser sax = factory.newSAXParser();
			
			sax.parse(in, new WeatherXmlHandler(zipcode));
		} catch (ParserConfigurationException pce) {
			System.out.println("Could not create that parser.");
			System.out.println(pce.getMessage());
		} catch (SAXException saxe) {
			System.out.println("Problem with the SAX parser.");
			System.out.println(saxe.getMessage());
		} catch (IOException ioe) {
			System.out.println("Error reading file.");
			System.out.println(ioe.getMessage());
		}
	}
	/*
	public static void main(String[] args){
		WeatherProcess object = new WeatherProcess("http://xml.weather.yahoo.com/forecastrss?p=36586&u=f", "36586");
	}
	*/
}
