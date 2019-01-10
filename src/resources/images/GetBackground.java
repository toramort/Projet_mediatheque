package resources.images;

import javax.swing.*;

public class GetBackground {
    public enum background {
        image_background("blurred-background-2.jpg");

        private Icon i;

        background(String p_fichier_image) {
            i = new ImageIcon(GetBackground.class.getResource("resources/images/" + p_fichier_image));
        }

        public Icon image() {
            return i;
        }
    }
}
