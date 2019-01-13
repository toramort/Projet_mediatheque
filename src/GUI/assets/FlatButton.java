package GUI.assets;

import javax.swing.*;
import java.awt.*;

public class FlatButton extends JButton {

    public FlatButton(String text) {
        super(text);
        this.setForeground(new Color(0x9f82ff));
        this.setBackground(Color.WHITE);
        this.setBorder(new RoundedBorder(10));
    }
}
