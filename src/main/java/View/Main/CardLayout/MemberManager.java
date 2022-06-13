/*
 * Created by JFormDesigner on Sat Jun 11 20:08:23 CST 2022
 */

package View.Main.CardLayout;

import Utils.customFont;
import View.RemainUI;
import dao.Impl.TbimemberDaoImpl;
import dao.TbimemberDao;
import entity.Tbimember;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 * @author unknown
 */
public class MemberManager extends JPanel {
    private Boolean isByPhone ;
    public static TbimemberDao tbimemberDao = new TbimemberDaoImpl();
    private Font buttonFont = new customFont(18,"Alibaba-PuHuiTi-Bold.ttf").getFont();

    public MemberManager(JPanel panel) {

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        phoneOrName = new JTextField();
        phone = new JRadioButton();
        name = new JRadioButton();
        query = new JButton();
        modify = new JButton();
        delete = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        charge = new JButton();

        //======== this ========
        setLayout(null);
        setBounds(0,0,panel.getWidth(),panel.getHeight());


        add(phoneOrName);
        phoneOrName.setBounds((int) (panel.getWidth()*0.18), (int) (panel.getHeight()*0.08), 460, 35);
     phoneOrName.addKeyListener(new KeyAdapter() {
         @Override
         public void keyPressed(KeyEvent e) {
             if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                query.doClick();
             }
         }
     });

        //---- phone ----
        phone.setText("手机");
        phone.setFont(buttonFont);
        add(phone);
        phone.setSelected(true);
        phone.setBounds((int) (panel.getWidth()*0.06), (int) (panel.getHeight()*0.08), 70, 31);

        //---- name ----
        name.setText("姓名");
        name.setFont(buttonFont);
        add(name);
        name.setBounds((int) (panel.getWidth()*0.12), (int) (panel.getHeight()*0.08),70, 31);

        ButtonGroup group=new ButtonGroup();
        group.add(phone);
        group.add(name);





        //---- query ----
        query.setText("查询");
query.addActionListener(e -> {
    if (phone.isSelected()) isByPhone = true;
    else isByPhone = false;

    if (phoneOrName.getText().equals("")) {
        List<Tbimember> tbimembers = tbimemberDao.queryAll();
        showTable(tbimembers);
    }else {
        System.out.println(isByPhone);
        System.out.println(phoneOrName.getText());
        List<Tbimember> tbimembers = tbimemberDao.queryByPhoneOrName(isByPhone, phoneOrName.getText());

        showTable(tbimembers);
    }

});
        query.setFont(buttonFont);
        add(query);
        query.setBounds((int) (panel.getWidth()*0.51), (int) (panel.getHeight()*0.07405), 85, 45);

        //---- modify ----
        modify.setText("更改");
        add(modify);
        modify.setFont(buttonFont);
        modify.setBounds((int) (panel.getWidth()*0.58), (int) (panel.getHeight()*0.07405), 85, 45);
        modify.addActionListener(e ->
    {
        Tbimember tbimember = new Tbimember();
        tbimember.setMId((Integer) table1.getValueAt(table1.getSelectedRow(),0));
        tbimember.setMName((String) table1.getValueAt(table1.getSelectedRow(),1));
        tbimember.setMSex((String) table1.getValueAt(table1.getSelectedRow(),2));
        tbimember.setMPhone((String) table1.getValueAt(table1.getSelectedRow(),3));


        MemberModify memberModify = new MemberModify(tbimember);
        memberModify.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                List<Tbimember> tbimembers = tbimemberDao.queryAll();
                showTable(tbimembers);
            }
        });
    });

        //---- delete ----
        delete.setText("删除");
        add(delete);
        delete.addActionListener(e -> {
            int YesOrNo = JOptionPane.showConfirmDialog(null, "确认删除吗");
            if (YesOrNo == JOptionPane.YES_OPTION) {
                int result = tbimemberDao.deleteById((Integer) table1.getValueAt(table1.getSelectedRow(), 0));
                List<Tbimember> tbimembers = tbimemberDao.queryAll();
                showTable(tbimembers);
            }

        });
        delete.setFont(buttonFont);
        delete.setBounds((int) (panel.getWidth()*0.65), (int) (panel.getHeight()*0.07405), 85, 45);

        //---- charge ----
        charge.setText("充值");
        charge.setFont(charge.getFont().deriveFont(charge.getFont().getSize() + 8f));
        add(charge);
        charge.setFont(buttonFont);
        charge.setBounds((int) (panel.getWidth()*0.72), (int) (panel.getHeight()*0.07405), 85, 45);
        charge.addActionListener(e -> {
            String money = JOptionPane.showInputDialog(null, "请输入充值金额");
            int chargeResult = tbimemberDao.charge((Integer) table1.getValueAt(table1.getSelectedRow(), 0), Double.parseDouble(money));
            if (chargeResult != 0) {
                new RemainUI("提示", "成功");
                System.out.println(chargeResult);
                List<Tbimember> tbimembers = tbimemberDao.queryAll();
                showTable(tbimembers);
            }else {
                new RemainUI("提示", "失败");

            }
        });

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        add(scrollPane1);
        scrollPane1.setBounds(0, 130, panel.getWidth()-250, panel.getHeight()-135);

//        ----table----

        DefaultTableCellRenderer dc=new DefaultTableCellRenderer();
        dc.setHorizontalAlignment(SwingConstants.CENTER);
        table1.setDefaultRenderer(Object.class,dc);
//       显示表格
        List<Tbimember> tbimembers = tbimemberDao.queryAll();
        showTable(tbimembers);


        // JFormDesigner - End of component initialization
    }

    public void showTable(List<Tbimember> Tbimembers) {

        table1.validate();

        String[] index = {"序号", "姓名", "性别", "手机","办卡日期","卡余额"};

        Object[][] objects = new Object[Tbimembers.size()][index.length];
        for (int i = 0; i < objects.length; i++) {
            Tbimember tbimember = Tbimembers.get(i);
            objects[i][0] = tbimember.getMId();
            objects[i][1] = tbimember.getMName();
            objects[i][2] = tbimember.getMSex();
            objects[i][3] = tbimember.getMPhone();
            objects[i][4] = tbimember.getMOpendare();
            objects[i][5] = tbimember.getMMoney();
        }
        DefaultTableModel defaultTableModel = new DefaultTableModel(objects, index);
        table1.setModel(defaultTableModel);
        table1.setFont(new customFont(16f, "Alibaba-PuHuiTi-Bold.ttf").getFont());
        table1.setForeground(Color.BLACK);


    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTextField phoneOrName;
    private JRadioButton phone;
    private JRadioButton name;
    private JButton query;
    private JButton modify;
    private JButton delete;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton charge;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

}

class MemberModify extends JFrame {
    private Font buttonFont = new customFont(16,"Alibaba-PuHuiTi-Bold.ttf").getFont();

    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JTextField phone;
    private JTextField name
            ;
    private JTextField gender;
    private JButton modify;
    private JButton dispose;


    public MemberModify(Tbimember tbimember) {
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        JPanel jPanel = new JPanel();
        setContentPane(jPanel);
        jPanel.setLayout(null);
//        jPanel.setBackground(new Color(97, 220, 215));



        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        phone = new JTextField();
        name = new JTextField();
        gender = new JTextField();
        modify = new JButton();
        dispose = new JButton();
        //---- label1 ----
        label1.setText("更改会员信息");
        label1.setIcon(new ImageIcon(getClass().getResource("/picture/LibraryManage.png")));
        label1.setHorizontalAlignment(SwingConstants.LEFT);
        jPanel.add(label1);
        label1.setFont(buttonFont);
        label1.setBounds(125, 30, 255, 70);

        //---- label2 ----
        label2.setText("手机号");
        jPanel.add(label2);
        label2.setBounds(new Rectangle(new Point(65, 125), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("姓名");
        jPanel.add(label3);
        label3.setBounds(65, 175, 36, 17);

        //---- label4 ----
        label4.setText("性别");
        jPanel.add(label4);
        label4.setBounds(65, 225, 36, 17);
        jPanel.add(phone);
        phone.setBounds(140, 120, 170, phone.getPreferredSize().height);
        jPanel.add(name);
        name.setBounds(140, 170, 170, 30);
        jPanel.add(gender);
        gender.setBounds(140, 220, 170, 30);


//        给每个textfield赋值
        phone.setText(tbimember.getMPhone());
        name.setText( tbimember.getMName());
        gender.setText(tbimember.getMSex());
        //---- add ----
        modify.setText("修改");
        jPanel.add(modify);
        modify.addActionListener(e -> {
            Tbimember tbimember1 = new Tbimember();

           tbimember1.setMPhone(phone.getText());
           tbimember1.setMName(name.getText());
           tbimember1.setMSex(gender.getText());
           tbimember1.setMId(tbimember.getMId());
            int insert = MemberManager.tbimemberDao.update(tbimember1);
            if (insert != 0) {
                new RemainUI("提示", "成功");

                dispose();
            }else {
                new RemainUI("提示", "失败");

            }
        });
        modify.setBounds(new Rectangle(new Point(65, 280), modify.getPreferredSize()));

        //---- dispose ----
        dispose.setText("取消");
        jPanel.add(dispose);
        dispose.addActionListener(e -> {
            dispose();
        });
        dispose.setBounds(230, 280, 78, 30);

    }
}
