/*
 * Created by JFormDesigner on Fri Jun 10 21:43:38 CST 2022
 */

package View;

import java.awt.*;
import javax.swing.*;

/**
 * @author unknown
 */
public class Test extends JFrame {
    public Test() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        separator1 = new JSeparator();
        label1 = new JLabel();

        //======== this ========
        setBackground(Color.black);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        contentPane.add(separator1);
        separator1.setBounds(75, 40, separator1.getPreferredSize().width, 88);

        //---- label1 ----
        label1.setText("text");
        label1.setBackground(Color.black);
        contentPane.add(label1);
        label1.setBounds(25, 100, 430, 25);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JSeparator separator1;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
