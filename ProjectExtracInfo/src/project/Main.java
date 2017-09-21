package project;

import java.awt.EventQueue;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Giaodien window = new Giaodien();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Url u= new Url();
		System.out.println(u.getUrl());
		
		/*String url="https://subiz.com/blog/tag/email-marketing-vi";
		String code=XLDL.connectUrl(url);
		System.out.println(code);
		String email=XLDL.CheckEmail(code);
		System.out.println(email);
		String sdt=XLDL.CheckNumberPhone(code);
		System.out.println(sdt);*/


	}

}
