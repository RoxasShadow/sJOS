import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Date {
	private static final String DATE_FORMAT = "E  d MMM yyyy, HH.mm.ss, z";
	
	public static String name() {
		return "date";
	}
	
	public static String usage() {
		return "Usage: date";
	}
	
	public static String help() {
		return "Displays the date";
	}
	
	public static String version() {
		return "0.01a";
	}
	
	public static String output(String[] format) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(format[0]);
		return sdf.format(cal.getTime());
	}
	
	public static String output() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		return sdf.format(cal.getTime());
	}
}
