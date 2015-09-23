package webDriver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFiles {

	public static void readConfig(String filename)
	{
		BufferedReader br = null;
		String line = "";
		List<String> array = new ArrayList<String>();
		try
		{
			br = new BufferedReader(new FileReader(filename));
			while ((line = br.readLine()) != null)
			{
				array.add(line);
			}
			setValues(array);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static String search(List<String> array, String config)
	{
		String returnValue = null;
		if (array.contains(config))
		{	
			for (int i=0;i<array.size();i++)
			{
				if (array.get(i).contains(config))
				{
					returnValue = array.get(i + 1);
					break;
				}
			}
		}
		else
		{
			System.out.println("Value not found");
		}
		return returnValue;
	}
	
	public static void setValues(List<String> array) // specify values to be set by readCSV here
	{
		GlobalVariables.seleniumHub = search(array, "<SeleniumHub>");

	}
}
