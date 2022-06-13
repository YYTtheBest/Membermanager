/*
 * Created by JFormDesigner on Fri Jun 10 22:01:07 CST 2022
 */

package View.Main.CardLayout;

import Utils.customFont;

import java.awt.*;
import javax.swing.*;

/**
 * @author unknown
 */
public class Default extends JPanel {
    Image im ;
    private Font font;

    public Default(JPanel jPanel1) {
        Image image = Toolkit.getDefaultToolkit().getImage("src/main/resources/static/fore2.jpg");
        this.im = image;
        //希望该Panel的大小事自适应的
        int width = jPanel1.getWidth();
        int height = jPanel1.getHeight();
        this.setSize(width,height);
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();

        //======== this ========
        setLayout(null);

        //---- label1 ----
        label1.setText("请从左侧选择功能");
        Font font1 = new customFont(70f,"Alibaba-PuHuiTi-Bold.ttf").getFont();
        label1.setFont(font1);
        label1.setForeground(new Color(232, 247, 247));
        add(label1);
        label1.setBounds(new Rectangle(new Point(95, 130), label1.getPreferredSize()));
        label1.setBounds(380,250,800,200);
        setVisible(true);
        setBounds(0,0,(int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 270), (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 50));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    @Override
    protected void paintComponent(Graphics g) {
        // 清屏
        super.paintComponent(g);
        g.drawImage(im, 0, 0, this.getWidth(), this.getHeight(), this);
    }

}
