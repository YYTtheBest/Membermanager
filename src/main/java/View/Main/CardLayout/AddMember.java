/*
 * Created by JFormDesigner on Fri Jun 10 21:53:38 CST 2022
 */

package View.Main.CardLayout;

import Utils.customFont;
import View.Main.MainFrame;
import View.RemainUI;
import dao.Impl.TbimemberDaoImpl;
import dao.TbimemberDao;
import entity.Tbimember;
import io.loli.datepicker.DatePicker;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.*;

/**
 * @author unknown
 */
public class AddMember extends JPanel {
    Image im ;
    private static Font font = new customFont(16, "Alibaba-PuHuiTi-Bold.ttf").getFont();
    private static Font font1 = new customFont(45, "superBlack.ttf").getFont();

    public AddMember(JPanel jPanel) {
        Image image = Toolkit.getDefaultToolkit().getImage("src/main/resources/static/fore3.jpg");
        this.im = image;
        //希望该Panel的大小事自适应的
        int width = jPanel.getWidth();
        int height = jPanel.getHeight();
        this.setSize(width,height);
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        phone = new JTextField();
        gender = new JTextField();
        name = new JTextField();
        date = new JTextField();
        button1 = new JButton();
        button2 = new JButton();

        DatePicker.datePicker(date);

        //======== this ========
        setForeground(new Color(85, 174, 224));
        setBackground(new Color(85, 174, 224));
        setLayout(null);

        //---- label1 ----
        label1.setText("会员开户");
        label1.setFont(font1);
        add(label1);
        label1.setBounds((int) (this.getWidth()*0.35), (int) (this.getHeight()*0.22),500,50);

        //---- label2 ----
        label2.setText("手机号");
        label2.setFont(font);
        add(label2);
        label2.setBounds(new Rectangle(new Point((int) (this.getWidth()*0.25), (int) (this.getHeight()*0.35)), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("性别");
        label3.setFont(font);
        add(label3);
        label3.setBounds((int) (this.getWidth()*0.26), (int)(this.getHeight()*0.45),60, 27);

        //---- label4 ----
        label4.setText("姓名");
        label4.setFont(font);
        add(label4);
        label4.setBounds((int) (this.getWidth()*0.45), (int) (this.getHeight()*0.35), 60, 27);

        //---- label5 ----
        label5.setText("日期");
        label5.setFont(font);
        add(label5);
        label5.setBounds((int) (this.getWidth()*0.45), (int) (this.getHeight()*0.45), 60, 27);
        add(phone);
        phone.setBounds(label2.getX()+80,label2.getY(), 120, 30);
        add(gender);
        gender.setBounds(label3.getX() + 65, label3.getY() , 120, 30);
        add(name);
        name.setBounds(label4.getX()+80, label4.getY(), 120, 30);
        add(date);
        date.setBounds(label5.getX()+80, label5.getY(), 120, 30);

        //---- button1 ----
        button1.setText("开户");
        button1.setFont(font);
        button1.setBackground(new Color(153, 97, 220));
        button1.setForeground(Color.white);

        add(button1);
        button1.setBounds((int) (this.getWidth()*0.30), (int) (this.getHeight()*0.55),88, 40);
        button1.addActionListener(e -> {
            TbimemberDao tbimemberDao = new TbimemberDaoImpl();
            Tbimember tbimember = new Tbimember();
            tbimember.setMName(name.getText());
            tbimember.setMSex(gender.getText());
            tbimember.setMPhone(phone.getText());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

            try {
                tbimember.setMOpendare(simpleDateFormat.parse(date.getText()));
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
            tbimember.setMMoney(0.0);


            int insert = tbimemberDao.insert(tbimember);
            if (insert == 1
            ) {
               new RemainUI("提示","成功");
            }else {
                new RemainUI("提示","失败");

            }
        });





        //---- button2 ----
        button2.setText("返回");
        button2.setFont(font);
        button2.setBackground(new Color(153, 97, 220));
        button2.setForeground(Color.white);
        add(button2);
        button2.setBounds((int) (this.getWidth()*0.45), (int) (this.getHeight()*0.55), 88, 40);
        button2.addActionListener(e -> {
            MainFrame.cardLayout.previous(MainFrame.card);
        });













//        -------this----------
        setBounds(300,500,500,200);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JTextField phone;
    private JTextField gender;
    private JTextField name;
    private JTextField date;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(im, 0, 0, this.getWidth(), this.getHeight(),this);
    }
}
