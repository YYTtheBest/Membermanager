package View.Main.CardLayout;

import Utils.customFont;
import View.Main.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class MemberManagerAndConsume extends JPanel {
    Image im ;
    private Font font;

    public MemberManagerAndConsume(JPanel jPanel1) {
        Image image = Toolkit.getDefaultToolkit().getImage("src/main/resources/static/fore6.jpg");
        this.im = image;
        //希望该Panel的大小事自适应的
        int width = jPanel1.getWidth();
        int height = jPanel1.getHeight();
        this.setSize(width,height);
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        Member = new JButton("会员管理");
        Consume = new JButton("消费结算");

        //======== this ========
        setLayout(null);

        //---- Member ----

        Font font1 = new customFont(60f,"superBlack.ttf").getFont();
        Member.setFont(font1);
        Member.setBackground(new Color(176, 84, 251));
        Member.setForeground(Color.white);
        add(Member);
        Member.setBounds((int) (jPanel1.getWidth()*0.28), (int) (jPanel1.getHeight()*0.25), 400,100);
Member.addActionListener(e -> {
    MainFrame.cardLayout.show(MainFrame.card,"2-1");
});

        Consume.setFont(font1);
        Consume.setBackground(new Color(176, 84, 251));
        Consume.setForeground(Color.white);

        add(Consume);
        Consume.setBounds((int) (jPanel1.getWidth()*0.28), (int) (jPanel1.getHeight()*0.55), 400,100);
        Consume.addActionListener(e -> {

            MainFrame.cardLayout.show(MainFrame.card, "2-2");
        });
        setVisible(true);
        setBounds(0,0,(int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 270), (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 50));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton Member;
    private JButton Consume;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    @Override
    protected void paintComponent(Graphics g) {
        // 清屏
        super.paintComponent(g);
        g.drawImage(im, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}


