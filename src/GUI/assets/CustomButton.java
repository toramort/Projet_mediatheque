package GUI.assets;

import resources.images.GetIcon;

import javax.swing.*;
import java.awt.*;

public class CustomButton extends JButton {

    public static JButton flatButtonWhite(String text) {
        JButton butt = new JButton(text);
        butt.setForeground(new Color(0x9f82ff));
        butt.setBackground(Color.WHITE);
        butt.setBorder(new RoundedBorder(10));
        return butt;
    }

    public static JButton buttonIconAdd() {
        JButton butt = new JButton();
        ImageIcon add = (ImageIcon) GetIcon.icones.icon_add.image();
        ImageIcon addScaled = new ImageIcon(add.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH));
        butt.setIcon(addScaled);
        butt.setBackground(null);
        butt.setBorder(null);
        return butt;
    }

    public static JButton flatButtonWhiteBlackButton(String text) {
        JButton butt = new JButton(text);
        butt.setForeground(new Color(0x9f82ff));
        butt.setBackground(Color.WHITE);
        butt.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        return butt;
    }
}
