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
public class Module {	
	/* Help */
	public static String makeHelp(String string) {
		return string;
	}
	public static String makeHelp(StringBuffer string) {
		return string.toString();
	}
	
	
	/* Version */
	public static String makeVersion(String name, String pkg, String version, String author) {
		return name+" ("+pkg+") "+version+"\n\nWritten by "+author+".";
	}
	
	/* Menù */
	public static String makeMenu(String s, String l, String t) {
		return "  "+s+", "+l+"\t\t"+t+"\n";
	}
	public static String makeMenu(String sl, String t) {
		return "\t"+sl+"\tdisplay this help and exit\n";
	}
	public static String makeBasicMenu() {
		return makeMenu("-h", "--help", "display this help and exit")+makeMenu("-v", "--version", "output version information and exit");
	}
}
