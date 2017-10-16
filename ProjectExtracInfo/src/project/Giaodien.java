package project;


import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import java.awt.BorderLayout;


public class Giaodien implements ActionListener
{
		JFrame frame;
		JLabel lblNewLabel = new JLabel("URL");
		String[] chose = { "Email", "Phone", "Products", "Image" };
		JComboBox<String> comboBox = new JComboBox<String>(chose);
		JButton btnOk = new JButton("OK");
	 	JTextField url = new JTextField();
	 	JTextArea screen = new JTextArea();
	 	JScrollPane scroll = new JScrollPane(screen); 
	 	
		/**
		 * Create the application.
		 */
		public Giaodien() 
		{
			initialize();
		
		}

		/**
		 * Initialize the contents of the frame.
		 */
		protected void initialize()
		{
			frame = new JFrame();
			frame.setResizable(true);
			frame.setBounds(200, 200, 650, 500);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		                   // <-- THIS
			
			JPanel panel = new JPanel();
			frame.getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			

			lblNewLabel.setBounds(78, 23, 56, 16);
			panel.add(lblNewLabel);
			

			comboBox.setBounds(88, 52, 174, 22);
			panel.add(comboBox);
			

			btnOk.setBounds(288, 51, 97, 25);
			panel.add(btnOk);
			btnOk.addActionListener(this);
			
			url.setBounds(146, 20, 227, 22);
			panel.add(url);
			url.setColumns(10);
			
			
	//		screen.setBounds(25, 89, 580, 350);
		//	screen.setWrapStyleWord(true);
			//panel.add(screen);10, 10, 100, 200

			scroll.setBounds(25, 89, 580, 350);
			panel.add(scroll);
			//frame.getContentPane().add(scroll);
			//scroll.setBounds(10, 10, 560, 330); 
			//screen.add(scroll);
			
		}



		@Override
		public void actionPerformed(ActionEvent e) {
			Url u=new Url();
			
			XuLyDuLieu xldl = new XuLyDuLieu();
			if(e.getSource()==btnOk) {
				u.setUrl(url.getText());//lấy url từ ô textfield truyền vào class url
				
				if(comboBox.getSelectedItem()=="Email") 
				{

					clear();		//Xóa khung textarea					
					String kq=xldl.CheckEmail(xldl.connectUrl(u.getUrl()));
					screen.append(kq);
				}else if(comboBox.getSelectedItem()=="Phone") 
				{
					clear();
					String kq=xldl.CheckNumberPhone(xldl.connectUrl(u.getUrl()));
				
					screen.append(kq);
					
				}
				else if(comboBox.getSelectedItem()=="Products") 
				{
					clear();
					String kq=xldl.CheckProducts(xldl.connectUrl(u.getUrl()));					
					screen.append(kq);

				}
				else if(comboBox.getSelectedItem()=="Image") 
				{
					clear();
					String kq="";
					try {
						kq = xldl.CheckImage(xldl.connectUrl(u.getUrl()));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}					
					screen.append(kq);

				}
			}
		}
		public void clear()
		{
			screen.setText("");
		}
}


