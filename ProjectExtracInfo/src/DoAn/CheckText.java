package DoAn;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckText extends ExtractInfom 
{
	BufferedReader in= new BufferedReader(
			new InputStreamReader(connection.getInputStream()));
	String urlString="";
	String current;
	while((current=in.readLine())!=null)
	{
		urlString+=current;
//		System.out.println(urlString);
		try
		{
			Pattern pattern = Pattern.compile("[a-zA-Z_0-9]{5,}@[a-z]{2,}.[a-z]{3,}");
			Matcher matcher = pattern.matcher(current);
			if (matcher.find()) 
			{
				System.out.println("Ket qua: " + matcher.group());
			}
	
		}catch (Exception e) {
			System.out.println("Error. Please check!");
		}
	}
	System.out.println(urlString);
}
}
