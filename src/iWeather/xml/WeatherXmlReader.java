package iWeather.xml;

public class WeatherXmlReader {
	//LOCATION
	String location_city;
	String location_region;
	String location_country;
	
	//UNIT
	String units_temperature;
	String units_distance;
	String units_pressure;
	String units_speed;
	
	//WIND
	String wind_chill;
	String wind_direction;
	String wind_speed;
	
	//ATMOSPHERE
	String atmosphere_humidity;
	String atmosphere_visibility;
	String atmosphere_pressure;
	String atmosphere_rising;
	
	//ASTRONOMY
	String astronomy_sunrise;
	String astronomy_sunset;
	
	//CONDITION
	String condition_text;
	String condition_code;
	String condition_temp;
	String condition_date;
	
	//FORECAST
	String forecast_day = "null";
	String forecast_date;
	String forecast_low;
	String forecast_high;
	String forecast_text;
	String forecast_code;
	
	String latitude;
	String longitude;
	/*
	//T_FORECAST
	String t_forecast_day;
	String t_forecast_date;
	String t_forecast_low;
	String t_forecast_high;
	String t_forecast_text;
	String t_forecast_code;
	*/
}
