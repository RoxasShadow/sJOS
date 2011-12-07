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
/* Yo dawg, I heard you like OS, so I put an OS in your OS so you can use an OS while you use an OS. */
import sjos.*;
import java.lang.reflect.*;
public class Main {	
	public static void main(String[] args) {
		if(args.length == 0) {
			String[] list = ModuleLoader.getModuleList();
			if(list.length == 0)
				System.out.println("No module found.");
			else
				for(int i=0, count=list.length; i<count; ++i)
					System.out.println(list[i]);
			System.exit(0);
		}
		args[0] = ModuleUtils.capitalize(args[0]);
		try {
			ModuleLoader m = new ModuleLoader(args[0]);
			if(args.length == 2)
				if((args[1].equals("--help")) || (args[1].equals("-h"))) {
					Class<?> c = m.getModule();
					System.out.println(c.getMethod("getHelp").invoke(m.getModule()));
					System.exit(0);
				}
				else if((args[1].equals("--version")) || (args[1].equals("-v"))) {
					Class<?> c = m.getModule();
					System.out.println(c.getMethod("getVersion").invoke(m.getModule()));
					System.exit(0);
				}
			Method[] mo = m.getModule().getDeclaredMethods(); // Methods list
			for(Method ml:mo) // For each method
				if(ml.getName().equals("output")) { // Selects output() and its overloads.
					Class[] tp = ml.getParameterTypes(); // All output()'s params
					if((tp.length == 0) && (args.length == 1)) // No params required
						ml.invoke(m.getClass());
					else if((tp.length > 0) && (args.length > 1)) // Params = String[] args without module name
						ml.invoke(m.getClass(), new Object[] { ModuleUtils.removeElement(args, 0) });
				}
		}
		catch(ModuleIntegrityException e) {
			System.out.println("Module corrupted or not found.");
		}
		catch(ModuleLoadingException e) {
			System.out.println("An error has occurred during the loading of the module.");
		}
		catch(NoSuchMethodException e) {
			System.out.println("Function not available in the module.");
		}
		catch(IllegalAccessException e) {
			System.out.println("Function not available in the module.");
		}
		catch(InvocationTargetException e) {
			System.out.println("An error has occurred during a function request in the module.");
		}
	}
}
