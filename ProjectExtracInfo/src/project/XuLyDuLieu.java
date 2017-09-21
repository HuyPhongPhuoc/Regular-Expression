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
					KQ+=current;
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
		 Pattern pattern = Pattern.compile("(?<email>[a-zA-Z_0-9]{5,}@[a-z]{2,}.[a-z]{3,})");
		 Matcher matcher = pattern.matcher(code);
//		 while(matcher.find(100))
//		 {
			 while(matcher.find()) {
				 kq+=matcher.group("email")+" \n";
				 
			 }
	// }
		 return kq;
	 }
	 public String CheckNumberPhone(String code)
	 {

		 String kq="";
		 Pattern pattern = Pattern.compile("[0-9]{10,11}");
		 Matcher matcher = pattern.matcher(code);
		 if (matcher.find()) {
		 System.out.println("Ket qua: " + matcher.group("email"));
		 }
		 return kq;
	 }
	 

}
