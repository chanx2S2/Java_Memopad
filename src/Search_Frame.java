import java.awt.Button;
import java.awt.Checkbox;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

class Search_Frame extends Frame implements ActionListener {
 private static final GraphicsConfiguration Title = null;
Panel Search_panel;
 Panel cancel_panel;
 Panel check_panel;
 Checkbox checkbox;
 Label content_label;
 Label check_label;
 TextField content_txt;
 Button next_search_btn;
 Button cancel;
 int num = 0;
 String search_input;
 int search_index;
 String str;

 Search_Frame() {
  super(Title);
  setBounds(100, 100, 500, 150);
  Search_panel = new Panel();
  cancel_panel = new Panel();
  check_panel = new Panel();
  checkbox = new Checkbox(null, true, null);
  content_label = new Label("찾을 내용 :  ");
  check_label = new Label("대/소문자 구분");
  content_txt = new TextField(30);
  next_search_btn = new Button("다음 찾기");
  cancel = new Button("취         소");

  Search_panel.add(content_label);
  Search_panel.add(content_txt);
  Search_panel.add(next_search_btn);
  cancel_panel.add(cancel);
  check_panel.add(checkbox);
  check_panel.add(check_label);
  add(Search_panel, "North");
  add(cancel_panel, "East");
  add(check_panel, FlowLayout.LEFT);

  next_search_btn.addActionListener(this);
  cancel.addActionListener(this);

 }

 public void actionPerformed(ActionEvent e) {

  if (e.getActionCommand() == "다음 찾기") {
   search_input = content_txt.getText();
   search_index = notepad.textArea.getText().indexOf(search_input, num);
   if (checkbox.getState() == false) {
    System.out.println("대소구분안함");
    search_input = content_txt.getText().toLowerCase();
    search_index = notepad.textArea.getText().toLowerCase()
      .indexOf(search_input, num);
   }
   str = notepad.textArea.getText().replaceAll("\\r", "");
   notepad.textArea.setText(str);
   notepad.textArea.requestFocus();
   for (int aa = 0; aa < str.length(); aa++) {
    if (search_index == aa) {
    	notepad.textArea.select(search_index,
       search_index + search_input.length());
     num = (search_index + search_input.length());
    }
   }

   if (num != search_index + search_input.length()) {
	   JOptionPane.showMessageDialog(null, search_input + "를 찾을 수 없습니다.");
	   /*
	End end = new End("경고창", search_input);
    end.setVisible(true);
    end.setBounds(200, 200, 200, 100);
    System.out.println("다찾음");
    */
   }
  } else {
   this.dispose(); // 찾기창닫기
  }
 }
}

/*
class End extends Frame {
 End(String Title, String input) {
  super(Title);
  Label msg = new Label();
  msg.setText("\"" + input + "\"" + "를 찾을 수 없습니다.");
  add(msg);
 }
}
*/