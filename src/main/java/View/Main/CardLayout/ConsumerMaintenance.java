/*
 * Created by JFormDesigner on Sat Jun 11 14:27:51 CST 2022
 */

package View.Main.CardLayout;

import Utils.customFont;
import View.RemainUI;
import dao.Impl.TbservicesDaoImpl;
import dao.TbservicesDao;
import entity.Tbservices;

import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


/**
 * @author unknown
 */
public class ConsumerMaintenance extends JPanel {
    public static TbservicesDao tbservicesDao = new TbservicesDaoImpl();
    private Font buttonFont = new customFont(24,"Alibaba-PuHuiTi-Bold.ttf").getFont();

    public ConsumerMaintenance(JPanel panel) {
        Image image = Toolkit.getDefaultToolkit().getImage("src/main/resources/static/fore4.jpg");
        this.im = image;
        //希望该Panel的大小事自适应的
        int width = panel.getWidth();
        int height = panel.getHeight();
        this.setSize(width,height);
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        insert = new JButton();
        modify = new JButton();
        delete = new JButton();
        scrollPane1 = new JScrollPane();

        textField1 = new JTextField();
        search = new JButton();

        //======== this ========
        setLayout(null);
        setBounds(0,0,panel.getWidth(),panel.getHeight());

        //---- insert ----
        insert.setText("添加");
        insert.setFont(buttonFont);
        insert.setForeground(Color.white);
        insert.setBackground(new Color(34, 118, 222));
        add(insert);
        insert.setBounds((int) (this.getWidth()*0.2), (int) (this.getHeight()*0.18), 90, 50);
        insert.addActionListener(e -> {
            addConsume addConsume = new addConsume();
            addConsume.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    List<Tbservices> tbservices1 = ConsumerMaintenance.tbservicesDao.queryAll();
                    showTable(tbservices1);
                }
            });


        });

        //---- modify ----
        modify.setText("更改");
        modify.setFont(buttonFont);
        modify.setForeground(Color.white);
        modify.setBackground(new Color(34, 118, 222));
modify.addActionListener(e->{
    Tbservices tBservices = new Tbservices();
        tBservices.setSerId((Integer) table1.getValueAt(table1.getSelectedRow(),0));
        tBservices.setSerName((String) table1.getValueAt(table1.getSelectedRow(),1));
        tBservices.setSerPrice((Double) table1.getValueAt(table1.getSelectedRow(),2));
        tBservices.setSerMemprice((Double) table1.getValueAt(table1.getSelectedRow(),3));
    System.out.println(tBservices);

    modifyConsume modifyConsume = new modifyConsume(tBservices);
    modifyConsume.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosed(WindowEvent e) {
            List<Tbservices> tbservices1 = ConsumerMaintenance.tbservicesDao.queryAll();
            showTable(tbservices1);
        }
    });


});
        add(modify);
        modify.setBounds((int) (this.getWidth()*0.35), (int) (this.getHeight()*0.18), 90, 50);

        //---- delete ----
        delete.setText("删除");
        delete.setFont(buttonFont);
        delete.setForeground(Color.white);
        delete.setBackground(new Color(34, 118, 222));
        add(delete);
        delete.setBounds((int) (this.getWidth()*0.5), (int) (this.getHeight()*0.18),90, 50);
        delete.addActionListener(e -> {
            int id = (int) table1.getValueAt(table1.getSelectedRow(), 0);
            int i = tbservicesDao.deleteById(id);
            if (i > 0) {
                new RemainUI("提示", "成功");
                List<Tbservices> tbservices = tbservicesDao.queryAll();
                showTable(tbservices);

            }else {
                new RemainUI("提示", "失败");

            }

        });
        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        add(scrollPane1);
        scrollPane1.setBounds(0, (int) (this.getHeight()*0.25), panel.getWidth()-250, panel.getHeight());
//        ----textField1----
        add(textField1);
        textField1.setBounds((int) (this.getWidth()*0.25), (int) (this.getHeight()*0.1), 250,textField1.getPreferredSize().height);

        //---- search ----
        search.setText("搜索");
        textField1.setText("请输入消费项名称");
        textField1.setForeground(new Color(204, 204, 204));
        textField1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField1.getText().equals("请输入消费项名称")) {
                    textField1.setText("");
                    textField1.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField1.getText().length()<1){
                    textField1.setText("请输入消费项名称");
                    textField1.setForeground(new Color(204, 204, 204));
                }
            }
        });
        add(search);
        search.setBounds(new Rectangle(new Point((int) (panel.getWidth()*0.42), (int) (panel.getHeight()*0.1)), search.getPreferredSize()));
        search.addActionListener(e -> {
            if (textField1.getText().equals("请输入消费项名称")) {
                List<Tbservices> tbservices = tbservicesDao.queryAll();
                showTable(tbservices);
            }else {
                List<Tbservices> tbservices = tbservicesDao.queryByName(textField1.getText());
                showTable(tbservices);
            }


        });

        scrollPane1.setOpaque(false);
        scrollPane1.getViewport().setOpaque(false);

        table1.setOpaque(false);
        //        设置表格内容居中,透明
        DefaultTableCellRenderer dc=new DefaultTableCellRenderer();
        dc.setHorizontalAlignment(SwingConstants.CENTER);
        table1.setDefaultRenderer(Object.class,dc);




        List<Tbservices> tbservices = tbservicesDao.queryAll();
        showTable(tbservices);

        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public ConsumerMaintenance() {

    }

    public void showTable(List<Tbservices> tbservices) {
        //        ----table1----
        table1.validate();

        String[] index = {"序号", "消费项", "单价", "会员价"};

        Object[][] objects = new Object[tbservices.size()][index.length];
        for (int i = 0; i < objects.length; i++) {
            Tbservices tbservices1 = tbservices.get(i);
            objects[i][0] = tbservices1.getSerId();
            objects[i][1] = tbservices1.getSerName();
            objects[i][2] = tbservices1.getSerPrice();
            objects[i][3] = tbservices1.getSerMemprice();
        }
        DefaultTableModel defaultTableModel = new DefaultTableModel(objects, index);
        table1.setModel(defaultTableModel);
        table1.setFont(new customFont(16f, "Alibaba-PuHuiTi-Bold.ttf").getFont());
        table1.setForeground(Color.BLACK);


    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton insert;
    private JButton modify;
    private JButton delete;
    private JScrollPane scrollPane1;
    public JTable table1= new JTable(){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };;
    private JTextField textField1;
    private JButton search;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(im, 0, 0, this.getWidth(), this.getHeight(),this);
    }
    Image im ;



}

 class addConsume extends JFrame {
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JTextField sername;
    private JTextField price;
    private JTextField memberprice;
    private JButton add;
    private JButton dispose;


    public addConsume() {
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
        sername = new JTextField();
        price = new JTextField();
        memberprice = new JTextField();
        add = new JButton();
        dispose = new JButton();
        //---- label1 ----
        label1.setText("\u6dfb\u52a0\u6d88\u8d39\u9879");
        label1.setIcon(new ImageIcon(getClass().getResource("/picture/LibraryManage.png")));
        label1.setHorizontalAlignment(SwingConstants.LEFT);
        add(label1);
        label1.setBounds(125, 30, 255, 70);

        //---- label2 ----
        label2.setText("\u6d88\u8d39\u9879");
        add(label2);
        label2.setBounds(new Rectangle(new Point(65, 125), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("\u5355\u4ef7");
        add(label3);
        label3.setBounds(65, 175, 36, 17);

        //---- label4 ----
        label4.setText("\u4f1a\u5458\u4ef7");
        add(label4);
        label4.setBounds(65, 225, 36, 17);
        add(sername);
        sername.setBounds(140, 120, 170, sername.getPreferredSize().height);
        add(price);
        price.setBounds(140, 170, 170, 30);
        add(memberprice);
        memberprice.setBounds(140, 220, 170, 30);

        //---- add ----
        add.setText("添加");
        add(add);
        add.addActionListener(e -> {
            Tbservices tbservices = new Tbservices();
            tbservices.setSerName(sername.getText());
            tbservices.setSerPrice(Double.parseDouble(price.getText()));
            tbservices.setSerMemprice(Double.parseDouble(memberprice.getText()));
            int insert = ConsumerMaintenance.tbservicesDao.insert(tbservices);
            if (insert != 0) {
                new RemainUI("提示", "成功");

                dispose();
            }else {
                new RemainUI("提示", "失败");

            }
        });
        add.setBounds(new Rectangle(new Point(65, 280), add.getPreferredSize()));

        //---- dispose ----
        dispose.setText("取消");
        add(dispose);
        dispose.addActionListener(e -> {
            dispose();
        });
        dispose.setBounds(230, 280, 78, 30);

    }
}
class modifyConsume extends JFrame {
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JTextField sername;
    private JTextField price;
    private JTextField memberprice;
    private JButton modify;
    private JButton dispose;


    public modifyConsume(Tbservices tbservices) {
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
        sername = new JTextField();
        price = new JTextField();
        memberprice = new JTextField();
        modify = new JButton();
        dispose = new JButton();
        //---- label1 ----
        label1.setText("\u6dfb\u52a0\u6d88\u8d39\u9879");
        label1.setIcon(new ImageIcon(getClass().getResource("/picture/LibraryManage.png")));
        label1.setHorizontalAlignment(SwingConstants.LEFT);
        jPanel.add(label1);
        label1.setBounds(125, 30, 255, 70);

        //---- label2 ----
        label2.setText("\u6d88\u8d39\u9879");
        jPanel.add(label2);
        label2.setBounds(new Rectangle(new Point(65, 125), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("\u5355\u4ef7");
        jPanel.add(label3);
        label3.setBounds(65, 175, 36, 17);

        //---- label4 ----
        label4.setText("\u4f1a\u5458\u4ef7");
        jPanel.add(label4);
        label4.setBounds(65, 225, 36, 17);
        jPanel.add(sername);
        sername.setBounds(140, 120, 170, sername.getPreferredSize().height);
        jPanel.add(price);
        price.setBounds(140, 170, 170, 30);
        jPanel.add(memberprice);
        memberprice.setBounds(140, 220, 170, 30);


//        给每个textfield赋值
        sername.setText(tbservices.getSerName());
        price.setText( tbservices.getSerPrice().toString());
        memberprice.setText(tbservices.getSerMemprice().toString());
        //---- add ----
        modify.setText("修改");
        jPanel.add(modify);
        modify.addActionListener(e -> {
            Tbservices tbservices1 = new Tbservices();
            tbservices1.setSerName(sername.getText());
            tbservices1.setSerPrice(Double.parseDouble(price.getText()));
            tbservices1.setSerMemprice(Double.parseDouble(memberprice.getText()));
            tbservices1.setSerId(tbservices.getSerId());
            int insert = ConsumerMaintenance.tbservicesDao.update(tbservices1);
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