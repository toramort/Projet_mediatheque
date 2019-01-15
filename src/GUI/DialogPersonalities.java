package GUI;

import javax.swing.*;
import java.awt.*;

public class DialogPersonalities extends JDialog {
    private String value1 = null;
    private JTextField input1;

    public DialogPersonalities(Frame owner, String title) {
        super(owner, title, true);
        JPanel container = new JPanel();
        JPanel btnPanel = new JPanel();
        input1 = new JTextField(20);
        JButton okBtn = new JButton("Accept");
        JButton noBtn = new JButton("Cancel");
        btnPanel.add(okBtn);
        okBtn.addActionListener(e -> okButton());
        noBtn.addActionListener(e -> noButton());
        btnPanel.add(noBtn);
        input1 = new JTextField(32);
        getContentPane().add(input1, BorderLayout.NORTH);
        getContentPane().add(btnPanel, BorderLayout.SOUTH);
        pack();
    }

    public String getValue1() {
        return value1;
    }

    private void okButton() {
        value1 = input1.getText();
        setVisible(false);
    }

    private void noButton() {
        value1 = null;
        setVisible(false);
    }
}
