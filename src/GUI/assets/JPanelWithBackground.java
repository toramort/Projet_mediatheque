package GUI.assets;

import resources.images.GetBackground;

import javax.swing.*;
import java.awt.*;

public class JPanelWithBackground extends JPanel {

    private Icon backgroundImage;

    // Some code to initialize the background image.
    // Here, we use the constructor to load the image. This
    // can vary depending on the use case of the panel.
    JPanelWithBackground(String fileName) {
        try {
            backgroundImage = GetBackground.background.image_background.image();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the background image.
        //g.drawImage(backgroundImage, 0, 0, this);
    }
}
