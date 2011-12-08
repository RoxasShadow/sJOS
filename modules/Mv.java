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
import java.io.File;
public class Mv extends Module {
	public static String getHelp() {
		StringBuilder help = new StringBuilder("");
		help.append("Usage: mv [OPTION]... SOURCE... DIRECTORY\n");
		help.append("Move SOURCE(s) to DIRECTORY.\n\n");
		help.append(makeBasicMenu());
		return makeHelp(help.toString());
	}
	
	public static String getVersion() {
		return makeVersion("mv", "utils", "0.1", "Giovanni Capuano");
	}
	
	public static void output(String[] input) {
		if(input.length < 2)
			return;
		try {
			File src = new File(input[0]);
			File dest = new File(input[1]);
			if(src.exists())
				src.renameTo(new File(dest, src.getName()));
			else {
				System.out.print("mv: impossible to move \"");
				System.out.print(input[0]);
				System.out.println("\": No such file or directory");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.print("mv: impossible to move \"");
			System.out.print(input[0]);
			System.out.println("\": Permission denied");
		}
	}
}
