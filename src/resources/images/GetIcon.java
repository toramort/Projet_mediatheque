package resources.images;

import javax.swing.*;

public class GetIcon {
    public enum icones {
        icon_window("icon_poney.png");


        private Icon i;

        icones(String p_fichier_image) {
            i = new ImageIcon(GetIcon.class.getResource(p_fichier_image));
        }

        public Icon image() {
            return i;
        }
    }
}


