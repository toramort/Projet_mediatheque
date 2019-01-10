package GUI;

import resources.images.GetIcon;

import javax.swing.*;

public class BoutonAdd extends JButton {
    BoutonAdd() {
        super(GetIcon.icones.icon_plus.image());
        this.setBounds(620, 205, 25, 25);
        this.setBorderPainted(false);
    }
}
