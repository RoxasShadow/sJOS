/* Yo dawg, I heard you like OS, so I put an OS in your OS so you can use an OS while you use an OS. */
import java.io.File;
import java.lang.reflect.*;

public class Main {	
	public static void main(String[] args) {
		if(args.length == 0) {
			String[] list = ModuleLoader.getModuleList();
			for(int i=0, count=list.length; i<count; ++i)
				System.out.println(list[i]);
			System.exit(0);
		}
		if(!ModuleLoader.isJavaClass(new File("modules/"+args[0]+".class"))) {
			System.out.println("The module is corrupted.");
			System.exit(1);
		}
		try {
			ModuleLoader m = new ModuleLoader(args[0]);
			if(m.isMethod("name")) // If exists
				System.out.println("Name: "+m.getMethod("name").invoke(m.getClass()));
			if(m.isMethod("version"))
				System.out.println("Version: "+m.getMethod("version").invoke(m.getClass()));
			if(m.isMethod("usage"))
					System.out.println("Usage: "+m.getMethod("usage").invoke(m.getClass()));
			if(m.isMethod("help"))
				System.out.println("Help: "+m.getMethod("help").invoke(m.getClass()));
			if(m.isMethod("output")) {
				Method[] mo = m.getModule().getDeclaredMethods(); // Methods list
				for(Method ml:mo) // For each method
					if(ml.getName().equals("output")) { // Selects output() and its overloads.
						Class[] tp = ml.getParameterTypes(); // All output()'s params
						if((tp.length == 0) && (args.length == 1)) // No params required
							System.out.println("Output: "+ml.invoke(m.getClass()));
						else if((tp.length > 0) && (args.length > 1)) // Params = String[] args without module name
							System.out.println("Output: "+ml.invoke(m.getClass(), new Object[] { ModuleLoader.removeElement(args, 0) }));
					}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
