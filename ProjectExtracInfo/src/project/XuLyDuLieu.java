package project;


import java.io.BufferedReader;
import java.io.InputStreamReader;
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
		 Pattern pattern = Pattern.compile(regex);
		 Matcher matcher = pattern.matcher(code);
		 while (matcher.find()) {
			 kq+=matcher.group("name")+" \n"+"Giá: "+matcher.group("rice")+" VNĐ\n";

		 }
		 if(kq=="")
		 {
			 kq="Không tìm thấy";
		 }
		 return kq;
	 }
	


}
