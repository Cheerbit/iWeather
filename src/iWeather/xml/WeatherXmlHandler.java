package iWeather.xml;

import iWeatherSQL.SQLConnection;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class WeatherXmlHandler extends DefaultHandler{
	WeatherXmlHandler(String zipcode){
		this.zip = zipcode;
	}
	static int READING_LOCATION_CITY    = 1;
	static int READING_LOCATION_REGION  = 2;
	static int READING_LOCATION_COUNTRY = 3;
	
	static int READING_UNIT_TEMPERATURE = 4;
	static int READING_UNIT_DISTANCE    = 5;
	static int READING_UNIT_PRESSURE    = 6;
	static int READING_UNIT_SPEED       = 7;
	
	static int READING_WIND_CHILL       = 8;
	static int READING_WIND_DIRECTION   = 9;
	static int READING_WIND_SPEED       = 10;
	
	static int READING_ATMOSPHERE_HUMIDITY   = 11;
	static int READING_ATMOSPHERE_VISIBILITY = 12;
	static int READING_ATMOSPHERE_PRESSURE   = 13;
	static int READING_ATMOSPHERE_RISING     = 14;
	
	static int READING_ASTRONOMY_SUNRISE     = 15;
	static int READING_ASTRONOMY_SUNSET      = 16;
	
	static int READING_CONDITION_TEXT   = 17;
	static int READING_CONDITION_CODE   = 18;
	static int READING_CONDITION_TEMP   = 19;
	static int READING_CONDITION_DATE   = 20;
	
	static int READING_FORECAST_DAY     = 21;
	static int READING_FORECAST_DATE    = 22;
	static int READING_FORECAST_LOW     = 23;
	static int READING_FORECAST_HIGH    = 24;
	static int READING_FORECAST_TEXT    = 25;
	static int READING_FORECAST_CODE    = 26;
	/*
	static int READING_T_FORECAST_DAY   = 27;
	static int READING_T_FORECAST_DATE  = 28;
	static int READING_T_FORECAST_LOW   = 29;
	static int READING_T_FORECAST_HIGH  = 30;
	static int READING_T_FORECAST_TEXT  = 31;
	static int READING_T_FORECAST_CODE  = 32;
	*/
	
	static int LATITUDE                 = 33;
	static int LONGITUDE                = 34;
	static int READING_NOTHING          = 0;
	int currentActivity = READING_NOTHING;
	String zip;
	WeatherXmlReader xml = new WeatherXmlReader();
	
	public void startDocument(){}
	
	public void startElement(String uri, String localName, String qName, Attributes attributes){
		//LOCATION
		if(qName.equals("yweather:location")){
			for(int i = 0; i < attributes.getLength(); i++){
				if(attributes.getQName(i).equals("city")){
					currentActivity = READING_LOCATION_CITY;
					xml.location_city = attributes.getValue(i);
				}
				else if(attributes.getQName(i).equals("region")){
					currentActivity = READING_LOCATION_REGION;
					xml.location_region = attributes.getValue(i);
				}
				else if(attributes.getQName(i).equals("country")){
					currentActivity = READING_LOCATION_COUNTRY;
					xml.location_country = attributes.getValue(i);
				}
			}
		}else
		//UNIT
		if(qName.equals("yweather:units")){
			for(int i = 0; i < attributes.getLength(); i++){
				if(attributes.getQName(i).equals("temperature")){
					currentActivity = READING_UNIT_TEMPERATURE;
					xml.units_temperature = attributes.getValue(i);
				}
				else if(attributes.getQName(i).equals("distance")){
					currentActivity = READING_UNIT_DISTANCE;
					xml.units_distance = attributes.getValue(i);
				}
				else if(attributes.getQName(i).equals("pressure")){
					currentActivity = READING_UNIT_PRESSURE;
					xml.units_pressure = attributes.getValue(i);
				}
				else if(attributes.getQName(i).equals("speed")){
					currentActivity = READING_UNIT_SPEED;
					xml.units_speed = attributes.getValue(i);
				}
			}	
		}else
		//WIND
		if(qName.equals("yweather:wind")){
			for(int i = 0; i < attributes.getLength(); i++){
				if(attributes.getQName(i).equals("chill")){
					currentActivity = READING_WIND_CHILL;
					xml.wind_chill = attributes.getValue(i);
				}
				else if(attributes.getQName(i).equals("direction")){
					currentActivity = READING_WIND_DIRECTION;
					xml.wind_direction = attributes.getValue(i);
				}
				else if(attributes.getQName(i).equals("speed")){
					currentActivity = READING_WIND_SPEED;
					xml.wind_speed = attributes.getValue(i);
				}
			}	
		}else
		//ATMOSPHERE
		if(qName.equals("yweather:atmosphere")){
			for(int i = 0; i < attributes.getLength(); i++){
				if(attributes.getQName(i).equals("humidity")){
					currentActivity = READING_ATMOSPHERE_HUMIDITY;
					xml.atmosphere_humidity = attributes.getValue(i);
				}
				else if(attributes.getQName(i).equals("visibility")){
					currentActivity = READING_ATMOSPHERE_VISIBILITY;
					xml.atmosphere_visibility = attributes.getValue(i);
				}
				else if(attributes.getQName(i).equals("pressure")){
					currentActivity = READING_ATMOSPHERE_PRESSURE;
					xml.atmosphere_pressure = attributes.getValue(i);
				}
				else if(attributes.getQName(i).equals("rising")){
					currentActivity = READING_ATMOSPHERE_RISING;
					xml.atmosphere_rising = attributes.getValue(i);
				}
			}	
		}
		else
		//ASTRONOMY
		if(qName.equals("yweather:astronomy")){
			for(int i = 0; i < attributes.getLength(); i++){
				if(attributes.getQName(i).equals("sunrise")){
					currentActivity = READING_ASTRONOMY_SUNRISE;
					xml.astronomy_sunrise = attributes.getValue(i);
				}
				else if(attributes.getQName(i).equals("sunset")){
					currentActivity = READING_ASTRONOMY_SUNSET;
					xml.astronomy_sunset = attributes.getValue(i);
				}
			}	
		}
		else
		//CONDITION
		if(qName.equals("yweather:condition")){
			for(int i = 0; i < attributes.getLength(); i++){
				if(attributes.getQName(i).equals("text")){
					currentActivity = READING_CONDITION_TEXT;
					xml.condition_text = attributes.getValue(i);
				}
				else if(attributes.getQName(i).equals("code")){
					currentActivity = READING_CONDITION_CODE;
					xml.condition_code = attributes.getValue(i);
				}
				else if(attributes.getQName(i).equals("temp")){
					currentActivity = READING_CONDITION_TEMP;
					xml.condition_temp = attributes.getValue(i);
				}
				else if(attributes.getQName(i).equals("date")){
					currentActivity = READING_CONDITION_DATE;
					xml.condition_date = attributes.getValue(i);
				}
			}	
		}else
		//FORECAST
			
		if(qName.equals("yweather:forecast") && (xml.forecast_day.equals("null"))){
			for(int i = 0; i < attributes.getLength(); i++){
				if(attributes.getQName(i).equals("day")){
					currentActivity = READING_FORECAST_DAY;
					xml.forecast_day = attributes.getValue(i);
				}
				else if(attributes.getQName(i).equals("date")){
					currentActivity = READING_FORECAST_DATE;
					xml.forecast_date = attributes.getValue(i);
				}
				else if(attributes.getQName(i).equals("low")){
					currentActivity = READING_FORECAST_LOW;
					xml.forecast_low = attributes.getValue(i);
				}
				else if(attributes.getQName(i).equals("high")){
					currentActivity = READING_FORECAST_HIGH;
					xml.forecast_high = attributes.getValue(i);
				}
				else if(attributes.getQName(i).equals("text")){
					currentActivity = READING_FORECAST_TEXT;
					xml.forecast_text = attributes.getValue(i);
				}
				else if(attributes.getQName(i).equals("code")){
					currentActivity = READING_FORECAST_CODE;
					xml.forecast_code = attributes.getValue(i);
				}
			}
		}
		else
		if(qName.equals("geo:lat")){
			currentActivity = LATITUDE;
		}
		else
		if(qName.equals("geo:long")){
			currentActivity = LONGITUDE;
		}
		/*
		else
		
		//T-FORECAST
		if(qName.equals("yweather:forecast")){
			for(int i = 0; i < attributes.getLength(); i++){
				if(attributes.getQName(i).equals("day")){
					currentActivity = READING_T_FORECAST_DAY;
					xml.t_forecast_day = attributes.getValue(i);
				}
				else if(attributes.getQName(i).equals("date")){
					currentActivity = READING_T_FORECAST_DATE;
					xml.t_forecast_date = attributes.getValue(i);
				}
				else if(attributes.getQName(i).equals("low")){
					currentActivity = READING_T_FORECAST_LOW;
					xml.t_forecast_low = attributes.getValue(i);
				}
				else if(attributes.getQName(i).equals("high")){
					currentActivity = READING_T_FORECAST_HIGH;
					xml.t_forecast_high = attributes.getValue(i);
				}
				else if(attributes.getQName(i).equals("text")){
					currentActivity = READING_T_FORECAST_TEXT;
					xml.t_forecast_text = attributes.getValue(i);
				}
				else if(attributes.getQName(i).equals("code")){
					currentActivity = READING_T_FORECAST_CODE;
					xml.t_forecast_code = attributes.getValue(i);
				}
			}	
		}
		*/
	}
	
	public void characters(char[] ch, int start, int length){
		String value = new String(ch, start, length);
		//location
		if(currentActivity == READING_LOCATION_CITY)
			xml.location_city = value;
		if(currentActivity == READING_LOCATION_REGION)
			xml.location_region = value;
		if(currentActivity == READING_LOCATION_COUNTRY)
			xml.location_country = value;
		
		//unit
		if(currentActivity == READING_UNIT_TEMPERATURE)
			xml.units_temperature = value;
		if(currentActivity == READING_UNIT_DISTANCE)
			xml.units_distance = value;
		if(currentActivity == READING_UNIT_PRESSURE)
			xml.units_pressure = value;
		if(currentActivity == READING_UNIT_SPEED)
			xml.units_speed = value;
		
		//wind
		if(currentActivity == READING_WIND_CHILL)
			xml.wind_chill = value;
		if(currentActivity == READING_WIND_DIRECTION)
			xml.wind_direction = value;
		if(currentActivity == READING_WIND_SPEED)
			xml.wind_speed = value;
		
		//atmosphere
		if(currentActivity == READING_ATMOSPHERE_HUMIDITY)
			xml.atmosphere_humidity = value;
		if(currentActivity == READING_ATMOSPHERE_VISIBILITY)
			xml.atmosphere_visibility = value;
		if(currentActivity == READING_ATMOSPHERE_PRESSURE)
			xml.atmosphere_pressure = value;
		if(currentActivity == READING_ATMOSPHERE_RISING)
			xml.atmosphere_rising = value;
		
		//astronomy
		if(currentActivity == READING_ASTRONOMY_SUNRISE)
			xml.astronomy_sunrise = value;
		if(currentActivity == READING_ASTRONOMY_SUNSET)
			xml.astronomy_sunset = value;
		
		//condition
		if(currentActivity == READING_CONDITION_TEXT)
			xml.condition_text = value;
		if(currentActivity == READING_CONDITION_CODE)
			xml.condition_code = value;
		if(currentActivity == READING_CONDITION_TEMP)
			xml.condition_temp = value;
		if(currentActivity == READING_CONDITION_DATE)
			xml.condition_date = value;
		
		//forecast
		if(currentActivity == READING_FORECAST_DAY)
			xml.forecast_day = value;
		if(currentActivity == READING_FORECAST_DATE)
			xml.forecast_date = value;
		if(currentActivity == READING_FORECAST_LOW)
			xml.forecast_low = value;
		if(currentActivity == READING_FORECAST_HIGH)
			xml.forecast_high = value;
		if(currentActivity == READING_FORECAST_TEXT)
			xml.forecast_text = value;
		if(currentActivity == READING_FORECAST_CODE)
			xml.forecast_code = value;
		if(!value.trim().equals("")){
			if(currentActivity == LATITUDE)
				xml.latitude = value;
			else if(currentActivity == LONGITUDE)
				xml.longitude = value;
		}
		/*
		//t-forecast
		if(currentActivity == READING_T_FORECAST_DAY)
			xml.t_forecast_day = value;
		if(currentActivity == READING_T_FORECAST_DATE)
			xml.t_forecast_date = value;
		if(currentActivity == READING_T_FORECAST_LOW)
			xml.t_forecast_low = value;
		if(currentActivity == READING_T_FORECAST_HIGH)
			xml.t_forecast_high = value;
		if(currentActivity == READING_T_FORECAST_TEXT)
			xml.t_forecast_text = value;
		if(currentActivity == READING_T_FORECAST_CODE)
			xml.t_forecast_code = value;
		*/
	}
	
	public void endElement(String uri, String localName, String qName){
		if(qName.equals("rss")){
			/*
			System.out.println(xml.location_city + xml.location_region + xml.location_country);
			System.out.println(xml.units_temperature + xml.units_distance + xml.units_pressure + xml.units_speed);
			System.out.println(xml.wind_chill + xml.wind_direction + xml.wind_speed);
			System.out.println(xml.atmosphere_humidity + xml.atmosphere_visibility + xml.atmosphere_pressure + xml.atmosphere_rising);
			System.out.println(xml.astronomy_sunrise + xml.astronomy_sunset);
			System.out.println(xml.condition_text + xml.condition_code + xml.condition_temp + xml.condition_date);
			System.out.println(xml.forecast_day + xml.forecast_date + xml.forecast_low + xml.forecast_high + xml.forecast_text + xml.forecast_code);
			//System.out.println(xml.t_forecast_day + xml.t_forecast_date + xml.t_forecast_low + xml.t_forecast_high + xml.t_forecast_text + xml.t_forecast_code);
			*/
			String query, GEOquery = null;
			java.sql.Date sqlNull = null;
			
			java.text.SimpleDateFormat isNow = new java.text.SimpleDateFormat("yyyy-MM-dd");
			String now = isNow.format(new java.util.Date());
			try {
				sqlNull = new java.sql.Date(isNow.parse(now).getTime());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if(xml.forecast_day.equals("null"))
				/*
				query = "update weather set location_city = '', location_region = '', location_country = '', " +
						"units_temperature = '', units_distance = '', units_pressure = '', units_speed = '', " +
						"wind_chill = '', wind_direction = '', wind_speed = '', " +
						"atmosphere_humidity = '', atmosphere_visibility = '', atmosphere_pressure = '', atmosphere_rising = '', " +
						"astronomy_sunrise = '', astronomy_sunset = '', " + 
						"condition_text = '', condition_code = 0, condition_temp = 0, condition_date = '', " + 
						"forecast_day = '', forecast_date = '0000-00-00', forecast_low = 0, forecast_high = 0, forecast_text = '', forecast_code = '' where zipcode = '" + zip + "';" ;
						*/
				
				query = "Insert into WEATHER " +
						"(zipcode, location_city, location_region, location_country," +
	   					"units_temperature, units_distance, units_pressure, units_speed," +
	   			    	"wind_chill, wind_direction, wind_speed," +
	   					"atmosphere_humidity, atmosphere_visibility, atmosphere_pressure, atmosphere_rising," +
	   					"astronomy_sunrise, astronomy_sunset," +
	   					"condition_text, condition_code, condition_temp, condition_date," +
	   					"forecast_day, forecast_date, forecast_low, forecast_high, forecast_text, forecast_code) " +
						"values('"+ zip +"','','','','','','','','','','','','','','','','','',0 ,0 ,'','','" + sqlNull +"',0,0,'','');";
			else{
				if(xml.location_city.indexOf("'") != -1)
					xml.location_city = xml.location_city.replace("'", "\\'");
				java.sql.Date sqlToday = null;
				SimpleDateFormat ts = new SimpleDateFormat("yyyy-MM-dd");
				
				try {
					sqlToday = new java.sql.Date(ts.parse(DateFormat.getFormatDate(xml.forecast_date)).getTime());
				} catch (ParseException e) {
					// TODO Auto-generated catch block					
					e.printStackTrace();
				}
				
				query = "Insert into WEATHER(zipcode, location_city, location_region, location_country," +
						   					"units_temperature, units_distance, units_pressure, units_speed," +
						   			    	"wind_chill, wind_direction, wind_speed," +
						   					"atmosphere_humidity, atmosphere_visibility, atmosphere_pressure, atmosphere_rising," +
						   					"astronomy_sunrise, astronomy_sunset," +
						   					"condition_text, condition_code, condition_temp, condition_date," +
						   					"forecast_day, forecast_date, forecast_low, forecast_high, forecast_text, forecast_code) " +
								"values('"+ zip + "','" + xml.location_city + "','" + xml.location_region + "','" + xml.location_country + "','"
								+ xml.units_temperature + "','" + xml.units_distance + "','" + xml.units_pressure + "','" + xml.units_speed + "','"
								+ xml.wind_chill + "','" + xml.wind_direction + "','" + xml.wind_speed + "','"
								+ xml.atmosphere_humidity + "','" + xml.atmosphere_visibility + "','" + xml.atmosphere_pressure + "','" + xml.atmosphere_rising + "','"
								+ xml.astronomy_sunrise + "','" + xml.astronomy_sunset + "','"
								+ xml.condition_text + "'," + xml.condition_code + "," + xml.condition_temp + ",'" + xml.condition_date + "','"
								+ xml.forecast_day + "','" + sqlToday + "'," + xml.forecast_low + "," + xml.forecast_high + ",'" + xml.forecast_text + "','" + xml.forecast_code + "'"
								//+ xml.t_forecast_day + "','" + xml.t_forecast_date + "'," + xml.t_forecast_low + "," + xml.t_forecast_high + ",'" + xml.t_forecast_text + "'," + xml.t_forecast_code 
								+ ");";
				GEOquery = "INSERT INTO GEO(zip, lat, lon) VALUES('" + zip + "','" + xml.latitude + "','" + xml.longitude + "');";
				/*
				query = "update weather set location_city = '"+ xml.location_city + "', location_region = '" + xml.location_region + "', location_country = '" + xml.location_country + "',"
							   + "units_temperature = '" + xml.units_temperature + "', units_distance = '" + xml.units_distance + "', units_pressure = '" + xml.units_pressure + "', units_speed = '" + xml.units_speed + "',"
							   + "wind_chill = '" + xml.wind_chill + "', wind_direction = '" + xml.wind_direction + "', wind_speed = '" + xml.wind_speed + "',"
							   + "atmosphere_humidity = '" + xml.atmosphere_humidity + "', atmosphere_visibility = '" + xml.atmosphere_visibility + "', atmosphere_pressure = '" + xml.atmosphere_pressure + "', atmosphere_rising = '" + xml.atmosphere_rising + "',"
							   + "astronomy_sunrise = '" + xml.astronomy_sunrise + "', astronomy_sunset = '" + xml.astronomy_sunset + "',"
							   + "condition_text = '" + xml.condition_text + "', condition_code = " + xml.condition_code + ", condition_temp = " + xml.condition_temp + ", condition_date = '" + xml.condition_date + "',"
							   + "forecast_day = '" + xml.forecast_day + "', forecast_date = '" + sqlToday + "', forecast_low = " + xml.forecast_low + ", forecast_high = " + xml.forecast_high + ", forecast_text = '" + xml.forecast_text + "', forecast_code = '" + xml.forecast_code + "' where zipcode = '" + zip + "';" ;
							   */
			}
			System.out.println(query);
			//System.out.println(GEOquery);
			SQLConnection sql = new SQLConnection();
			sql.SqlInsert(query);
			//sql.SqlInsert(GEOquery);
			//sql.SqlUpdate(query);
			sql.SqlClose();
			xml = new WeatherXmlReader();
		}
		currentActivity = READING_NOTHING;
	}
	
	public void endDocument(){}
}
