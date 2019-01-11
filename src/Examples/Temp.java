package Examples;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Temp {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

	/*	String text = "November 2018";
		String month = text.split(" ")[0];
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MMMM");
		date = sdf.parse(month);
		month = new SimpleDateFormat("MM").format(date);
		System.out.println(month);
		*/
		String d = "2/1/1992";
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		date = sdf.parse(d);
		int year = Integer.parseInt(new SimpleDateFormat("yyyy").format(date));
		int month = Integer.parseInt(new SimpleDateFormat("MM").format(date));
		int day = Integer.parseInt(new SimpleDateFormat("dd").format(date));
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);
//		Date date = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("M");
//		String day = sdf.format(date);
//		System.out.println(day);
	}
}
