package iWeather.xml;

public class DateFormat {
	public static String getFormatDate(String date){
		String result;
		String[] temp = date.split(" ");
		if(temp[1].equals("Jan"))
			temp[1] = "01";
		if(temp[1].equals("Feb"))
			temp[1] = "02";
		if(temp[1].equals("Mar"))
			temp[1] = "03";
		if(temp[1].equals("Apr"))
			temp[1] = "04";
		if(temp[1].equals("May"))
			temp[1] = "05";
		if(temp[1].equals("Jun"))
			temp[1] = "06";
		if(temp[1].equals("Jul"))
			temp[1] = "07";
		if(temp[1].equals("Aug"))
			temp[1] = "08";
		if(temp[1].equals("Sep"))
			temp[1] = "09";
		if(temp[1].equals("Oct"))
			temp[1] = "10";
		if(temp[1].equals("Nov"))
			temp[1] = "11";
		if(temp[1].equals("Dec"))
			temp[1] = "12";
		result = temp[2] + "-" + temp[1] + "-" + temp[0];
		//System.out.println(result);
		return result;
	}
	/*
	public static void main(String[] args){
		//System.out.println(getFormatDate("5 Feb 2011"));
		
	}*/
}
