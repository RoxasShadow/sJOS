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
public class Cp extends Module {
	public static String getHelp() {
		StringBuilder help = new StringBuilder("");
		help.append("Usage: cp [OPTION]... SOURCE... DIRECTORY\n");
		help.append("Copy SOURCE to DEST, or multiple SOURCE(s) to DIRECTORY.\n\n");
		help.append(makeMenu("-r", "--recursive", "copy directories recursively"));
		help.append(makeBasicMenu());
		return makeHelp(help.toString());
	}
	
	public static String getVersion() {
		return makeVersion("cp", "utils", "0.1", "Giovanni Capuano");
	}
	
	public static void copy(File src, File dest) throws IOException {
		FileReader in = new FileReader(src);
		FileWriter out = new FileWriter(new File(dest, src.getName()));
		int c;
		while((c = in.read()) != -1)
			out.write(c);
		in.close();
		out.close();
	}
	
	public static void copyDirectory(File src, File dest) throws IOException {
		if(src.isDirectory()) {
			if(!dest.exists())
				dest.mkdir();
			String[] files = src.list();
			for(int i=0, count=files.length; i<count; ++i)
				Cp.copyDirectory(new File(src, files[i]), new File(dest, files[i]));
		}
		else {
			FileReader in = new FileReader(src);
			FileWriter out = new FileWriter(dest);
			int c;
			while((c = in.read()) != -1)
				out.write(c);
			in.close();
			out.close();
		}
	}
	
	public static void output(String[] input) {
		if(input.length < 2)
			return;
		boolean recursive = false;
		if((input[0].equals("-r")) || (input[0].equals("--recursive"))) {
			recursive = true;
			input[0] = input[1];
			input[1] = input[2];
		}
		try {
			File src = new File(input[0]);
			File dest = new File(input[1]);
			if(src.exists())
				if((src.isDirectory()) && (!recursive)) {
					System.out.print("cp: impossible to copy \"");
					System.out.print(input[0]);
					System.out.println("\": Is a directory");
				}
				else if((src.isDirectory()) && (recursive))
					Cp.copyDirectory(src, dest);
				else if(!src.isDirectory())
					Cp.copy(src, dest);
			else {
				System.out.print("cp: impossible to copy \"");
				System.out.print(input[0]);
				System.out.println("\": No such file or directory");
			}
		}
		catch(IOException e) {
			e.printStackTrace();
			System.out.print("cp: impossible to copy \"");
			System.out.print(input[0]);
			System.out.println("\": Permission denied");
		}
	}
}
