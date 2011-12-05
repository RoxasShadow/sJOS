import java.io.*;
import java.net.URL;

public class Cat {
	public static String name() {
		return "cat";
	}
	
	public static String usage() {
		return "Usage: cat [FILE]";
	}
	
	public static String help() {
		return "Reads a input file.";
	}
	
	public static String version() {
		return "0.01a";
	}
	
	public static String output(String file) {
		try {
			URL path = new File(file).toURI().toURL();
			BufferedReader reader = new BufferedReader(new InputStreamReader(path.openStream()));
			StringBuffer buffer = new StringBuffer("");
			String line;
			while((line = reader.readLine()) != null)
				buffer.append(line+"\n");
			reader.close();
			return buffer.toString();
		}
		catch(Exception e) {
			return e.getMessage();
		}
	}
}
