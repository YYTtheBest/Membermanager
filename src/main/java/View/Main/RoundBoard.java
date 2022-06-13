package View.Main;

import javax.swing.border.Border;
import java.awt.*;

public class RoundBoard implements Border {
    private Color color;
    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.setColor(color);
        g.drawRoundRect(0, 0, c.getWidth() - 1, c.getHeight() - 1, 15, 15);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return null;
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }

    public RoundBoard(Color Color) {
        this.color = Color;


    }
}

