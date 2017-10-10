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
	

		URL url =new URL("https://www.thegioididong.com/dtdd-samsung#m:80,2&o:1");

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
			urlString+=current.trim();
			//"<h1 itemprop=\"name\">(?<name>[^<].*?)<\\/h1>.*?<span.*?>(?<rice>[^<].*?)<\\/span>"//regex laptopno1.com
			try
			{
				//Pattern pattern = Pattern.compile("[a-zA-Z_0-9]{5,}@[a-z]{2,}.[a-z]{3,}");
				Pattern pattern = Pattern.compile("(<!--#region Thường-->)(<li>?)(.*?)<h3>(?<name>[^<].*?)(</h3><strong>)(?<rice>[^<].*?)(</strong>)");
				Matcher matcher = pattern.matcher(urlString);
				while (matcher.find()) {
				System.out.println("Ket qua: " + matcher.group("name")+ matcher.group("rice"));

				}

		/*InputStream is = connection.getInputStream();
		FileOutputStream fout = new FileOutputStream("test.html");
		byte []b = new byte[1024];
		int len ;
		
		while ((len = is.read(b))!=-1){
			fout.write(b,0,len);
		}
		fout.close();*/
		

		
			}catch (Exception e) {
				System.out.println("Error. Please check!");
			}
			
			
		
		
		
			
		}
//		if(urlString!="")
//			System.out.println("Kết quả:"+urlString);
//		else 
//			System.out.println("Không tìm thấy !!!!");
//		
		
		System.out.println(urlString);
	
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
}
