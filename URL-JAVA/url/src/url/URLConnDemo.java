package url;
import java.net.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

public class URLConnDemo {
	public static void main (String [] args)
	{
		try
		{
		URL url =new URL("https://subiz.com/blog/tag/email-marketing-vi");
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
	
		BufferedReader in= new BufferedReader(
				new InputStreamReader(connection.getInputStream()));
		String urlString="";
		String current;
		while((current=in.readLine())!=null)
		{
			urlString+=current;

			try
			{
				Pattern pattern = Pattern.compile("[a-zA-Z_0-9]{5,}@[a-z]{2,}.[a-z]{3,}");
				Matcher matcher = pattern.matcher(current);
				if (matcher.find()) {
				System.out.println("Ket qua: " + matcher.group());
				urlString=matcher.group();
				}				
									
			}catch (Exception e) {
				System.out.println("Error. Please check!");
			}
			
			
		}
/*
		Pattern pattern = Pattern.compile("[a-zA-Z_0-9]{5,}@[a-z]{2,}.[a-z]{3,}");
		Matcher matcher = pattern.matcher(urlString);
		if (matcher.find()) {
		System.out.println("Ket qua: " + matcher.group());
		}
*/		
		
//		if(urlString!="")
//			System.out.println("Kết quả:"+urlString);
//		else 
//			System.out.println("Không tìm thấy !!!!");
//		
		
		//System.out.println(urlString);
		
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
}
