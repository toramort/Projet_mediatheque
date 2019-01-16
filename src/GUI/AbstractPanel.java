package GUI;

import javax.swing.*;
import java.awt.*;

class AbstractPanel extends JPanel {

    int spaceLine = 55;
    int posX = 400;
    int posY = 120;
    int spaceXCombo = 150;
    int spaceXButton = 210;
    int dimComboX = 200;
    int dimComboY = 35;
    int dimButtonX = 200;
    int dimButtonY = 35;
    int spaceXtitle = 200;
    int spaceYtitle = -100;
    JLabel title;
    JPanel titrePanel = new JPanel();

    AbstractPanel(String titre) {
        this.setLayout(null);
        title = new JLabel(titre);
        title.setFont(new Font("Staatliches", Font.PLAIN, 40));
        title.setBounds(posX + spaceXtitle, posY + spaceYtitle, 400, 50);
        titrePanel.add(title);
        titrePanel.setBounds(0, 0, 2000, 90);
        titrePanel.setBackground(new Color(0x858efc));
        titrePanel.setLayout(null);
        this.setBackground(Color.white);
        this.add(titrePanel);
    }

    AbstractPanel(String titre, int y) {
        this.setLayout(null);
        title = new JLabel(titre);
        title.setFont(new Font("Staatliches", Font.PLAIN, 40));
        title.setBounds(posX + spaceXtitle - 150, posY + spaceYtitle, 550, 50);
        titrePanel.add(title);
        titrePanel.setBounds(0, y, 2000, 90);
        titrePanel.setBackground(new Color(0x858efc));
        titrePanel.setLayout(null);
        this.setBackground(Color.white);
        this.add(titrePanel);
    }

    public int getSpaceLine() {
        return spaceLine;
    }

    public void setSpaceLine(int spaceLine) {
        this.spaceLine = spaceLine;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getSpaceXCombo() {
        return spaceXCombo;
    }

    public void setSpaceXCombo(int spaceXCombo) {
        this.spaceXCombo = spaceXCombo;
    }

    public int getSpaceXButton() {
        return spaceXButton;
    }

    public void setSpaceXButton(int spaceXButton) {
        this.spaceXButton = spaceXButton;
    }

    public int getDimComboX() {
        return dimComboX;
    }

    public void setDimComboX(int dimComboX) {
        this.dimComboX = dimComboX;
    }

    public int getDimComboY() {
        return dimComboY;
    }

    public void setDimComboY(int dimComboY) {
        this.dimComboY = dimComboY;
    }

    public int getDimButtonX() {
        return dimButtonX;
    }

    public void setDimButtonX(int dimButtonX) {
        this.dimButtonX = dimButtonX;
    }

    public int getDimButtonY() {
        return dimButtonY;
    }

    public void setDimButtonY(int dimButtonY) {
        this.dimButtonY = dimButtonY;
    }

    public int getSpaceXtitle() {
        return spaceXtitle;
    }

    public void setSpaceXtitle(int spaceXtitle) {
        this.spaceXtitle = spaceXtitle;
    }

    public int getSpaceYtitle() {
        return spaceYtitle;
    }

    public void setSpaceYtitle(int spaceYtitle) {
        this.spaceYtitle = spaceYtitle;
    }
}
