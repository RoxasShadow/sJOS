/*
*    Giovanni Capuano <webmaster@giovannicapuano.net>
*    This program is free software: you can redistribute it and/or modify
*    it under the terms of the GNU General Public License as published by
*    the Free Software Foundation, either version 3 of the License, or
*    (at your option) any later version.
*
*    This program is distributed in the hope that it will be useful,
*    but WITHOUT ANY WARRANTY; without even the implied warranty of
*    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
*    GNU General Public License for more details.
*
*    You should have received a copy of the GNU General Public License
*    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
import sjos.Module;
import java.util.Calendar;
import java.text.SimpleDateFormat;
public class Date extends Module {
	private static final String DATE_FORMAT = "E  d MMM yyyy, HH.mm.ss, z";
	
	public static String getHelp() {
		StringBuffer help = new StringBuffer("");
		help.append("Usage: date [+FORMAT]\n");
		help.append("Display the current time in the given FORMAT.\n\n");
		help.append(makeBasicMenu());
		help.append("\nFORMAT controls the output.  Interpreted sequences are:\n\n");
		help.append(makeMenu("G", "era designator", ""));
		help.append(makeMenu("y", "year", ""));
		help.append(makeMenu("M", "month in year", ""));
		help.append(makeMenu("w", "week in year", ""));
		help.append(makeMenu("W", "week in month", ""));
		help.append(makeMenu("D", "day in year", ""));
		help.append(makeMenu("d", "day in month", ""));
		help.append(makeMenu("F", "day of week in month", ""));
		help.append(makeMenu("E", "day in week", ""));
		help.append(makeMenu("a", "am/pm marker", ""));
		help.append(makeMenu("H", "hour in day (0-23)", ""));
		help.append(makeMenu("k", "hour in day (1-24)", ""));
		help.append(makeMenu("K", "hour in am/pm (0-11)", ""));
		help.append(makeMenu("h", "hour in am/pm (1-12)", ""));
		help.append(makeMenu("m", "minute in hour", ""));
		help.append(makeMenu("s", "second in minute", ""));
		help.append(makeMenu("S", "millisecond", ""));
		help.append(makeMenu("z", "time zone", ""));
		help.append(makeMenu("Z", "time zone", ""));
		help.delete(help.length()-2, help.length()); // Last \n
		return makeHelp(help.toString());
	}
	
	public static String getVersion() {
		return makeVersion("date", "utils", "0.9", "Giovanni Capuano");
	}
	
	public static void output() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		System.out.println(sdf.format(cal.getTime()));
	}
	
	public static void output(String[] input) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(input[0]);
		System.out.println(sdf.format(cal.getTime()));
	}
}

