/*
 * Created by JFormDesigner on Fri Jun 10 19:19:32 CST 2022
 */

package View.Login;

import View.Main.MainFrame;
import View.RemainUI;
import com.formdev.flatlaf.FlatIntelliJLaf;
import dao.Impl.TbiemployeeDaoImpl;
import dao.TbiemployeeDao;
import entity.Tbiemployee;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 * @author unknown
 */
public class Login extends JPanel{
    private JLabel jIcon;
        private JTextField username;
        private JPasswordField password;

        public Login(JFrame jFrame) {
            setBackground(new Color(245, 255, 250));
            setLayout(null);
            setSize(984, 550);
            // 放置LOGO
            ImageIcon icon = new ImageIcon("src/main/resources/picture/logo177.png");
            jIcon = new JLabel(icon);
            jIcon.setBounds(195, 216, 177, 177);
            this.add(jIcon);
// 放置登录
            ImageIcon icos = new ImageIcon("src/main/resources/picture/login2.png");
            JLabel lblLoginIcon = new JLabel(icos);
            lblLoginIcon.setBounds(534, 189, 58, 32);
            this.add(lblLoginIcon);
            // 放置账号图
            ImageIcon iconUser = new ImageIcon("src/main/resources/picture/toplion图标库 _登录头像.png");
            iconUser.setImage(iconUser.getImage().getScaledInstance(32, 32, Image.SCALE_AREA_AVERAGING));
            JLabel lblAccount = new JLabel(iconUser);
            lblAccount.setBounds(425, 232, 32, 32);
            this.add(lblAccount);
            // 放置密码图
            ImageIcon iconPassword = new ImageIcon("src/main/resources/picture/密码.png");
            iconPassword.setImage(iconPassword.getImage().getScaledInstance(32, 32, Image.SCALE_AREA_AVERAGING));
            JLabel lblPassword = new JLabel(iconPassword);
            lblPassword.setBounds(425, 286, 32, 32);
            this.add(lblPassword);
            // 账号输入框
            username = new JTextField();
            username.setBounds(467, 231, 200, 35);
            this.add(username);
            username.setColumns(10);
            // 文本输入框
            password = new JPasswordField();
            password.setBounds(467, 285, 200, 35);
            this.add(password);

            // 分隔线
            JSeparator separator = new JSeparator();
            separator.setOrientation(SwingConstants.VERTICAL);// 设置分割线竖直
            separator.setBackground(SystemColor.activeCaption);
            separator.setBounds(400, 104, 1, 400);
            this.add(separator);

            // 登录按钮
            JButton btnLogin = new JButton("\u767B\u5F55");
            btnLogin.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    String UserName = username.getText();
                    String UserPwd = String.valueOf(password.getPassword());
//                    int userName = 0;
//                    System.out.println(isNumeric(UserName));
//                    boolean isNumber = isNumeric(UserName);
//
//                    if (isNumber && !"".equals(UserName)) {
//                        userName = Integer.valueOf(UserName);
//                    }


                    TbiemployeeDao tbiemployeeDao = new TbiemployeeDaoImpl();
                    Boolean isTrue = false;

                    Tbiemployee tbiemployee = tbiemployeeDao.queryById(UserName, UserPwd);
                    if (tbiemployee != null) {
                        isTrue = true;
                    }
                    if (UserName .equals("")) {
                        RemainUI ra = new RemainUI("提示", "您输入的账号不正确");
                        ra.setVisible(true);
                        username.setText("");

                        password.setText("");
                    } else if ("".equals(UserPwd)) {
                        JOptionPane.showMessageDialog(null, "请输入密码");
                    } else if (!isTrue) {
                        JOptionPane.showMessageDialog(null, "您输入的用户名或密码有误,请重新输入");
                        username.setText("");
                        password.setText("");
                    } else {
                        new MainFrame(tbiemployee.getEmName());


                        jFrame.dispose();

                    }


                }
            });
            btnLogin.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    btnLogin.setBackground(new Color(154, 205, 50));
                    btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    btnLogin.setBackground(new Color(50, 205, 50));
                }
            });

            btnLogin.setFont(new Font("微软雅黑", Font.PLAIN, 12));
            btnLogin.setBackground(new Color(50, 205, 50));
            btnLogin.setBounds(467, 330, 200, 35);
            this.add(btnLogin);




            setVisible(true);

        }
//        // 判断是否是数字
//        public static boolean isNumeric(String str) {
//            for (int i = str.length(); --i >= 0;) {
//                if (!Character.isDigit(str.charAt(i))) {
//                    return false;
//                }
//            }
//            return true;
//        }

        public Login() {

            JFrame jFrame = new JFrame();

            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jFrame.setBounds(100, 100, 1000, 633);
            jFrame.setLayout(null);
            Login loginUI = new Login(jFrame);
            jFrame.add(loginUI);
            jFrame.setVisible(true);

        }
}
