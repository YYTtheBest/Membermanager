/*
 * Created by JFormDesigner on Sun Jun 12 19:34:01 CST 2022
 */

package View.Main.CardLayout;

import Utils.customFont;
import dao.Impl.TbconsumeDaoImpl;
import dao.TbconsumeDao;
import entity.TbConsume_Total;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 * @author unknown
 */
public class Statistical extends JPanel {
    public static TbconsumeDao tbconsumeDao = new TbconsumeDaoImpl();
    public JTable table1 = new JTable() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    Image im;
    private Font buttonFont = new customFont(24, "Alibaba-PuHuiTi-Bold.ttf").getFont();

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTextField textField1;
    ;
    private JButton search;
    private JComboBox ListYear =new JComboBox();
    private JComboBox ListMonth =new JComboBox();

    public Statistical(JPanel panel) {
        Image image = Toolkit.getDefaultToolkit().getImage("src/main/resources/static/fore5.jpg");
        this.im = image;
        //希望该Panel的大小事自适应的
        int width = panel.getWidth();
        int height = panel.getHeight();
        this.setSize(width, height);
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents


        scrollPane1 = new JScrollPane();

        textField1 = new JTextField();
        search = new JButton();

        //======== this ========
        setLayout(null);
        setBounds(0, 0, panel.getWidth(), panel.getHeight());
        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        add(scrollPane1);
        scrollPane1.setBounds(0, (int) (this.getHeight() * 0.25), panel.getWidth() - 250, panel.getHeight());
//        ----ListYear----
        add(ListYear);
        ListYear.addItem("2018");
        ListYear.addItem("2019");
        ListYear.addItem("2020");
        ListYear.addItem("2021");
        ListYear.addItem("2022");
        ListYear.setBounds((int) (this.getWidth() * 0.25), (int) (this.getHeight() * 0.1), 95, 35);
//        ----ListMonth----
        add(ListMonth);
        ListMonth.addItem("1");
        ListMonth.addItem("2");
        ListMonth.addItem("3");
        ListMonth.addItem("4");
        ListMonth.addItem("5");
        ListMonth.addItem("6");
        ListMonth.addItem("7");
        ListMonth.addItem("8");
        ListMonth.addItem("9");
        ListMonth.addItem("10");
        ListMonth.addItem("11");
        ListMonth.addItem("12");
        ListMonth.setBounds((int) (this.getWidth() * 0.33), (int) (this.getHeight() * 0.1), 65, 35);


        //---- search ----
        search.setText("搜索");
        add(search);
        search.setBounds(new Rectangle(new Point((int) (panel.getWidth() * 0.4), (int) (panel.getHeight() * 0.1)), search.getPreferredSize()));
        search.addActionListener(e -> {
            List<TbConsume_Total> tbConsume_totals = tbconsumeDao.QueryTotal(Integer.parseInt((String) ListYear.getSelectedItem()) , Integer.parseInt((String) ListMonth.getSelectedItem()));
            showTable(tbConsume_totals);
        });

        scrollPane1.setOpaque(false);
        scrollPane1.getViewport().setOpaque(false);

        table1.setOpaque(false);
        //        设置表格内容居中,透明
        DefaultTableCellRenderer dc = new DefaultTableCellRenderer();
        dc.setHorizontalAlignment(SwingConstants.CENTER);
        table1.setDefaultRenderer(Object.class, dc);


        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public void showTable(List<TbConsume_Total> tbConsume) {
        //        ----table1----
        table1.validate();

        String[] index = {"消费项", "会员", "非会员", "总金额"};

        Object[][] objects = new Object[tbConsume.size()][index.length];
        for (int i = 0; i < objects.length; i++) {
            TbConsume_Total tbConsume_Total = tbConsume.get(i);
            objects[i][0] = tbConsume_Total.getCon_sername();
            objects[i][1] = tbConsume_Total.getMemberPrice();
            objects[i][2] = tbConsume_Total.getUserPrice();
            objects[i][3] = tbConsume_Total.getTotalPrice();
        }
        DefaultTableModel defaultTableModel = new DefaultTableModel(objects, index);
        table1.setModel(defaultTableModel);
        table1.setFont(new customFont(16f, "Alibaba-PuHuiTi-Bold.ttf").getFont());
        table1.setForeground(Color.BLACK);


    }

    // JFormDesigner - End of variables declaration  //GEN-END:variables
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(im, 0, 0, this.getWidth(), this.getHeight(), this);
    }
// TODO: 2022/6/12 金额统计到此表
}
