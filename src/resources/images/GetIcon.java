package resources.images;

import javax.swing.*;

public class GetIcon {
    public enum icones {
        icon_window("icon_poney.png"),
        icon_book("book.png"),
        icon_movie("movie.png"),
        icon_music("music.png"),
        icon_videogame("videogame.png"),
        bg_title("moviebg.png");


        private Icon i;

        icones(String p_fichier_image) {
            i = new ImageIcon(GetIcon.class.getResource(p_fichier_image));
        }

        public Icon image() {
            return i;
        }
    }
}


