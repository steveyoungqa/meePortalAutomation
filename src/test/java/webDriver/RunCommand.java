package webDriver;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunCommand {

	/**
	 * Returns the output of running command
	 */
	public static String execute(String command, String arguments) throws IOException { 
		ProcessBuilder pb = new ProcessBuilder(command, arguments);
		Process p = pb.start();
		BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
		StringBuilder builder = new StringBuilder();
		String line = null;
		while ( (line = reader.readLine()) != null) {
			builder.append(line);
			builder.append(System.getProperty("line.separator"));
		}
		return builder.toString();
	}
	
	/**
	 * Exports the output on the execution to the file specified
	 */
	public static void execute(String command, String arguments, File filename) throws IOException {
		new ProcessBuilder(command, arguments).redirectOutput(filename).start();
	}
}
