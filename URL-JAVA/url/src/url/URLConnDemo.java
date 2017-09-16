package url;
import java.net.*;
import java.io.*;
import java.util.regex.*;

public class URLConnDemo {
	
	
	public static void main (String [] args)
	{
		try
		{
		URL url =new URL("http://localhost:81/ThoStore/index.php");
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
		
		/*InputStream is = connection.getInputStream();
		FileOutputStream fout = new FileOutputStream("test.html");
		byte []b = new byte[1024];
		int len ;
		
		while ((len = is.read(b))!=-1){
			fout.write(b,0,len);
		}
		fout.close();*/
		
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
				ei.kiemtraemail(string dong);
				
				Pattern pattern= Pattern.compile("[0-9]{10,11}");
				Matcher matcher= pattern.matcher(current);
//				boolean match = current.matches("[a-zA-Z_0-9]{5,}@[a-z]{2,}.[a-z]{3,}");
//				boolean match2 = current.matches("[a-zA-Z_0-9]{5,}@[a-z]{2,}.[a-z]{3,}.[a-z]{1,}");
				
				
				if(matcher.find())
				{
					System.out.println("Email:" +matcher.group());
				}
				
		
			}catch (Exception e) {
				System.out.println("Error. Please check!");
			}
			
			
		}
		System.out.println(urlString);
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
