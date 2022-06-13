package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RemainUI extends JDialog {

    private final JPanel contentPanel = new JPanel();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            RemainUI dialog = new RemainUI();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public RemainUI(String title, String contentLogo, String write, int x ) {
        this.setVisible(true);

        setTitle(title);

        setLOGO();// 更改图标
        setBackground(new Color(253, 245, 230));
        setBounds(100, 100, 490, 280);
        this.setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        contentPanel.setBounds(0, 0, 474, 241);
        contentPanel.setBackground(new Color(248, 248, 255));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel);
        contentPanel.setLayout(null);
        //提示性文字
        JLabel lblWrite = new JLabel(write);
        lblWrite.setFont(new Font("微软雅黑 Light", Font.BOLD, 12));
        lblWrite.setBounds(x, 113, 259, 38);
        contentPanel.add(lblWrite);

        JButton btnNewButton = new JButton("确定");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                btnNewButton.setBackground(new Color(0, 255, 255));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnNewButton.setBackground(new Color(127, 255, 212));
            }
        });
        btnNewButton.setFont(new Font("方正卡通简体", Font.PLAIN, 12));
        btnNewButton.setBackground(new Color(127, 255, 212));
        btnNewButton.setBounds(171, 175, 153, 45);
        contentPanel.add(btnNewButton);

        ImageIcon imageLOGO = new ImageIcon(contentLogo);
        JLabel lblLOGO = new JLabel(imageLOGO);
        lblLOGO.setBounds(0, 0, 474, 103);
        contentPanel.add(lblLOGO);

    }
    public RemainUI(String title, String write) {
        this.setVisible(true);

        setTitle(title);

        setLOGO();// 更改图标
        setBackground(new Color(253, 245, 230));
        setBounds(100, 100, 490, 280);
        this.setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        contentPanel.setBounds(0, 0, 474, 241);
        contentPanel.setBackground(new Color(248, 248, 255));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel);
        contentPanel.setLayout(null);
        //提示性文字
        JLabel lblWrite = new JLabel(write);
        lblWrite.setFont(new Font("微软雅黑 Light", Font.BOLD, 16));
        lblWrite.setBounds(174, 113, 207, 38);
        contentPanel.add(lblWrite);

        JButton btnNewButton = new JButton("\u786E\u5B9A");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                btnNewButton.setBackground(new Color(0, 255, 255));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnNewButton.setBackground(new Color(127, 255, 212));
            }
        });
        btnNewButton.setFont(new Font("方正卡通简体", Font.PLAIN, 16));
        btnNewButton.setBackground(new Color(127, 255, 212));
        btnNewButton.setBounds(158, 175, 153, 45);
        contentPanel.add(btnNewButton);

        ImageIcon imageLOGO = new ImageIcon("src/main/resources/picture/YellowHIte.jpg");
        JLabel lblLOGO = new JLabel(imageLOGO);
        lblLOGO.setBounds(0, 0, 474, 103);
        contentPanel.add(lblLOGO);

    }

    public RemainUI() {
        setComponent();

    }

    // 设置组件
    public void setComponent() {



        setTitle("提示");

        setLOGO();// 更改图标
        setBackground(new Color(253, 245, 230));
        setBounds(100, 100, 490, 280);
        this.setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        contentPanel.setBounds(0, 0, 474, 241);
        contentPanel.setBackground(new Color(248, 248, 255));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel);
        contentPanel.setLayout(null);

        JLabel lblWrite = new JLabel("您输入的信息不存在");
        lblWrite.setFont(new Font("微软雅黑 Light", Font.BOLD, 12));
        lblWrite.setBounds(174, 113, 207, 38);
        contentPanel.add(lblWrite);

        JButton btnNewButton = new JButton("确定");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);

            }
        });
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                btnNewButton.setBackground(new Color(0, 255, 255));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnNewButton.setBackground(new Color(127, 255, 212));
            }
        });
        btnNewButton.setFont(new Font("方正卡通简体", Font.PLAIN, 12));
        btnNewButton.setBackground(new Color(127, 255, 212));
        btnNewButton.setBounds(171, 175, 153, 45);
        contentPanel.add(btnNewButton);

        ImageIcon imageLOGO = new ImageIcon("src/main/resources/picture/YellowHIte.jpg");
        JLabel lblLOGO = new JLabel(imageLOGO);
        lblLOGO.setBounds(0, 0, 474, 103);
        contentPanel.add(lblLOGO);


    }

    // 设置logo
    public void setLOGO() {
        // 修改图标
        Toolkit tk = Toolkit.getDefaultToolkit();
        // 获取图片 三种图片格式都可以
        java.awt.Image img = tk.getImage("src/main/resources/picture/fox.png");
        // 给窗体设置图标
        this.setIconImage(img);

    }
}
