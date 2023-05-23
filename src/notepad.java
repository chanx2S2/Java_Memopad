import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Label;
import java.awt.List;
import java.awt.TextField;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.Document;
import javax.swing.text.Utilities;
import javax.swing.undo.UndoManager;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PrinterJob;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class notepad extends JFrame {

	// 전역변수
	private JPanel contentPane;
	private JScrollPane scrollPane;
	static JTextArea textArea;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnEdit;
	private JMenu mnStyle;
	private JMenu mnLook;
	private JMenu mnHelp;
	private JMenuItem mntmNew;
	private JMenuItem mntmOpen;
	private JMenuItem mntmSave;
	private JMenuItem mntmSaveAs;
	private JMenuItem mntmEnd;
	private JMenuItem mntmCancel;
	private JSeparator separator_1;
	boolean count;
	boolean open_count;
	String absolute_filename;
	private JMenu mnPlus;
	private JMenuItem mntmNewMenuItem;
	private JToolBar toolBar;
	private JMenuItem mntmNewWindow;
	private JMenuItem mntmFont;
	private JToggleButton tglbtnBold;
	private JFrame frame;
	private JMenuItem mntmSetupPage;
	private JMenuItem mntmPrintout;
	private JSeparator separator;
	private JMenuItem mntmCut;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JMenuItem mntmCopy;
	private JMenuItem mntmPaste;
	private JMenuItem mntmDelete;
	private JMenuItem mntmFind;
	private JSeparator separator_4;
	private JSeparator separator_5;
	private JMenuItem mntmChooseAll;
	private JMenuItem mntmTimeDate;
	private UndoManager undoManager;
	private JMenuItem mntmAgain;
	private final static String newline = "\n";
	private JCheckBox chckbxChangeLine;
	boolean getState;
	private JMenuItem mntmZoonIn;
	private JMenuItem mntmZoomOut;
	private JSeparator separator_6;
	private JCheckBox chckbxstatusBar;
	private JMenuItem mntmInfo;
	private JToggleButton tglbtnItalic;
	private JTextField status;
	private int colNum = 1;
	private int rowNum = 1;
	private JSeparator separator_7;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */

	// notepad 함수
	public notepad() {

		// 기본 설정
		count = false;
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		// 메뉴바 설정
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		// 메뉴 - 파일 구성
		mnFile = new JMenu("\uD30C\uC77C");
		menuBar.add(mnFile);

		// 메뉴 아이템 - 새로 만들기
		mntmNew = new JMenuItem("\uC0C8\uB85C\uB9CC\uB4E4\uAE30");

		// 새로 만들기 - 리스너 추가
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmNew_actionPerformed(e);
			} // actionPerformed End
		}); // addActionlistener End

		mnFile.add(mntmNew);

		// 메뉴 아이템 - 열기
		mntmOpen = new JMenuItem("\uC5F4\uAE30");

		// 열기 - 리스너 추가
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmOpen_actionPerformed(e);
			} // actionPerformed End
		}); // addActionlistener End

		mnFile.add(mntmOpen);

		// 메뉴 아이템 - 새 창
		mntmNewWindow = new JMenuItem("\uC0C8 \uCC3D");

		// 새 창 - 리스너 추가
		mntmNewWindow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmNewMenuItem_2_actionPerformed(e);
			} // actionPerformed End
		}); // addActionlistener End

		mnFile.add(mntmNewWindow);

		// 메뉴 아이템 - 저장
		mntmSave = new JMenuItem("\uC800\uC7A5");

		// 저장 - 리스너 추가
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmSave_actionPerformed(arg0);
			} // actionPerformed End
		}); // addActionlistener End

		mnFile.add(mntmSave);

		// 메뉴 아이템 - 다른 이름으로 저장
		mntmSaveAs = new JMenuItem("\uB2E4\uB978\uC774\uB984\uC73C\uB85C \uC800\uC7A5");

		// 다른 이름으로 저장 - 리스너 추가
		mntmSaveAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmSaveAs_actionPerformed(e);
			} // actionPerformed End
		}); // addActionlistener End

		mnFile.add(mntmSaveAs);

		// 분리선 추가
		separator_1 = new JSeparator();
		mnFile.add(separator_1);

		// 메뉴 아이템 - 페이지 설정
		mntmSetupPage = new JMenuItem("\uD398\uC774\uC9C0 \uC124\uC815");

		// 페이지 설정 - 리스너 추가
		mntmSetupPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmSetupPage_actionPerformed(e);
			} // actionPerformed End
		}); // addActionlistener End

		mnFile.add(mntmSetupPage);

		// 메뉴 아이템 - 인쇄
		mntmPrintout = new JMenuItem("\uC778\uC1C4");

		// 인쇄 - 리스너 추가
		mntmPrintout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmPrintout_actionPerformed(e);
			} // actionPerformed End
		}); // addActionlistener End

		mnFile.add(mntmPrintout);

		// 메뉴 아이템 - 끝내기
		mntmEnd = new JMenuItem("\uB05D\uB0B4\uAE30");

		// 끝내기 - 리스너 추가
		mntmEnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmEnd_actionPerformed(e);
			} // actionPerformed End
		}); // addActionlistener End

		separator_7 = new JSeparator();
		mnFile.add(separator_7);

		mnFile.add(mntmEnd);

		// 분리선 추가
		separator = new JSeparator();
		mnFile.add(separator);

		// 메뉴 - 편집
		mnEdit = new JMenu("\uD3B8\uC9D1");
		menuBar.add(mnEdit);

		// 메뉴 아이템 - 실행 취소
		mntmCancel = new JMenuItem("\uC2E4\uD589\uCDE8\uC18C");

		// 실행 취소 - 리스너 추가
		mntmCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmCancel_actionPerformed(e);
			} // actionPerformed End
		}); // addActionlistener End

		mnEdit.add(mntmCancel);

		// 메뉴 아이템 - 다시 실행
		mntmAgain = new JMenuItem("\uB2E4\uC2DC\uC2E4\uD589");

		// 다시 실행 - 리스너 추가
		mntmAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmAgain_actionPerformed(e);
			} // actionPerformed End
		}); // addActionlistener End

		mnEdit.add(mntmAgain);

		// 분리선 추가
		separator_2 = new JSeparator();
		mnEdit.add(separator_2);

		// 분리선 추가
		separator_3 = new JSeparator();
		mnEdit.add(separator_3);

		// 메뉴 아이템 - 잘라내기
		mntmCut = new JMenuItem(new DefaultEditorKit.CutAction());
		mntmCut.setText("잘라내기");
		mnEdit.add(mntmCut);

		// 메뉴 아이템 - 복사
		mntmCopy = new JMenuItem(new DefaultEditorKit.CopyAction());
		mntmCopy.setText("복사");
		mnEdit.add(mntmCopy);

		// 메뉴 아이템 - 붙여넣기
		mntmPaste = new JMenuItem(new DefaultEditorKit.PasteAction());
		mntmPaste.setText("붙여넣기");
		mnEdit.add(mntmPaste);

		// 메뉴 아이템 - 삭제
		mntmDelete = new JMenuItem("\uC0AD\uC81C");

		// 삭제 - 리스너 추가
		mntmDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.replaceRange("", textArea.getSelectionStart(), textArea.getSelectionEnd());
			} // actionPerformed End
		}); // addActionlistener End

		mnEdit.add(mntmDelete);

		// 분리선 추가
		separator_4 = new JSeparator();
		mnEdit.add(separator_4);

		// 메뉴 아이템 - 찾기
		mntmFind = new JMenuItem("\uCC3E\uAE30");
		mntmFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search_Frame sf = new Search_Frame();
				sf.setTitle("찾기");
				sf.setVisible(true);
			} // actionPerformed End
		});

		mnEdit.add(mntmFind);

		separator_5 = new JSeparator();
		mnEdit.add(separator_5);

		mntmChooseAll = new JMenuItem("\uBAA8\uB450 \uC120\uD0DD");
		mntmChooseAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.selectAll();
				textArea.requestFocus();
			}
		});
		mnEdit.add(mntmChooseAll);

		mntmTimeDate = new JMenuItem("\uC2DC\uAC04/\uB0A0\uC9DC");
		mntmTimeDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocalDateTime now = LocalDateTime.now();
				String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"));
				textArea.append(formatedNow + newline);
			}
		});
		mnEdit.add(mntmTimeDate);

		mnStyle = new JMenu("\uC11C\uC2DD");
		menuBar.add(mnStyle);

		mntmFont = new JMenuItem("\uAE00\uAF34");
		mntmFont.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmFont_actionPerformed(e);
			}
		});
		mnStyle.add(mntmFont);

		chckbxChangeLine = new JCheckBox("\uC790\uB3D9\uC904\uBC14\uAFC8");
		chckbxChangeLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxChangeLine.isSelected()) {
					textArea.setLineWrap(true);
				} else {
					textArea.setLineWrap(false);
				}
			}
		});
		mnStyle.add(chckbxChangeLine);

		mnLook = new JMenu("\uBCF4\uAE30");
		menuBar.add(mnLook);

		mntmZoonIn = new JMenuItem("\uD655\uB300");
		mntmZoonIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Font font = textArea.getFont();
				float size = font.getSize() + 1.0f;
				textArea.setFont( font.deriveFont(size) );
			}
		});
		mnLook.add(mntmZoonIn);

		mntmZoomOut = new JMenuItem("\uCD95\uC18C");
		mntmZoomOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Font font = textArea.getFont();
				float size = font.getSize() + -1.0f;
				textArea.setFont( font.deriveFont(size) );
			}
		});
		mnLook.add(mntmZoomOut);

		separator_6 = new JSeparator();
		mnLook.add(separator_6);

		chckbxstatusBar = new JCheckBox("\uC0C1\uD0DC\uD45C\uC2DC\uC904");
		chckbxstatusBar.setSelected(true);
		chckbxstatusBar.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					status.setVisible(true);
                else
                	status.setVisible(false);
			}
		});
		mnLook.add(chckbxstatusBar);

		mnHelp = new JMenu("\uB3C4\uC6C0\uB9D0");
		menuBar.add(mnHelp);

		mntmInfo = new JMenuItem("\uBA54\uBAA8\uC7A5 \uC815\uBCF4");
		mntmInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HelpDialog hd = new HelpDialog(frame);
				hd.setBounds(getX() + 40, getY() + 70, 411, 313);
				hd.setVisible(true);
			}
		});
		mnHelp.add(mntmInfo);

		mnPlus = new JMenu("...");
		menuBar.add(mnPlus);

		mntmNewMenuItem = new JMenuItem("\uBA54\uBAA8 \uBAA9\uB85D");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmNewMenuItem_1_actionPerformed(e);
			}
		});
		mnPlus.add(mntmNewMenuItem);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 5, 424, 205);
		contentPane.add(scrollPane);

		undoManager = new UndoManager();
		textArea = new JTextArea();
		Document doc = textArea.getDocument();
		doc.addUndoableEditListener(undoManager);

		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				do_textArea_keyTyped(arg0);
			}
		});
		scrollPane.setViewportView(textArea);

		toolBar = new JToolBar();
		toolBar.setBounds(5, 210, 424, 23);
		contentPane.add(toolBar);

		tglbtnBold = new JToggleButton("\uAD75\uAC8C");
		tglbtnBold.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				do_tglbtnBold_stateChanged(e);
			}
		});
		toolBar.add(tglbtnBold);

		tglbtnItalic = new JToggleButton("\uAE30\uC6B8\uC784");
		tglbtnItalic.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				do_tglbtnItalic_stateChanged(e);
			}
		});
		toolBar.add(tglbtnItalic);

		status = new JTextField();
		toolBar.add(status);
		status.setColumns(10);

		status.setText("Line: " + rowNum + " Column: " + colNum);

		//updateStatus(1, 1);

	} // notepad 함수 End

	/*
	public void careUpdate(CaretEvent e) {
		JTextArea editArea = (JTextArea)e.getSource();
		int linenum = 1;
		int columnnum = 1;
		
		// We create a try catch to catch any exceptions. We will simply ignore such an error for our demonstration.
        try {
            // First we find the position of the caret. This is the number of where the caret is in relation to the start of the JTextArea
            // in the upper left corner. We use this position to find offset values (eg what line we are on for the given position as well as
            // what position that line starts on.
            int caretpos = editArea.getCaretPosition();
            linenum = editArea.getLineOfOffset(caretpos);
            // We subtract the offset of where our line starts from the overall caret position.
            // So lets say that we are on line 5 and that line starts at caret position 100, if our caret position is currently 106
            // we know that we must be on column 6 of line 5.
            columnnum = caretpos - editArea.getLineStartOffset(linenum);
            // We have to add one here because line numbers start at 0 for getLineOfOffset and we want it to start at 1 for display.
            linenum += 1;
        }
        catch(Exception ex) { }
        // Once we know the position of the line and the column, pass it to a helper function for updating the status bar.
        updateStatus(linenum, columnnum);
	}
	
	private void updateStatus(int linenum, int columnnum) {
        status.setText("Line: " + linenum + " Column: " + columnnum);
    }
*/
	private void Status() {
		int caretPos = textArea.getCaretPosition();
		int rowNum = (caretPos == 0) ? 1 : 0;
		for (int offset = caretPos; offset > 0;) {
		    try {
				offset = Utilities.getRowStart(textArea, offset) - 1;
			} catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    rowNum++;
		}
		System.out.println("Row: " + rowNum);

		int offset = 0;
		try {
			offset = Utilities.getRowStart(textArea, caretPos);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int colNum = caretPos - offset + 1;
		System.out.println("Col: " + colNum);
	}

	protected boolean do_mntmNew_actionPerformed(ActionEvent e) {

		if (count) {
			int option = JOptionPane.showConfirmDialog(this, "저장하시겠습니까?", "저장", JOptionPane.YES_NO_CANCEL_OPTION);
			String text = textArea.getText();
			if (option == JOptionPane.YES_OPTION) {
				// 액션을 null로 둬도 상관없음
				// do_mntmSave_actionPerformed(null);
//              System.out.println(open_count + "");
				if (opensave()) {
					textArea.setText("");
					open_count = false;
					return false;
				}

				JFileChooser chooser = new JFileChooser();
				int result = chooser.showSaveDialog(this); // 열기 한 다음에, return 받겠당
				if (result == JFileChooser.APPROVE_OPTION) {// jfileChooser의 확인일때만
					String fileName = chooser.getSelectedFile().getAbsolutePath(); // chooser가
																					// 선택한
																					// 파일의
																					// 절대경로를
																					// 갖고와라

					File file = new File(fileName);
					FileWriter filewriter;
					String contents = textArea.getText();

					try {
						filewriter = new FileWriter(file);
						filewriter.write(contents);
						filewriter.close();
						textArea.setText("");
						open_count = false;
						count = false;
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			} else if (option == JOptionPane.NO_OPTION) {
				textArea.setText("");
				count = false;
				open_count = false;
				return false;
			} else {
				return true;
			}
			// dialog dia = new dialog(text);
			// dia.setVisible(true);
		} else {
			textArea.setText("");
			count = false;
		}
		return count;

	}

	protected void do_mntmOpen_actionPerformed(ActionEvent arg0) {
		FileDialog mOpen = new FileDialog(frame);

		mOpen.setVisible(true);
		String data = mOpen.getDirectory() + mOpen.getFile();
		FileInputStream fis; // 파일 시스템의 파일 입력 바이트 취급 스트림 선언
		ByteArrayOutputStream bo; // 데이터 바이트 배열에 기입해지는 출력 스트림 선언
		try {
			fis = new FileInputStream(data); // FileInputStream객체를 생성
			bo = new ByteArrayOutputStream(); // ByteArrayOutputStream객체를 생성
			int i = 0;
			while ((i = fis.read()) != -1) // 파일이 끝날때까지 읽어드림
			{
				bo.write(i); // len 바이트를 바이트 배열 출력 Stream에 기입
			}
			textArea.setText(bo.toString("UTF-8")); // 화면에 뿌려준다
			textArea.setCaretPosition(textArea.getDocument().getLength());

			fis.close(); // FileInputStream을 닫는다.
			bo.close();

		} catch (Exception e1) {

		}
	}

	protected void do_mntmSave_actionPerformed(ActionEvent arg0) {
		if (count) {
			if (opensave()) {
				return;
			}
			JFileChooser chooser = new JFileChooser();
			int result = chooser.showSaveDialog(this); // 열기 한 다음에, return 받겠당
			if (result == JFileChooser.APPROVE_OPTION) {// jfileChooser의 확인일때만
				String fileName = chooser.getSelectedFile().getAbsolutePath(); // chooser가
																				// 선택한
																				// 파일의
																				// 절대경로를
																				// 갖고와라

				File file = new File(fileName);
				FileWriter filewriter;
				String contents = textArea.getText();

				try {
					filewriter = new FileWriter(file);
					filewriter.write(contents);
					filewriter.close();
					count = false;
					absolute_filename = fileName;
					open_count = true;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}

	public boolean opensave() {
		boolean shut = false;
		System.out.println(open_count + "");
		if (open_count) {
			System.out.println(absolute_filename);
			String contents = textArea.getText();
			File file = new File(absolute_filename);
			FileWriter filewriter;
			try {
				filewriter = new FileWriter(file);
				filewriter.write(contents);
				filewriter.close();
				count = false;
				shut = true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return shut;
	}

	protected void do_textArea_keyTyped(KeyEvent arg0) {
		count = true;
	}

	protected void do_mntmSaveAs_actionPerformed(ActionEvent e) {
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showSaveDialog(this); // 열기 한 다음에, return 받겠당
		if (result == JFileChooser.APPROVE_OPTION) {// jfileChooser의 확인일때만
			String fileName = chooser.getSelectedFile().getAbsolutePath(); // chooser가
																			// 선택한
																			// 파일의
																			// 절대경로를
																			// 갖고와라

			File file = new File(fileName);
			FileWriter filewriter;
			String contents = textArea.getText();

			try {
				filewriter = new FileWriter(file);
				filewriter.write(contents);
				filewriter.close();
				count = false;
				absolute_filename = fileName;
				open_count = true;
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}

	protected void do_mntmNewMenuItem_1_actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("\uBA54\uBAA8 \uBAA9\uB85D")) {
			frame = new JFrame();
			memojang_test window = new memojang_test();
			window.frame.setVisible(true);

		}
	}

	public void do_mntmNewMenuItem_2_actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("\uC0C8 \uCC3D")) {

			notepad np = new notepad();
			np.setVisible(true);
		}
	}

	protected void do_tglbtnBold_stateChanged(ChangeEvent e) {
		if (tglbtnBold.isSelected()) {
			Font font = new Font("고딕", Font.BOLD, 12);
			textArea.setFont(font);
		}

		else {
			Font font = new Font("고딕", Font.PLAIN, 12);
			textArea.setFont(font);
		}

	}

	protected void do_tglbtnItalic_stateChanged(ChangeEvent e) {
		if (tglbtnItalic.isSelected()) {
			Font font = new Font("고딕", Font.ITALIC, 12);
			textArea.setFont(font);
		}

		else {
			Font font = new Font("고딕", Font.PLAIN, 12);
			textArea.setFont(font);
		}
	}

	protected void do_mntmSetupPage_actionPerformed(ActionEvent e) {
		PrinterJob pj = PrinterJob.getPrinterJob();
		pj.setPrintable(null);
		pj.pageDialog(pj.defaultPage());
	}

	protected void do_mntmPrintout_actionPerformed(ActionEvent e) {
		try {
			PrinterJob pj = PrinterJob.getPrinterJob();

			pj.setPrintable(null);
			pj.printDialog();
			pj.print();

		} catch (Exception e1) {
		}
	}

	public void undoableEditHappened(UndoableEditEvent e) {
		// UndoableEditListener 구현
		undoManager.addEdit(e.getEdit());
	}

	protected void do_mntmCancel_actionPerformed(ActionEvent e) {
		if (undoManager.canUndo()) {
			undoManager.undo();
		}
	}

	protected void do_mntmAgain_actionPerformed(ActionEvent e) {
		if (undoManager.canRedo()) {
			undoManager.redo();
		}
	}

	protected boolean do_mntmEnd_actionPerformed(ActionEvent e) {
		// this.dispose();
		if (count) {
			int option = JOptionPane.showConfirmDialog(this, "저장하시겠습니까?", "저장", JOptionPane.YES_NO_CANCEL_OPTION);
			String text = textArea.getText();
			if (option == JOptionPane.YES_OPTION) {
				// 액션을 null로 둬도 상관없음
				// do_mntmSave_actionPerformed(null);
//              System.out.println(open_count + "");
				if (opensave()) {
					textArea.setText("");
					open_count = false;
					return false;
				}

				JFileChooser chooser = new JFileChooser();
				int result = chooser.showSaveDialog(this); // 열기 한 다음에, return 받겠당
				if (result == JFileChooser.APPROVE_OPTION) {// jfileChooser의 확인일때만
					String fileName = chooser.getSelectedFile().getAbsolutePath(); // chooser가
																					// 선택한
																					// 파일의
																					// 절대경로를
																					// 갖고와라

					File file = new File(fileName);
					FileWriter filewriter;
					String contents = textArea.getText();

					try {
						filewriter = new FileWriter(file);
						filewriter.write(contents);
						filewriter.close();
						textArea.setText("");
						open_count = false;
						count = false;
						dispose();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			} else if (option == JOptionPane.NO_OPTION) {
				dispose();
			} else {
				return true;
			}
			// dialog dia = new dialog(text);
			// dia.setVisible(true);
		} else {
			textArea.setText("");
			count = false;
			dispose();
		}
		return count;

	}

	protected void do_mntmFont_actionPerformed(ActionEvent e) {
		FontDialog ftd = new FontDialog(this);
		ftd.setBounds(getX() + 40, getY() + 70, 530, 320);
		ftd.setVisible(true);
		Font ft = ftd.fontSet();
		textArea.setFont(ft);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dimension dim = new Dimension(500,300);

					notepad frame = new notepad();
					frame.setTitle("제목없음 - 메모장");
					frame.setPreferredSize(dim);
					frame.setVisible(true);
					frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
} // notepad End

class FontDialog extends Dialog implements ActionListener {
	private Label jfdl1 = new Label();
	private Label jfdl2 = new Label();
	private Label jfdl3 = new Label();
	private Label jfdl4 = new Label();
	private Label jfdl5 = new Label();
	private Label jfdl6 = new Label();
	private TextField jfdtf1 = new TextField();
	private TextField jfdtf2 = new TextField();
	private TextField jfdtf3 = new TextField();
	private List jfdls1 = new List();
	private List jfdls2 = new List();
	private List jfdls3 = new List();
	private Button jfdb1 = new Button();
	private Button jfdb2 = new Button();
	Graphics g;

	Font f;
	String fontname = "SansSerif";
	int fontstyle = Font.PLAIN;
	int size = 8;

	String[] allFonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
	private String[] allSizes = { "8", "9", "10", "11", "12", "14", "16", "18", "20", "22", "24", "26", "28", "36",
			"48", "72" };
	private String[] allStyle = { "보통", "기울임꼴", "굵게", "굵은 기울임꼴" };

	FontDialog(Frame parent) {
		super(parent, "글꼴", true);

		setResizable(false);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		});
		setLayout(null);

		for (int i = 0; i < allFonts.length; i++) {
			jfdls1.add(allFonts[i]);
		}

		for (int i = 0; i < 16; i++) {
			jfdls3.add(allSizes[i]);
		}

		for (int i = 0; i < 4; i++) {
			jfdls2.add(allStyle[i]);
		}
		jfdl1.setText("글꼴");
		jfdl1.setBounds(10, 24, 98, 26);
		jfdl2.setText("글꼴 스타일");
		jfdl2.setBounds(198, 26, 98, 26);
		jfdl3.setText("크기");
		jfdl3.setBounds(340, 24, 98, 26);
		jfdl4.setText("보기");
		jfdl4.setBounds(266, 157, 49, 25);
		jfdtf1.setBounds(10, 49, 181, 24);
		jfdtf2.setBounds(201, 49, 129, 24);
		jfdtf3.setBounds(340, 49, 91, 24);
		jfdls1.setBounds(10, 77, 181, 79);
		jfdls1.addActionListener(this);
		jfdls2.setBounds(201, 77, 129, 79);
		jfdls2.addActionListener(this);
		jfdls3.setBounds(340, 77, 91, 79);
		jfdls3.addActionListener(this);
		jfdb1.setBounds(436, 51, 82, 28);
		jfdb1.setLabel("확인");
		jfdb1.addActionListener(this);
		jfdb2.setBounds(436, 85, 82, 28);
		jfdb2.setLabel("취소");
		jfdb2.addActionListener(this);
		add(jfdl4);
		add(jfdl5);
		add(jfdl1);
		add(jfdtf1);
		add(jfdls1);
		add(jfdb1);
		add(jfdb2);
		add(jfdls3);
		add(jfdl3);
		add(jfdtf3);
		add(jfdls2);
		add(jfdtf2);
		add(jfdl2);

		jfdl6.setBounds(212, 190, 220, 40);
		jfdl6.setText("가나다AaBbYyZz");
		add(jfdl6);

	}

	public void paint(Graphics g) {
		g.setColor(Color.lightGray);
		g.draw3DRect(202, 182, 232, 50, false);
		g.setColor(Color.black);
	}

	public Font fontSet() {
		jfdls1.getSelectedItem();
		fontname = jfdls1.getSelectedItem();

		if (jfdls2.getSelectedItem().equals("보통")) {
			fontstyle = Font.PLAIN;
		}	
		if (jfdls2.getSelectedItem().equals("기울임꼴")) {
			fontstyle = Font.ITALIC;
		}
		if (jfdls2.getSelectedItem().equals("굵게")) {
			fontstyle = Font.BOLD;
		}
		if (jfdls2.getSelectedItem().equals("굵은 기울임꼴")) {
			fontstyle = Font.ITALIC + Font.BOLD;
		}

		jfdtf3.setText(jfdls3.getSelectedItem());
		size = Integer.parseInt(jfdls3.getSelectedItem());

		return f = new Font(fontname, fontstyle, size);
	}

	public void actionPerformed(ActionEvent ae) {
		if ((ae.getSource()).equals(jfdls1)) {
			jfdtf1.setText(jfdls1.getSelectedItem());
			fontname = jfdls1.getSelectedItem();
			f = new Font(fontname, fontstyle, size);
			jfdl6.setFont(f);
		} else if ((ae.getSource()).equals(jfdls2)) {
			jfdtf2.setText(jfdls2.getSelectedItem());

			if (jfdls2.getSelectedItem().equals("보통"))
				fontstyle = Font.PLAIN;
			if (jfdls2.getSelectedItem().equals("기울임꼴"))
				fontstyle = Font.ITALIC;
			if (jfdls2.getSelectedItem().equals("굵게"))
				fontstyle = Font.BOLD;
			if (jfdls2.getSelectedItem().equals("굵은 기울임꼴"))
				fontstyle = Font.ITALIC + Font.BOLD;

			f = new Font(fontname, fontstyle, size);
			jfdl6.setFont(f);

		} else if ((ae.getSource()).equals(jfdls3)) {
			jfdtf3.setText(jfdls3.getSelectedItem());
			size = Integer.parseInt(jfdls3.getSelectedItem());
			f = new Font(fontname, fontstyle, size);
			jfdl6.setFont(f);
		} else if ((ae.getSource()).equals(jfdb1)) {
			setVisible(true);
			dispose();
		} else if ((ae.getSource()).equals(jfdb2)) {
			setVisible(false);
		}
	}
}

class HelpDialog extends Dialog implements ActionListener {// 도움말 새창
	Button ok;// 누르면 창이 닫히는 버튼
	Image img = getToolkit().getImage("img/memo.gif");
	Image mh = getToolkit().getImage("img/mh.gif");
	Image minfo = getToolkit().getImage("img/minfo.gif");
	Font f = new Font("굴림", Font.PLAIN, 12);

	HelpDialog(Frame parent) {
		super(parent, "메모장 정보", true);

		setResizable(false);

		setLayout(null);
		ok = new Button("확 인");
		ok.addActionListener(this);
		ok.setBounds(290, 250, 90, 25);
		add(ok);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		});
	}

	public void paint(Graphics g) {

		g.setFont(f);
		g.drawString("김찬영/이세희가 만든 메모장", 33, 66);
		g.drawString("Ver. 1.0. (빌드 2021: Service Pack 17)", 33, 83);
		g.drawString("Copyright (C) 2017-2021 김찬영/이세희", 33, 100);
		g.drawString("전주대학교 부트캠프 참여를 위해 만들어졌습니다.", 33, 150);
		g.drawString("Computer from ChanYoung's desktop", 33, 166);
		g.setColor(Color.lightGray);
		g.draw3DRect(33, 190, 334, 1, false);
		g.setColor(Color.black);
		String p = Runtime.getRuntime().totalMemory() / 1024 + "";
		g.drawString("Virtual Machine에서 사용할 수 있는 실제 메모리: " + p, 33, 210);
	}

	public void actionPerformed(ActionEvent ae) {
		dispose();
	}
}