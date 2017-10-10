package project;


import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class XuLyDuLieu {
	
	 
	 public String connectUrl(String url) 
		{
			String KQ="";
			try {
				URL ur= new URL(url);
				URLConnection urlConnection=ur.openConnection();
				HttpURLConnection connection=null;
				if(urlConnection instanceof HttpURLConnection)
				{
					connection=(HttpURLConnection) urlConnection;
				}
				else
				{
					 JOptionPane.showMessageDialog(new JFrame(), "Please enter an http URL!!","Error",
						        JOptionPane.ERROR_MESSAGE);
					
					return KQ;
					
				}
				//Đọc html
				BufferedReader in= new BufferedReader(new InputStreamReader(connection.getInputStream()));
					
				String current;
				while((current=in.readLine())!=null)
				{
					KQ+=current.trim();
				}
			} catch (Exception e) {
				 JOptionPane.showMessageDialog(new JFrame(), e.getMessage(),"Error",
					        JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
			return KQ ;
		}
	 
	 public String CheckEmail(String code)
	 {
		
		 String kq="";
		 Pattern pattern = Pattern.compile("(?<email>[a-zA-Z_0-9|(\\.|\\_|\\-)]{4,}@[a-z]{2,}.[a-z]{3,})");
		 Matcher matcher = pattern.matcher(code);
		 while(matcher.find()) {
			 
				 kq+=matcher.group("email")+" \n";				 
		 }
		 if(kq=="")
		 {
			 kq="Không tìm thấy";
		 }
		 return kq;
	 }
	 public String CheckNumberPhone(String code)
	 {

		 String kq="";
		 Pattern pattern = Pattern.compile("(?<phone>(08|09|01|19|18)[0-9]{1,2}[- .]?[0-9]{2,4}[- .]?[0-9]{2,4})");
		 Matcher matcher = pattern.matcher(code);
		 while (matcher.find()) {
			 kq+=matcher.group("phone")+" \n";
		 }
		 if(kq=="")
		 {
			 kq="Không tìm thấy";
		 }
		 return kq;
	 }
	 public String CheckProducts(String code)
	 {

		 String kq="";
		 String regex="(<!--#region ThÆ°á»�ng-->)(<li>?)(.*?)<h3>(?<name>[^<].*?)(<\\/h3><strong>)(?<rice>[^<].*?)(â‚«<\\/strong>)";
		 String regex1="<li class=.*?>(.*?)<h3>(?<name>[^<].*?)<\\/h3>(.*?)<strong>?(?<rice>[^<].*?)(â‚«<\\/strong>)";
		 Pattern pattern = Pattern.compile(regex);
		 Matcher matcher = pattern.matcher(code);		
		 Pattern pattern1 = Pattern.compile(regex1);
		 Matcher matcher1 = pattern1.matcher(code);
		 if(matcher.find()) {
			 while (matcher.find()) {
				 kq+=matcher.group("name")+" \n"+"Giá: "+matcher.group("rice")+" VNĐ\n" ;
			 }
			
		 }else if(matcher1.find()) {
			 while (matcher1.find()) {
			 kq+=matcher1.group("name")+" \n"+"Giá: "+matcher1.group("rice")+" VNĐ\n";
			 }
		 }		 		 		
		 else
		 {
			kq="Không tìm thấy!!!";
		 }
		 
		 return kq;
	 }
	 public String CheckImage(String code) throws IOException
	 {
		 String folderPath = "E:\\github\\image";
		 String kq="",src="";
		 String regex="(<!--#region ThÆ°á»�ng-->)(<li>?)(.*?)original=\"(?<src>(.*?))\"";
		 Pattern pattern = Pattern.compile(regex);
		 Matcher matcher = pattern.matcher(code);
		 while (matcher.find()) {
			 kq+=matcher.group("src")+" \n";
			 src=matcher.group("src");
			 int indexname = src.lastIndexOf("/");
			 if (indexname == src.length()) {
				 src = src.substring(1, indexname);			
			 }				  
			 indexname = src.lastIndexOf("/");
			 String name = src.substring(indexname, src.length());

			 URL url = new URL(matcher.group("src"));
		     java.io.InputStream in = url.openStream();			 			  			 
		     OutputStream out = new BufferedOutputStream ( new FileOutputStream(folderPath+name));			 			  			 
		      for (int b; (b = in.read()) != -1;) 
			 {			 
		        out.write(b);
			 }			 
		      out.close();			 
		      in.close();
		 }
		 if(kq=="")
		 {
			 kq="Không tìm thấy";
		 }
		 return kq;
	 }


}
