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
package sjos;
public class Module {	
	/* Help */
	public static String makeHelp(String string) {
		return string;
	}
	
	
	/* Version */
	public static String makeVersion(String name, String pkg, String version, String author) {
		StringBuilder make = new StringBuilder("");
		make.append(name);
		make.append(" (");
		make.append(pkg);
		make.append("( ");
		make.append(version);
		make.append("\n\nWritten by ");
		make.append(author);
		make.append(".");
		return make.toString();
	}
	
	/* Menù */
	public static String makeMenu(String s, String l, String t) {
		StringBuilder make = new StringBuilder("");
		make.append(" ");
		make.append(s);
		make.append(", ");
		make.append(l);
		make.append("\t\t");
		make.append(t);
		make.append("\n");
		return make.toString();
	}
	public static String makeMenu(String sl, String t) {
		StringBuilder make = new StringBuilder("");
		make.append("\t");
		make.append(sl);
		make.append("\tdisplay this help and exit\n");
		return make.toString();
	}
	public static String makeBasicMenu() {
		StringBuilder make = new StringBuilder("");
		make.append(makeMenu("-h", "--help", "display this help and exit"));
		make.append(makeMenu("-v", "--version", "output version information and exit"));
		return make.toString();
	}
}
