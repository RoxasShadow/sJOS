import java.lang.reflect.*;
import java.io.*;
import java.net.URLClassLoader;
import java.net.URL;
import java.util.ArrayList;

class ModuleLoader {
	private Class c;
	private Method[] m;
	
	public ModuleLoader(String name) {
		try {
			URL[] url = {new File("modules/").toURI().toURL()}; // What damn smoke Java developers when code this shits?
			URLClassLoader classLoader = new URLClassLoader(url);
			c = classLoader.loadClass(name);
			m = c.getDeclaredMethods();
		}
		catch(Exception e) {}
	}
	
	public static boolean isJavaClass(File file) {
		try {
			int magic = 0xCAFEBABE; // Sweety
			String name = file.toString();
			if(!file.exists() || !name.endsWith(".class"))
				return false;
			DataInputStream dataIn = new DataInputStream(new FileInputStream(file));
			return dataIn.readInt() == magic;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public static String[] getModuleList() {
		File dir = new File("modules/");
		File[] list = dir.listFiles();
		ArrayList<String> moduleList = new ArrayList<String>();
		for(int i=0, count=list.length; i<count; ++i) 
			if(ModuleLoader.isJavaClass(list[i]))
				moduleList.add(list[i].toString().replace("modules/", "").replace(".class", "")); // D:
		return (String[])moduleList.toArray(new String[moduleList.size()]);
	}
	
	public Class getModule() {
		return c;
	}
	
	public Method getMethod(String name) {
		for(int i=0, count=m.length; i<count; ++i)
			if(m[i].getName().equals(name))
				return m[i];
		return null;
	}
	
	public boolean isMethod(String name) {
		boolean find = false;
		for(int i=0, count=m.length; i<count; ++i)
			if(m[i].getName().equals(name))
				find = true;
		return find;
	}
}
