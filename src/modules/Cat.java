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
import java.io.*;
import java.net.URL;
import java.util.Scanner;
public class Cat extends Module {	
	public static String getHelp() {
		StringBuffer help = new StringBuffer("");
		help.append("Usage: cat [FILE]...\n");
		help.append("Concatenate FILE(s), or standard input, to standard output.\n\n");
		help.append(makeBasicMenu());
		return makeHelp(help);
	}
	
	public static String getVersion() {
		return makeVersion("cat", "utils", "0.1", "Giovanni Capuano");
	}
	
	public static void output() {
		while(true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println(scanner.next());
		}
	}
		
	public static void output(String[] input) {
		StringBuffer output = new StringBuffer("");
		for(String f:input) {
			try {
				File file = new File(f);
				if(!file.exists()) {
					System.out.println("cat: "+f+": No such file or directory");
					continue;
				}
				else if(file.isDirectory()) {
					System.out.println("cat: "+f+": Is a directory");
					continue;
				}
				URL path = file.toURI().toURL();
				BufferedReader reader = new BufferedReader(new InputStreamReader(path.openStream()));
				StringBuffer buffer = new StringBuffer("");
				String line;
				while((line = reader.readLine()) != null)
					buffer.append(line+"\n");
				reader.close();
				output.append(buffer.toString());
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		if(output.length() > 0)
			System.out.println(output.toString());
	}
}
