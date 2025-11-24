import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AppliClasseEleves extends JFrame {

    private Classe classe;
    private DefaultTableModel tableModel;

    public AppliClasseEleves() {
        super("Gestion des élèves");

        // Création d'une classe avec quelques élèves par défaut
        classe = new Classe("Classe 1");
        classe.ajouterEleve(new Eleve("Dupont", "Alice", 15));
        classe.ajouterEleve(new Eleve("Martin", "Bob", 16));

        // Tableau pour afficher les élèves
        tableModel = new DefaultTableModel(new Object[]{"Prénom", "Nom", "Âge"}, 0);
        JTable table = new JTable(tableModel);
        refreshTable();

        JScrollPane scrollPane = new JScrollPane(table);

        // Formulaire d'ajout d'élève
        JPanel formPanel = new JPanel(new FlowLayout());
        JTextField prenomField = new JTextField(10);
        JTextField nomField = new JTextField(10);
        JTextField ageField = new JTextField(3);
        JButton ajouterBtn = new JButton("Ajouter Élève");

        formPanel.add(new JLabel("Prénom:"));
        formPanel.add(prenomField);
        formPanel.add(new JLabel("Nom:"));
        formPanel.add(nomField);
        formPanel.add(new JLabel("Âge:"));
        formPanel.add(ageField);
        formPanel.add(ajouterBtn);

        ajouterBtn.addActionListener(e -> {
            String prenom = prenomField.getText().trim();
            String nom = nomField.getText().trim();
            String ageText = ageField.getText().trim();

            if(prenom.isEmpty() || nom.isEmpty() || ageText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                int age = Integer.parseInt(ageText);
                Eleve eleve = new Eleve(nom, prenom, age);
                classe.ajouterEleve(eleve);
                refreshTable();

                // Nettoyer les champs
                prenomField.setText("");
                nomField.setText("");
                ageField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "L'âge doit être un nombre valide", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });

        this.setLayout(new BorderLayout());
        this.add(scrollPane, BorderLayout.CENTER);
        this.add(formPanel, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
    }

    private void refreshTable() {
        tableModel.setRowCount(0); // Vide la table
        for(Eleve e : classe.getEleves()) {
            tableModel.addRow(new Object[]{e.getPrenom(), e.getNom(), e.getAge()});
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AppliClasseEleves().setVisible(true);
        });
    }
}
