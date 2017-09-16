package DoAn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractInfom 
{
	public void ConnectedURL()
	{
		try
		{
			URL url =new URL("http://localhost/ThuyStore/index.php");
			URLConnection urlConnection=url.openConnection();
			HttpURLConnection connection=null;
			if(urlConnection instanceof HttpURLConnection)
			{
				connection=(HttpURLConnection) urlConnection;
			}
			else
			{
				System.out.println("Please enter an http URL");
				return;
			}
			
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	

	
}
