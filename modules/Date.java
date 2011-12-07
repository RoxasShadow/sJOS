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
		help.append("FORMAT controls the output.  Interpreted sequences are:\n\n");
		help.append("Check `Data and Time Patterns` in http://docs.oracle.com/javase/1.4.2/docs/api/java/text/SimpleDateFormat.html\n");
		help.append("Default patterns is \"");
		help.append(DATE_FORMAT);
		help.append("\".\n\n");
		help.append(makeBasicMenu());
		return makeHelp(help.toString());
	}
	
	public static String getVersion() {
		return makeVersion("date", "utils", "0.1", "Giovanni Capuano");
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

