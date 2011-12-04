import java.util.*;
public class Date {
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
	
	public static String output() {
		return ""+new GregorianCalendar().get(Calendar.YEAR);
	}
	
	public void init() {}
	public void input(Object o) {}
}
