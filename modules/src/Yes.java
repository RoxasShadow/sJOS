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
public class Yes extends Module {	
	public static String getHelp() {
		StringBuilder help = new StringBuilder("");
		help.append("Usage: yes [STRING]...\n");
		help.append("Repeatedly output a line with all specified STRING(s), or \"y\".\n\n");
		help.append(makeBasicMenu());
		return makeHelp(help);
	}
	
	public static String getVersion() {
		return makeVersion("yes", "utils", "1.0", "Giovanni Capuano");
	}
	
	public static void output() {
		while(true)
			System.out.println("y");
	}
	
	public static void output(String[] input) {
		while(true)
			System.out.println(input[0]);
	}
}
