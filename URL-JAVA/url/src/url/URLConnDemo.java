package url;
import java.net.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;
import java.util.regex.*;

public class URLConnDemo {
	
	
	public static void main (String [] args)
	{
		try
		{
<<<<<<< HEAD
		URL url =new URL("http://localhost:81/ThoStore/index.php");
=======
		URL url =new URL("https://subiz.com/blog/tag/email-marketing-vi");
>>>>>>> 6a20d7ac775a2b3bf53461447479460ea9723e37
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
<<<<<<< HEAD
				}				
									
=======
				}
				
				
				
				
		
<<<<<<< HEAD
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
=======
>>>>>>> a728fadfd4740a9e985534b995a1f0cb90078e58
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
		
>>>>>>> 6a20d7ac775a2b3bf53461447479460ea9723e37
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
}
