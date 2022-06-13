package View.Main;

import View.Main.CardLayout.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {
    private String LoginUser;

    public void setLoginUser(String loginUser) {
        LoginUser = loginUser;
    }

    private JPanel contentPane;
    public static JPanel card;
    public static CardLayout cardLayout;

    /**
     *
     * @param LoginUser 传入登录者姓名
     */
    public MainFrame(String LoginUser) {

        setBackground(new Color(255, 255, 255));

        setTitle("会员管理系统V1.0");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setSize(1080,720);
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setVisible(true);
        contentPane = new JPanel();
        contentPane.setOpaque(false);
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);


        JPanel panel = new JPanel() ;
//        {
//            @Override
//            protected void paintComponent(Graphics g) {
////                ImageIcon icon =
////                        new ImageIcon("src//main//resources//static//fore5.jpg");
////                // 图片随窗体大小而变化
////                g.drawImage(icon.getImage(), 0, 0, this.getSize().width,this.getSize().height,this);
////            }
////        };
//            }
//        };

        panel.setBorder(new RoundBoard(new Color(83, 172, 224)));
        panel.setBounds(0, 0, 250, Toolkit.getDefaultToolkit().getScreenSize().height - 50);
        contentPane.add(panel);
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
//左侧panel，上半部分

//用于显示登录者的名字
        JLabel lbladmin = new JLabel();
        lbladmin.setText("您好，"+LoginUser);
        System.out.println(LoginUser);
        lbladmin.setBounds(70, 215, 100, 15);
        panel.add(lbladmin);
//        lbladmin.setForeground(SystemColor.windowBorder);
//        lbladmin.setFont(new Font("宋体", Font.PLAIN, 18));

        JLabel ImageLabel = new JLabel();
        ImageIcon icon = new ImageIcon("src/main/resources/picture/header.png");
        ImageLabel.setIcon(icon);
        ImageLabel.setBounds(40, 20, 172, 172);
        panel.add(ImageLabel);
////        ImageLabel.setForeground(SystemColor.windowBorder);
//        ImageLabel.setFont(new Font("宋体", Font.PLAIN, 13));

        JPanel line = new JPanel();
        line.setBounds(0, 252, 250, 3);
        panel.add(line);
        line.setBackground(Color.LIGHT_GRAY);

//侧边栏所需规范元素
//        Font font = new Font("微软雅黑", 0, 20);
//        new Color();

//        侧边栏按钮第一个
        JPanel memberAdd = new JPanel();
        memberAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                memberAdd.setBackground(new Color(26, 188, 156));
                memberAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                memberAdd.setBackground(Color.white);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(card,"1");
                repaint();
            }
        });
        memberAdd.setBackground(Color.WHITE);
        memberAdd.setBounds(0, 255, 249, 44);
        panel.add(memberAdd);
        memberAdd.setLayout(null);
        JLabel insert = new JLabel("会员信息录入");
        insert.setBounds(80, -5, 250, 50);
//        insert.setFont(font);
        memberAdd.add(insert);

        ImageIcon imageMemberadd = new ImageIcon("src/main/resources/picture/会员.png");
        imageMemberadd.setImage(imageMemberadd.getImage().getScaledInstance(40,40,Image.SCALE_AREA_AVERAGING));

        JLabel MemberaddImage = new JLabel();
        MemberaddImage.setIcon(imageMemberadd);
        MemberaddImage.setBorder(BorderFactory.createEmptyBorder());
        MemberaddImage.setBounds(5, 0, 40, 40);
        memberAdd.add(MemberaddImage);

//侧边栏按钮第二个
        JPanel consume = new JPanel();
        consume.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                consume.setBackground(new Color(26, 188, 156));
                consume.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                consume.setBackground(Color.white);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(card,"2");
                repaint();
            }
        });
        consume.setBackground(Color.WHITE);
        consume.setBounds(0, 300, 249, 44);
        panel.add(consume);
        consume.setLayout(null);
        JLabel consumeLable = new JLabel("会员管理&消费结算");
        consumeLable.setBounds(80, -5, 250, 50);
//        maintenancelable.setFont(font);
        consume.add(consumeLable);

        ImageIcon consumeImage = new ImageIcon("src/main/resources/picture/消费.png");
        consumeImage.setImage(consumeImage.getImage().getScaledInstance(40,40,Image.SCALE_AREA_AVERAGING));

        JLabel consumeImagelable = new JLabel();
        consumeImagelable.setIcon(consumeImage);
        consumeImagelable.setBorder(BorderFactory.createEmptyBorder());
        consumeImagelable.setBounds(5, 0, 40, 40);
        consume.add(consumeImagelable);

//侧边栏按钮第三个
        JPanel maintenance = new JPanel();
        maintenance.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                maintenance.setBackground(new Color(26, 188, 156));
                maintenance.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                maintenance.setBackground(Color.white);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(card,"4");
                repaint();
            }
        });
        maintenance.setBackground(Color.WHITE);
        maintenance.setBounds(0, 349, 249, 44);
        panel.add(maintenance);
        maintenance.setLayout(null);
        JLabel maintenancelable = new JLabel("消费项维护");
        maintenancelable.setBounds(80, -5, 250, 50);
//        maintenancelable.setFont(font);
        maintenance.add(maintenancelable);

        ImageIcon maintenanceImage = new ImageIcon("src/main/resources/picture/维护.png");
        maintenanceImage.setImage(maintenanceImage.getImage().getScaledInstance(40,40,Image.SCALE_AREA_AVERAGING));

        JLabel maintenanceImagelable = new JLabel();
        maintenanceImagelable.setIcon(maintenanceImage);
        maintenanceImagelable.setBorder(BorderFactory.createEmptyBorder());
        maintenanceImagelable.setBounds(5, 0, 40, 40);
        maintenance.add(maintenanceImagelable);
//左侧第四个
//        JPanel consume = new JPanel();
//        consume.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                consume.setBackground(new Color(26, 188, 156));
//                consume.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                consume.setBackground(Color.white);
//            }
//
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                cardLayout.show(card,"3");
//                repaint();
//            }
//        });
//        consume.setBackground(Color.WHITE);
//        consume.setBounds(0, 398, 249, 44);
//        panel.add(consume);
//        consume.setLayout(null);
//        JLabel consumeLable = new JLabel("会员管理&消费结算");
//        consumeLable.setBounds(80, -5, 250, 50);
////        maintenancelable.setFont(font);
//        consume.add(consumeLable);
//
//        ImageIcon consumeImage = new ImageIcon("src/main/resources/picture/消费.png");
//        consumeImage.setImage(consumeImage.getImage().getScaledInstance(40,40,Image.SCALE_AREA_AVERAGING));
//
//        JLabel consumeImagelable = new JLabel();
//        consumeImagelable.setIcon(consumeImage);
//        consumeImagelable.setBorder(BorderFactory.createEmptyBorder());
//        consumeImagelable.setBounds(5, 0, 40, 40);
//        consume.add(consumeImagelable);



//左侧第五个
        JPanel statistics = new JPanel();
        statistics.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                statistics.setBackground(new Color(26, 188, 156));
                statistics.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                statistics.setBackground(Color.white);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(card,"3");
                repaint();
            }
        });
        statistics.setBackground(Color.WHITE);
        statistics.setBounds(0, 436, 249, 44);
        panel.add(statistics);
        statistics.setLayout(null);
        JLabel statisticslable = new JLabel("数据统计");
        statisticslable.setBounds(80, -5, 250, 50);
//        maintenancelable.setFont(font);
        statistics.add(statisticslable);

        ImageIcon statisticsImage = new ImageIcon("src/main/resources/picture/Nimbers表格.png");
        statisticsImage.setImage(statisticsImage.getImage().getScaledInstance(40,40,Image.SCALE_AREA_AVERAGING));

        JLabel statisticsImagelable = new JLabel();
        statisticsImagelable.setIcon(statisticsImage);
        statisticsImagelable.setBorder(BorderFactory.createEmptyBorder());
        statisticsImagelable.setBounds(5, 0, 40, 40);
        statistics.add(statisticsImagelable);

//        中间的卡片布局
         cardLayout = new CardLayout();
         card = new JPanel(cardLayout);


        card.setBounds(250,0,(int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth()), (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight()-50));
//        card.setBounds(250,0,1080, 720-50);
        Default aDefault = new Default(card);
        AddMember addMember = new AddMember(card);
        ConsumerMaintenance consumerMaintenance = new ConsumerMaintenance(card);
        MemberManagerAndConsume memberManagerAndConsume = new MemberManagerAndConsume(card);
        MemberManager memberManager = new MemberManager(card);
        ConsumeManager consumeManager = new ConsumeManager(card);
        Statistical statistical = new Statistical(card);
        card.add(consumerMaintenance, "4");
        card.add(aDefault,"0");

//        card.add(aDefault, "1");
        card.add(addMember,"1");
        card.add( memberManagerAndConsume,"2");
        card.add( memberManager,"2-1");
        card.add( consumeManager,"2-2");
        card.add( statistical,"3");
//        card.setLayout(cardLayout);

        System.out.println(1);
        cardLayout.show(card, "0");
        repaint();

        contentPane.add(card);



    }


}