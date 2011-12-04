/* Yo dawg, I heard you like os, so I put an os in your os so you can using an os while you using an os. */
import java.io.File;

public class Main {	
	public static void main(String[] args) {
		try {
			if(args.length == 0) {
				String[] list = ModuleLoader.getModuleList();
				for(String f : list)
					System.out.println(f);
				System.exit(0);
			}
			if(!ModuleLoader.isJavaClass(new File("modules/"+args[0]+".class")))
				System.exit(0);
			ModuleLoader m = new ModuleLoader(args[0]);
			if(m.isMethod("name"))
				System.out.println("Name: "+m.getMethod("name").invoke(m.getClass()));
			if(m.isMethod("version"))
				System.out.println("Version: "+m.getMethod("version").invoke(m.getClass()));
			if(m.isMethod("usage"))
					System.out.println("Usage: "+m.getMethod("usage").invoke(m.getClass()));
			if(m.isMethod("help"))
				System.out.println("Help: "+m.getMethod("help").invoke(m.getClass()));
			if(m.isMethod("output")) {
				Class[] t = m.getMethod("output").getParameterTypes();
				if(t.length == 0)
					System.out.println("Output: "+m.getMethod("output").invoke(m.getClass()));
				else
					if(t.length == args.length-1)
						for(int i=1, count=t.length; i<=count; ++i)
							System.out.println("Output:\n"+m.getMethod("output").invoke(m.getClass(), args[i]));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
