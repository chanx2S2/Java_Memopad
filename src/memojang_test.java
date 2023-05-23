import javax.swing.*;
import java.awt.*;
import java.io.*; 
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;
import javax.swing.filechooser.*;  

public class memojang_test extends JFrame{

	public static final String Jframe = null;
	JFrame frame;
	private JButton fOpen = new JButton("����");
	private JButton fSave = new JButton("����");

	private JButton fOpen2 = new JButton("����");
	private JButton fSave2 = new JButton("����");

	private JButton fOpen3 = new JButton("����");
	private JButton fSave3 = new JButton("����");

	private JButton fOpen4 = new JButton("����");
	private JButton fSave4 = new JButton("����");

	//���� ���� ���� ����
	private FileDialog mSave = new FileDialog(frame,"����" ,FileDialog.SAVE);
	private FileDialog mOpen = new FileDialog(frame,"����",FileDialog.LOAD);
	private FileDialog mSave2 = new FileDialog(frame,"����" ,FileDialog.SAVE);
	private FileDialog mOpen2 = new FileDialog(frame,"����",FileDialog.LOAD);
	private FileDialog mSave3 = new FileDialog(frame,"����" ,FileDialog.SAVE);
	private FileDialog mOpen3 = new FileDialog(frame,"����",FileDialog.LOAD);
	private FileDialog mSave4 = new FileDialog(frame,"����" ,FileDialog.SAVE);
	private FileDialog mOpen4 = new FileDialog(frame,"����",FileDialog.LOAD);

	//�׼� ����
	public memojang_test() {
		setTitle("�޸� ����Ʈ");
		initialize();//GUI��
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() { //GUI ����
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 240));
		frame.setBounds(100, 100, 424, 682);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("�޸� ����Ʈ");
		lblNewLabel.setFont(new Font("�޸յձ�������", Font.PLAIN, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 10, 140, 55);
		frame.getContentPane().add(lblNewLabel);

		//[1]
		JTextArea text1 = new JTextArea("");
		text1.setBounds(80, 59, 302, 120);
		frame.getContentPane().add(text1);

		JScrollPane scrollPane1 = new JScrollPane(text1);
		scrollPane1.setBounds(70, 59, 328, 120);
		frame.getContentPane().add(scrollPane1);

		JButton btnOpen = new JButton("����");
		btnOpen.setToolTipText("\uD30C\uC77C\uC5F4\uAE30");
		btnOpen.setBackground(new Color(255, 182, 193));
		btnOpen.setFont(new Font("����", Font.BOLD, 11));
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mOpen.setVisible(true);
				String data = mOpen.getDirectory()+ mOpen.getFile();
				FileInputStream fis;   //���� �ý����� ���� �Է� ����Ʈ ��� ��Ʈ�� ����  
			     ByteArrayOutputStream bo;  //������ ����Ʈ �迭�� ���������� ��� ��Ʈ�� ����  
			      try  
			      {  
			       fis = new FileInputStream(data); // FileInputStream��ü�� ����  
			       bo = new ByteArrayOutputStream();     // ByteArrayOutputStream��ü�� ����  
			       int i = 0;  
			       while ((i = fis.read()) != -1) // ������ ���������� �о�帲  
			       {  
			        bo.write(i);                  //len ����Ʈ�� ����Ʈ �迭 ��� Stream�� ����  
			       }  
			        text1.setText(bo.toString("UTF-8")); // ȭ�鿡 �ѷ��ش�  
			        text1.setCaretPosition(text1.getDocument().getLength());


			       fis.close();                 // FileInputStream�� �ݴ´�.                  
			       bo.close();  

			     } catch(Exception e1){

			     }
			}
		});
		btnOpen.setBounds(10, 59, 57, 55);
		frame.getContentPane().add(btnOpen);

		JButton btnSave = new JButton("\uC800\uC7A5");
		btnSave.setBackground(new Color(0, 191, 255));
		btnSave.setToolTipText("\uD30C\uC77C\uC800\uC7A5");
		btnSave.setFont(new Font("����", Font.BOLD, 11));
		btnSave.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
				mSave.setVisible(true);
			    String data = mSave.getDirectory()+ mSave.getFile();  //������ ���丮 ������ ���ϸ��� ��´�.
			    try{
			    	PrintWriter pw   = new PrintWriter(new BufferedWriter(new FileWriter(data))); // PrintWriter��ü�� �����ؼ�  
			        pw.write(text1.getText()); // ȭ���� ������ ���Ͽ� ����  
			        pw.close();  
			    }  
			        catch(FileNotFoundException ie2)  
			           {}  
			        catch(IOException ie) {}
	    		}
			});
		btnSave.setBounds(11, 124, 57, 55);
		frame.getContentPane().add(btnSave);

		//[2]
		JScrollPane scrollPane2 = new JScrollPane((Component) null);
		scrollPane2.setBounds(70, 193, 328, 120);
		frame.getContentPane().add(scrollPane2);

		JTextArea text2 = new JTextArea("");
		scrollPane2.setViewportView(text2);

		JButton btnOpen2 = new JButton("����");
		btnOpen2.setToolTipText("\uD30C\uC77C\uC5F4\uAE30");
		btnOpen2.setFont(new Font("����", Font.BOLD, 11));
		btnOpen2.setBackground(new Color(255, 182, 193));
		btnOpen2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					mOpen2.setVisible(true);
					String data2 = mOpen2.getDirectory()+ mOpen2.getFile();
					FileInputStream fis2;   //���� �ý����� ���� �Է� ����Ʈ ��� ��Ʈ�� ����  
				     ByteArrayOutputStream bo2;  //������ ����Ʈ �迭�� ���������� ��� ��Ʈ�� ����  
				      try  
				      {  
				       fis2 = new FileInputStream(data2); // FileInputStream��ü�� ����  
				       bo2 = new ByteArrayOutputStream();     // ByteArrayOutputStream��ü�� ����  
				       int i2 = 0;  
				       while ((i2 = fis2.read()) != -1) // ������ ���������� �о�帲  
				       {  
				        bo2.write(i2);                  //len ����Ʈ�� ����Ʈ �迭 ��� Stream�� ����  
				       }  
				        text2.setText(bo2.toString("UTF-8")); // ȭ�鿡 �ѷ��ش�  
				        text2.setCaretPosition(text2.getDocument().getLength());


				       fis2.close();                 // FileInputStream�� �ݴ´�.                  
				       bo2.close();  

				     } catch(Exception e1){

				     }
				}
			});
		btnOpen2.setBounds(10, 195, 57, 55);
		frame.getContentPane().add(btnOpen2);

		JButton btnSave2 = new JButton("\uC800\uC7A5");
		btnSave2.setToolTipText("\uD30C\uC77C\uC800\uC7A5");
		btnSave2.setFont(new Font("����", Font.BOLD, 11));
		btnSave2.setBackground(new Color(0, 191, 255));
		btnSave2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
					mSave2.setVisible(true);
				    String data2 = mSave2.getDirectory()+ mSave2.getFile();  //������ ���丮 ������ ���ϸ��� ��´�.
				    try{
				    	PrintWriter pw2   = new PrintWriter(new BufferedWriter(new FileWriter(data2))); // PrintWriter��ü�� �����ؼ�  
				        pw2.write(text2.getText()); // ȭ���� ������ ���Ͽ� ����  
				        pw2.close();  
				    }  
				        catch(FileNotFoundException ie2)  
				           {}  
				        catch(IOException ie) {}
		    		}
				});
		btnSave2.setBounds(10, 258, 57, 55);
		frame.getContentPane().add(btnSave2);


		//[3]
		JScrollPane scrollPane3 = new JScrollPane((Component) null);
		scrollPane3.setBounds(70, 342, 328, 120);
		frame.getContentPane().add(scrollPane3);

		JTextArea text3 = new JTextArea("");
		scrollPane3.setViewportView(text3);

		JButton btnOpen3 = new JButton("\uC5F4\uAE30");
		btnOpen3.setToolTipText("\uD30C\uC77C\uC5F4\uAE30");
		btnOpen3.setFont(new Font("����", Font.BOLD, 11));
		btnOpen3.setBackground(new Color(255, 182, 193));
		btnOpen3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mOpen3.setVisible(true);
				String data3 = mOpen3.getDirectory()+ mOpen3.getFile();
				FileInputStream fis3;   //���� �ý����� ���� �Է� ����Ʈ ��� ��Ʈ�� ����  
			     ByteArrayOutputStream bo3;  //������ ����Ʈ �迭�� ���������� ��� ��Ʈ�� ����  
			      try  
			      {  
			       fis3 = new FileInputStream(data3); // FileInputStream��ü�� ����  
			       bo3 = new ByteArrayOutputStream();     // ByteArrayOutputStream��ü�� ����  
			       int i3 = 0;  
			       while ((i3 = fis3.read()) != -1) // ������ ���������� �о�帲  
			       {  
			        bo3.write(i3);                  //len ����Ʈ�� ����Ʈ �迭 ��� Stream�� ����  
			       }  
			        text3.setText(bo3.toString("UTF-8")); // ȭ�鿡 �ѷ��ش�  
			        text3.setCaretPosition(text3.getDocument().getLength());


			       fis3.close();                 // FileInputStream�� �ݴ´�.                  
			       bo3.close();  

			     } catch(Exception e1){

			     }
			}
		});
		btnOpen3.setBounds(10, 344, 57, 55);
		frame.getContentPane().add(btnOpen3);

		JButton btnSave3 = new JButton("\uC800\uC7A5");
		btnSave3.setToolTipText("\uD30C\uC77C\uC800\uC7A5");
		btnSave3.setFont(new Font("����", Font.BOLD, 11));
		btnSave3.setBackground(new Color(0, 191, 255));
		btnSave3.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
					mSave3.setVisible(true);
				    String data3 = mSave3.getDirectory()+ mSave3.getFile();  //������ ���丮 ������ ���ϸ��� ��´�.
				    try{
				    	PrintWriter pw3   = new PrintWriter(new BufferedWriter(new FileWriter(data3))); // PrintWriter��ü�� �����ؼ�  
				        pw3.write(text3.getText()); // ȭ���� ������ ���Ͽ� ����  
				        pw3.close();  
				    }  
				        catch(FileNotFoundException ie2)  
				           {}  
				        catch(IOException ie) {}
		    		}
				});
		btnSave3.setBounds(10, 409, 57, 55);
		frame.getContentPane().add(btnSave3);

		//[4]
		JScrollPane scrollPane4 = new JScrollPane((Component) null);
		scrollPane4.setBounds(70, 488, 328, 120);
		frame.getContentPane().add(scrollPane4);

		JTextArea text4 = new JTextArea("");
		scrollPane4.setViewportView(text4);

		JButton btnOpen4 = new JButton("\uC5F4\uAE30");
		btnOpen4.setToolTipText("\uD30C\uC77C\uC5F4\uAE30");
		btnOpen4.setFont(new Font("����", Font.BOLD, 11));
		btnOpen4.setBackground(new Color(255, 182, 193));
		btnOpen4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mOpen4.setVisible(true);
				String data4 = mOpen4.getDirectory()+ mOpen4.getFile();
				FileInputStream fis4;   //���� �ý����� ���� �Է� ����Ʈ ��� ��Ʈ�� ����  
			     ByteArrayOutputStream bo4;  //������ ����Ʈ �迭�� ���������� ��� ��Ʈ�� ����  
			      try  
			      {  
			       fis4 = new FileInputStream(data4); // FileInputStream��ü�� ����  
			       bo4 = new ByteArrayOutputStream();     // ByteArrayOutputStream��ü�� ����  
			       int i4 = 0;  
			       while ((i4 = fis4.read()) != -1) // ������ ���������� �о�帲  
			       {  
			        bo4.write(i4);                  //len ����Ʈ�� ����Ʈ �迭 ��� Stream�� ����  
			       }  
			        text4.setText(bo4.toString("UTF-8")); // ȭ�鿡 �ѷ��ش�  
			        text4.setCaretPosition(text4.getDocument().getLength());


			       fis4.close();                 // FileInputStream�� �ݴ´�.                  
			       bo4.close();  

			     } catch(Exception e1){

			     }
			}
		});
		btnOpen4.setBounds(10, 490, 57, 55);
		frame.getContentPane().add(btnOpen4);

		JButton btnSave4 = new JButton("\uC800\uC7A5");
		btnSave4.setToolTipText("\uD30C\uC77C\uC800\uC7A5");
		btnSave4.setFont(new Font("����", Font.BOLD, 11));
		btnSave4.setBackground(new Color(0, 191, 255));
		btnSave4.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
					mSave4.setVisible(true);
				    String data4 = mSave4.getDirectory()+ mSave4.getFile();  //������ ���丮 ������ ���ϸ��� ��´�.
				    try{
				    	PrintWriter pw4   = new PrintWriter(new BufferedWriter(new FileWriter(data4))); // PrintWriter��ü�� �����ؼ�  
				        pw4.write(text4.getText()); // ȭ���� ������ ���Ͽ� ����  
				        pw4.close();  
				    }  
				        catch(FileNotFoundException ie2)  
				           {}  
				        catch(IOException ie) {}
		    		}
				});
		btnSave4.setBounds(10, 555, 57, 55);
		frame.getContentPane().add(btnSave4);

		//�޴���
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("���� ���", Font.PLAIN, 15));
		frame.setJMenuBar(menuBar);//�޴��� ����

		JMenu Menu = new JMenu("�޴�");
		Menu.setFont(new Font("���� ���", Font.PLAIN, 15));
		menuBar.add(Menu);

		JMenuItem mntmNew = new JMenuItem("\uC0C8 \uBA54\uBAA8");
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				notepad np = new notepad();
				np.setVisible(true);
			}
		});
		Menu.add(mntmNew);

	}


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					memojang_test window = new memojang_test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}