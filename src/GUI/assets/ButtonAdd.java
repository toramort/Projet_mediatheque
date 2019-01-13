package GUI.assets;

import resources.images.GetIcon;

import javax.swing.*;
import java.awt.*;

public class ButtonAdd extends JButton {
    public ButtonAdd() {
        super();
        ImageIcon add = (ImageIcon) GetIcon.icones.icon_add.image();
        ImageIcon addScaled = new ImageIcon(add.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH));
        this.setIcon(addScaled);
        this.setBackground(null);
        this.setBorder(null);
    }
}
