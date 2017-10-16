package url;
import java.net.*;
import java.io.*;

public class URLConnDemo {
	public static void main (String [] args)
	{
		try
		{
		URL url =new URL("http://www.24h.com.vn");
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
		
		InputStream is = connection.getInputStream();
		FileOutputStream fout = new FileOutputStream("test.html");
		byte []b = new byte[1024];
		int len ;
		
		while ((len = is.read(b))!=-1){
			fout.write(b,0,len);
		}
		fout.close();
//		
//		BufferedReader in= new BufferedReader(
//				new InputStreamReader(connection.getInputStream()));
//		String urlString="";
//		String current;
//		while((current=in.readLine())!=null)
//		{
//			urlString+=current;
//		}
//		System.out.println(urlString);
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
