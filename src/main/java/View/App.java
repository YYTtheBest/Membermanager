package View;

import View.Login.Login;
import View.Main.MainFrame;
import com.formdev.flatlaf.FlatIntelliJLaf;

import javax.swing.*;


public class App {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }




        UIManager.put("TextComponent.arc", 5);
        UIManager.put("Button.arc", 5);
        UIManager.put("Component.arrowType","chevron");
        UIManager.put("ScrollBar.thumbArc",3);
//        new MainFrame("梁思裕");
                 new Login();

    }
}
