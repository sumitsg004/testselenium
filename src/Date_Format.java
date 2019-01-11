import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Date_Format {

	public static void main(String[] args) throws ParseException {
		
		String d = "20/11/1992";
		Date Formatteddate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Formatteddate = sdf.parse(d);
		System.out.println(Formatteddate);
		
		String day = new SimpleDateFormat("d").format(Formatteddate);
		System.out.println(day);
		
		String month = new SimpleDateFormat("MM").format(Formatteddate);
		System.out.println(month);
		String month1 = new SimpleDateFormat("MMM").format(Formatteddate);
		System.out.println(month1);
		String month2 = new SimpleDateFormat("MMMM").format(Formatteddate);
		System.out.println(month2);
		
		String year = new SimpleDateFormat("yyyy").format(Formatteddate);
		System.out.println(year);
		

	}

}
