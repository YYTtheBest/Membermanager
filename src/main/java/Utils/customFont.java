package Utils;

import View.App;

import java.awt.*;
import java.io.IOException;

public class customFont {

    private Font font;

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    /**
     * 自定义字体，可以选择为阿里巴巴普惠或者站酷，传入字体大小的参数，调用getFont获取字体
     * @param size 字体大小
     * @param fontName 字体名称，需要包含后缀
     */
    public customFont(float size,String fontName) {
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, App.class.getResource("/" + fontName).openStream());
//            打印字体名称
//            String family = font.getFontName();
//            System.out.println(family);

        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();

        genv.registerFont(font);
        this.font = font.deriveFont(size);
    }

    public static void main(String[] args) {

    }
}
