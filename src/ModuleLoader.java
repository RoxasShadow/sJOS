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
import java.lang.reflect.*;
import java.io.*;
import java.net.URLClassLoader;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.ArrayList;
public class ModuleLoader {
	private Class c;
	private Method[] m;
	
	public static Class getClass(String name) throws ModuleIntegrityException, ModuleLoadingException {
		try {
			URL[] path = {new File("modules/").toURI().toURL()}; // What damn Java developers smoke when code this shits?
			URLClassLoader classLoader = new URLClassLoader(path);
			return classLoader.loadClass(name);
		}
		catch(MalformedURLException e) {
			throw new ModuleIntegrityException();
		}
		catch(ClassNotFoundException e) {
			throw new ModuleIntegrityException();
		}
	}
	
	public ModuleLoader(String name) throws ModuleIntegrityException, ModuleLoadingException {
		if(!ModuleLoader.isModule(name))
			throw new ModuleIntegrityException();
		try {
			setModule(ModuleLoader.getClass(name));
		}
		catch(ModuleIntegrityException e) {
			throw new ModuleIntegrityException();
		}
		catch(ModuleLoadingException e) {
			throw new ModuleLoadingException();
		}
		setMethod(c.getDeclaredMethods());
	}
	
	public static String[] getModuleList() {
		File dir = new File("modules/");
		if(!dir.isDirectory())
			return new String[0];
		File[] list = dir.listFiles();
		ArrayList<String> moduleList = new ArrayList<String>();
		for(int i=0, count=list.length; i<count; ++i) {
			String module = list[i].toString().replace("modules/", "").replace(".class", "");
			if(ModuleLoader.isModule(module))
				moduleList.add(module.toLowerCase()); // modules/Cat.class => cat
		}
		return moduleList.toArray(new String[moduleList.size()]);
	}
	
	public static boolean isModule(String name) {
		if(!ModuleUtils.isJavaClass(new File("modules/"+name+".class"))) // Is a Java valid class?
			return false;
		try {
			Class c = ModuleLoader.getClass(name.replace(".class", ""));
			return c.getSuperclass().getName().equals("Module"); // Extends Module class?
		}
		catch(ModuleIntegrityException e) {
			return false;
		}
		catch(ModuleLoadingException e) {
			return false;
		}
	}
	
	public Class getModule() {
		return c;
	}
	
	public Method[] getMethod() {
		return m;
	}
	
	public void setModule(Class c) {
		this.c = c;
	}
	
	public void setMethod(Method[] m) {
		this.m = m;
	}
	
	public Method getMethod(String name) {
		Method[] m = getMethod();
		for(int i=0, count=m.length; i<count; ++i)
			if(m[i].getName().equals(name))
				return m[i];
		return null;
	}
	
	public boolean isMethod(String name) {
		Method[] m = getMethod();
		boolean find = false;
		for(int i=0, count=m.length; i<count; ++i)
			if(m[i].getName().equals(name))
				find = true;
		return find;
	}
}
