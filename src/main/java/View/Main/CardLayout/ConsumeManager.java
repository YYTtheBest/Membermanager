/*
 * Created by JFormDesigner on Sat Jun 11 23:37:01 CST 2022
 */

package View.Main.CardLayout;

import Utils.customFont;
import View.RemainUI;
import dao.Impl.TbconsumeDaoImpl;
import dao.Impl.TbimemberDaoImpl;
import dao.Impl.TbservicesDaoImpl;
import dao.TbconsumeDao;
import dao.TbimemberDao;
import dao.TbservicesDao;
import entity.TbConsume_NameAndPrivce;
import entity.Tbconsume;
import entity.Tbimember;
import entity.Tbservices;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author unknown
 */
public class ConsumeManager extends JPanel {
    private Font lableFont = new customFont(16,"Alibaba-PuHuiTi-Bold.ttf").getFont();

    private Boolean isMember = false;
    private List<TbConsume_NameAndPrivce> nameAndPriceArrayList = new ArrayList<>();
    private Object[][] consumeList = new Object[0][2];
    private List<Object[][]> consumeListTotal = new ArrayList<>();


    public ConsumeManager(JPanel jPanel) {

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        inputMember = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        List = new JComboBox();
        add = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        name = new JLabel();
        label3 = new JLabel();
        phoneNumber = new JLabel();
        label4 = new JLabel();
        money = new JLabel();
        label5 = new JLabel();
        bill = new JLabel();
        pay = new JButton();

        //======== this ========
        setLayout(null);

        //---- inputMember ----
        inputMember.setText("会员录入");
        add(inputMember);
        inputMember.setBounds((int) (jPanel.getWidth()*0.2196), (int) (jPanel.getHeight()*0.137), 85, 45);
        inputMember.addActionListener(e -> {
            String inpupt = JOptionPane.showInputDialog(null, "请输入电话或姓名");
            TbimemberDao tbimemberDao = new TbimemberDaoImpl();
            Tbimember tbimember = tbimemberDao.MemberSelect(inpupt);
            if (tbimember == null) {
                new RemainUI("提示", "没有找到会员信息");
                name.setText("");
                phoneNumber.setText("");
                money.setText("");
            } else {
                setMemberInfo(tbimember);
                isMember = true;
                setList();
            }
        });

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        add(scrollPane1);
        scrollPane1.setBounds((int) (jPanel.getWidth()*0.2006), (int) (jPanel.getHeight()*0.221), 690, scrollPane1.getPreferredSize().height);
//        ----list----
        setList();
        add(List);
        List.setBounds((int) (jPanel.getWidth()*0.3056), (int) (jPanel.getHeight()*0.14), 145, 35);

        //---- add ----
        add.setText("添加");
        add(add);
        add.setBounds((int) (jPanel.getWidth()*0.421), (int) (jPanel.getHeight()*0.137),90, 40);
        add.addActionListener(e -> {

//            循环叠加
            int selectedIndex = List.getSelectedIndex();
            Object[][] swap = new Object[1][2];
            swap[0][0]=nameAndPriceArrayList.get(selectedIndex).getName();
            swap[0][1]=nameAndPriceArrayList.get(selectedIndex).getPrice();
            consumeListTotal.add(swap);
            consumeList = new Object[consumeListTotal.size()][2];
            System.out.println(consumeList.length);
            for (int i = 0; i < consumeListTotal.size(); i++) {
                consumeList[i][0]=consumeListTotal.get(i)[0][0];
                consumeList[i][1]=consumeListTotal.get(i)[0][1];
            }

            Double billmoney = 0.0;
            for (int i = 0; i < consumeListTotal.size(); i++) {
                Object o = consumeListTotal.get(i)[0][1];
                billmoney += (Double)o;
            }
            bill.setText(String.valueOf(billmoney));
            showTable();

        });

        //---- label1 ----
        label1.setText("会员信息");
        add(label1);
        label1.setFont(lableFont);
        label1.setBounds(new Rectangle(new Point((int) (jPanel.getWidth()*0.2196), (int) (jPanel.getHeight()*0.73)), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("姓名:");
        add(label2);
        label2.setFont(lableFont);
        label2.setBounds((int) (jPanel.getWidth()*0.2196), (int) (jPanel.getHeight()*0.78),65, 20);
        add(name);
        name.setFont(lableFont);
        name.setBounds((int) (jPanel.getWidth()*0.2496), (int) (jPanel.getHeight()*0.78), 50, 20);

        //---- label3 ----
        label3.setText("手机号码:");
        add(label3);
        label3.setFont(lableFont);
        label3.setBounds((int) (jPanel.getWidth()*0.2996), (int) (jPanel.getHeight()*0.78), 70, 20);
        phoneNumber.setFont(lableFont);
        add(phoneNumber);
        phoneNumber.setBounds((int) (jPanel.getWidth()*0.3496), (int) (jPanel.getHeight()*0.78), 115, 20);

        //---- label4 ----
        label4.setText("余额：");
        add(label4);
        label4.setFont(lableFont);
        label4.setBounds((int) (jPanel.getWidth()*0.4266), (int) (jPanel.getHeight()*0.78), 55, 20);
        add(money);
        money.setFont(lableFont);
        money.setBounds((int) (jPanel.getWidth()*0.4556), (int) (jPanel.getHeight()*0.78), 60, 20);

        //---- label5 ----
        label5.setText("本次消费金额：");
        add(label5);
        label5.setFont(lableFont);
        label5.setBounds((int) (jPanel.getWidth()*0.4966), (int) (jPanel.getHeight()*0.78), 120, 20);
        add(bill);
        bill.setFont(lableFont);
        bill.setBounds((int) (jPanel.getWidth()*0.5666), (int) (jPanel.getHeight()*0.78), 55, 20);

//        ----table----
        showTable();

// TODO: 2022/6/12 显示消费完的余额
        //---- pay ----
        pay.setText("结账");
        pay.setFont(pay.getFont().deriveFont(pay.getFont().getStyle() & ~Font.BOLD, pay.getFont().getSize() + 5f));
        add(pay);
        pay.setBounds((int) (jPanel.getWidth()*0.5966), (int) (jPanel.getHeight()*0.73), 70, 55);
        pay.addActionListener(e -> {
            if (isMember) {
                if (Double.parseDouble(money.getText()) >= Double.parseDouble(bill.getText())) {
                    TbimemberDaoImpl tbimemberDao = new TbimemberDaoImpl();
                    tbimemberDao.pay(name.getText(), phoneNumber.getText(), Double.valueOf(bill.getText()));
                    Long ConBill =Long.parseLong(new SimpleDateFormat("yyyyMMddhh").format(new Date()));


                    TbconsumeDao tbconsumeDao = new TbconsumeDaoImpl();
                    Tbconsume tbconsume = new Tbconsume();

                    consumeList = new Object[consumeListTotal.size()][2];
                    System.out.println(consumeList.length);
                    for (int i = 0; i < consumeListTotal.size(); i++) {
                        tbconsume.setConSername((String) (consumeList[i][0] = consumeListTotal.get(i)[0][0]));
                        tbconsume.setConPrice((Double) (consumeList[i][1]=consumeListTotal.get(i)[0][1]));
                    }

                    tbconsume.setConMemname(name.getText());
                    tbconsume.setConDate(new Date());
                    tbconsume.setConBill(ConBill);

                    tbconsumeDao.insert(tbconsume);
                    consumeList = new Object[0][0];
                    showTable();
                    new RemainUI("提示", "交易成功");
                    bill.setText("");

                } else {
                    RemainUI remainUI = new RemainUI("提示", "余额不足，请充值");
                }
            }else {
                Long ConBill =Long.parseLong(new SimpleDateFormat("yyyyMMddhh").format(new Date()));
                System.out.println(ConBill);
                TbconsumeDao tbconsumeDao = new TbconsumeDaoImpl();
                Tbconsume tbconsume = new Tbconsume();

                consumeList = new Object[consumeListTotal.size()][2];
                System.out.println(consumeList.length);
                for (int i = 0; i < consumeListTotal.size(); i++) {
                    tbconsume.setConSername((String) (consumeList[i][0] = consumeListTotal.get(i)[0][0]));
                    tbconsume.setConPrice((Double) (consumeList[i][1]=consumeListTotal.get(i)[0][1]));
                }
                tbconsume.setConDate(new Date());
                tbconsume.setConBill(ConBill);

                int insert = tbconsumeDao.insert(tbconsume);
                System.out.println(insert);
                consumeList = new Object[0][0];
                showTable();
                bill.setText("");
                new RemainUI("提示", "交易成功");

            }

        });

        setBounds(0, 0, jPanel.getWidth(), jPanel.getHeight());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private void showTable() {
        table1.validate();
        String[] index = {"名称", "价格"};
        DefaultTableModel defaultTableModel = new DefaultTableModel(consumeList, index);
        table1.setModel(defaultTableModel);
    }

    private void setList() {
        TbservicesDao tbservicesDao = new TbservicesDaoImpl();
        List<Tbservices> tbservices = tbservicesDao.queryAll();
        nameAndPriceArrayList.clear();
        for (int i = 0; i < tbservices.size(); i++) {

            if (isMember) {
                TbConsume_NameAndPrivce tbConsume_nameAndPrivce = new TbConsume_NameAndPrivce(tbservices.get(i).getSerId(), tbservices.get(i).getSerName(), tbservices.get(i).getSerMemprice());
                nameAndPriceArrayList.add(tbConsume_nameAndPrivce);
            }else {
                TbConsume_NameAndPrivce tbConsume_nameAndPrivce = new TbConsume_NameAndPrivce(tbservices.get(i).getSerId(), tbservices.get(i).getSerName(), tbservices.get(i).getSerPrice());
                nameAndPriceArrayList.add(tbConsume_nameAndPrivce);
            }

        }
        String[] index=new String[nameAndPriceArrayList.size()];
        for (int i = 0; i < nameAndPriceArrayList.size(); i++) {
            index[i] = nameAndPriceArrayList.get(i).getName();
        }
        for (int i = 0; i < index.length; i++) {
            List.addItem(index[i]);
        }
    }

    public static void setMemberInfo(Tbimember t) {
        name.setText(t.getMName());
        phoneNumber.setText(t.getMPhone());
        money.setText(String.valueOf(t.getMMoney()));

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton inputMember;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JComboBox List;
    private JButton add;
    private JLabel label1;
    private JLabel label2;
    private static JLabel name;
    private JLabel label3;
    private static JLabel phoneNumber;
    private JLabel label4;
    private static JLabel money;
    private JLabel label5;
    private static JLabel bill;
    private JButton pay;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
