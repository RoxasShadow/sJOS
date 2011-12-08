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
import java.io.*;
public class Rm extends Module {
	public static String getHelp() {
		StringBuilder help = new StringBuilder("");
		help.append("Usage: rm [OPTION]... FILE...\n");
		help.append("Remove the FILE(s).\n\n");
		help.append(makeMenu("-r", "--recursive", "remove directories and their contents recursively"));
		help.append(makeBasicMenu());
		return makeHelp(help.toString());
	}
	
	public static String getVersion() {
		return makeVersion("rm", "utils", "0.1", "Giovanni Capuano");
	}
	
	public static void deleteDirectory(File dir) throws IOException {
		File[] files = dir.listFiles();
		for(int i=0, count=files.length; i<count; ++i) {
			if(files[i].isDirectory())
				Rm.deleteDirectory(files[i]);
			else
				files[i].delete();
		}
		dir.delete();
	}
	
	public static void output(String[] input) {
		boolean recursive = false;
		for(String f:input) {
			if((f.equals("-r")) || (f.equals("--recursive"))) {
				recursive = true;
				continue;
			}
			try {
				File file = new File(f);
				if(file.exists())
					if((file.isDirectory()) && (!recursive)) {
						System.out.print("rm: impossible to remove \"");
						System.out.print(f);
						System.out.println("\": Is a directory");
					}
					else if((file.isDirectory()) && (recursive))
						Rm.deleteDirectory(file);
					else if(!file.isDirectory())
						file.delete();
				else {
					System.out.print("rm: impossible to remove \"");
					System.out.print(f);
					System.out.println("\": No such file or directory");
				}
			}
			catch(IOException e) {
				System.out.print("rm: impossible to remove \"");
				System.out.print(f);
				System.out.println("\": Permission denied");
			}
		}
	}
}
