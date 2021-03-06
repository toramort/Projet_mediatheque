package GUI;

import GUI.assets.CustomButton;
import GUI.assets.FlatCombo;
import database.Job;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class ConfirmNewValue extends JOptionPane {


    ConfirmNewValue() {
        this.setBackground(Color.white);
    }

    static String showDialogSimpleTextField() {
        JTextField valeur = new JTextField(20);
        JPanel panel = new JPanel();
        panel.add(new JLabel("Valeur : "));
        panel.add(valeur);

        int result = JOptionPane.showConfirmDialog(null, panel,
            "Entrez une nouvelle valeur", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            return valeur.getText();
        } else {
            return "";
        }
    }

    List showDialogTripleField() {
        this.setLayout(null);
        JComboBox<Job> comboJobs = new FlatCombo<>();
        JButton job;
        JTextField valeur = new JTextField(20);
        JTextField valeur1 = new JTextField(20);
        JTextField valeur2 = new JTextField(20);
        JPanel panel = new JPanel();
        JPanel jobsPanel = new JPanel();
        JLabel jobsLabel = new JLabel("Rôle : ");

        job = CustomButton.flatButtonWhite("Rôle+");

        List<Job> reqJobs = Job.read();
        for (Job job1 : reqJobs) {
            comboJobs.addItem(job1);
        }

        if (comboJobs.getItemCount() == 0) {
            jobsPanel.setBackground(Color.red);
        }

        job.addActionListener(e -> {
            String newNameJob = showDialogSimpleTextField();
            if (!newNameJob.equals("")) {
                Job nvJob = new Job(newNameJob);
                nvJob.create();
                comboJobs.addItem(nvJob);
                jobsPanel.setBackground(null);
            }
        });

        jobsPanel.add(jobsLabel);
        jobsPanel.add(comboJobs);
        jobsPanel.add(job);
        panel.add(jobsPanel);
        panel.add(new JLabel("FirstName : "));
        panel.add(valeur);
        panel.add(new JLabel("LastName : "));
        panel.add(valeur1);
        panel.add(new JLabel("Surname : "));
        panel.add(valeur2);

        int result = JOptionPane.showConfirmDialog(null, panel,
            "Entrez des nouvelles valeurs", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            if (!valeur.getText().equals("") && !valeur1.getText().equals("") && !valeur2.getText().equals("")) {
                List temp = new ArrayList<>();
                temp.add(valeur.getText());
                temp.add(valeur1.getText());
                temp.add(valeur2.getText());
                temp.add(comboJobs.getSelectedItem());
                return temp;
            } else {
                showMessageDialog(null, "Veuillez insérer des valeurs dans tous les champs",
                    "Erreur", ERROR_MESSAGE);
                return null;
            }
        } else {
            return null;
        }
    }

}
