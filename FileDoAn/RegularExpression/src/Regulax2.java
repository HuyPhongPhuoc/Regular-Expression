<<<<<<< HEAD

=======
import java.util.regex.Matcher;
import java.util.regex.Pattern;
>>>>>>> 6a20d7ac775a2b3bf53461447479460ea9723e37

public class Regulax2 
{
	public static void main(String[] args) 
	{
		try
		{
			
<<<<<<< HEAD
			String email= "tuhuy@gmail.com";
=======
			String email= "<h style='font-size:12px;'>Tel: 0886924XXX - Fax: (08).39317XXX - tuhuy@gmail.com </h> <br><br>";
>>>>>>> 6a20d7ac775a2b3bf53461447479460ea9723e37
			System.out.println("Email:" +email);
			boolean match = email.matches("[a-zA-Z_0-9]{5,}@[a-z]{2,}.[a-z]{3,}");
			Pattern pattern = Pattern.compile("[a-zA-Z_0-9]{5,}@[a-z]{2,}.[a-z]{3,}");
			Matcher matcher = pattern.matcher(email);
			if (matcher.find()) {
				System.out.println("Ket qua: " + matcher.group());
			}else {
				System.out.print("tim khong thay");
			}
			boolean match2 = email.matches("[a-zA-Z_0-9]{5,}@[a-z]{2,}.[a-z]{3,}.[a-z]{1,}");
			System.out.println("KEtQua:" + match);
			System.out.println("KetQua2:"  + match2);
			
			if(match==true || match2 == true)
			{
				System.out.println("Email:" +email);
			}
			else
			{
				System.out.println("Sai Dinh Dang Email");
			}
	
		}catch (Exception e) {
			System.out.println("Error. Please check!");
		}
		
		
		//kiem  tra sdt
	/*	try
		{
			String sdt= "01235649810";
			System.out.println("sdt:" + sdt);
			boolean ktra = sdt.matches("[0-9]{10,11}");
			System.out.println("Ket Qua:" +ktra);
			if(ktra==true)
			{
				System.out.println("Sdt:" +sdt);
			}
			else
			{
				System.out.println("Day ko la sdt !!!");
			}
	
		}catch (Exception e) {
			System.out.println("Error. Please check! ");
		}
		
		//kiem tra Text
		try
		{
			String text= "adasdfsafsdf sdfasfdfasf15616165sdfsadfasdfsafsfdasdf";
			System.out.println("text:" + text);
			boolean ktra = text.matches(".*");
			if(ktra==true)
			{
				System.out.println("NoiDung:" +text);
			}
			else
			{
				System.out.println("Ko the lay text !!!");
			}
	
		}catch (Exception e) {
			System.out.println("Error. Please check! ");
		}
		
		//kiem tra jpg, png
		
		try
		{
			String text= "";
			System.out.println("text:" + text);
			boolean ktra = text.matches(".*");
			if(ktra==true)
			{
				System.out.println("Anh:" +text);
			}
			else
			{
				System.out.println("Ko co Images!!!");
			}
	
		}catch (Exception e) {
			System.out.println("Error. Please check! ");
		}*/
	}
}
