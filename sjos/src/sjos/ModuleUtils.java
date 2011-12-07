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
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
public class ModuleUtils {
	public static boolean isJavaClass(File file) {
		try {
			int magic = 0xCAFEBABE; // Sweety
			if((!file.exists()) || (!file.toString().endsWith(".class")))
				return false;
			DataInputStream dataIn = new DataInputStream(new FileInputStream(file));
			return dataIn.readInt() == magic;
		}
		catch(IOException e) {
			return false;
		}
	}
	
	public static String[] removeElement(String[] array, int index) {
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(array));
		list.remove(index);
		return list.toArray(new String[array.length-1]);
	}
	

	public static String capitalize(String s) {
		if(s.length() == 0)
			return s;
		return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
	}
}
