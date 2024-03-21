package jeu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class GUI implements ActionListener
{
    private Jeu jeu;
    private JFrame fenetre;
    private JTextField entree;
    private JTextArea texte;
    private JLabel image;

    public GUI(Jeu j) {
        jeu = j;
        creerGUI();
    }

    public void afficher(String s) {
        texte.append(s + "\n");
    }

    public void afficher() {
        // Ne fait rien dans cette implémentation
    }

    public void rafraichirAffichage() {
        afficherLocalisation();
        afficheImageZoneActuelle();
    }

    protected void afficherLocalisation() {
        texte.setText(""); 
        afficher("Bienvenue !");
        afficher("Tapez '?' pour obtenir de l'aide.");
        Zone zoneActuelle = jeu.getZoneCourante();
        afficher(zoneActuelle.getDescription());
        afficher(zoneActuelle.getObjetsDisponibles());
    }

    void afficheImage(String nomImage) {
        URL imageURL = this.getClass().getClassLoader().getResource("imagesJeu/" + nomImage);
        if (imageURL != null) {
            image.setIcon(new ImageIcon(imageURL));
            
        } else {
            System.out.println("L'image n'a pas été trouvée : " + nomImage);
        }
    }

    public void afficheImage(Zone zone) {
        String nomImage = zone.nomImage();
        afficheImage(nomImage);
    }

    public void afficheImageZoneActuelle() {
        Zone zoneActuelle = jeu.getZoneCourante();
        String nomImage = zoneActuelle.nomImage();
        afficheImage(nomImage);
    }

    public void enable(boolean ok) {
        entree.setEditable(ok);
        if (!ok)
            entree.getCaret().setBlinkRate(0);
    }

    private void creerGUI() {
        fenetre = new JFrame("Jeu");
        entree = new JTextField(34);
        texte = new JTextArea();
        texte.setEditable(false);
        JScrollPane listScroller = new JScrollPane(texte);
        listScroller.setPreferredSize(new Dimension(500, 500));
        listScroller.setMinimumSize(new Dimension(100,100));

        JPanel panel = new JPanel();
        image = new JLabel();

        panel.setLayout(new BorderLayout());
        panel.add(image, BorderLayout.NORTH);
        panel.add(listScroller, BorderLayout.CENTER);
        panel.add(entree, BorderLayout.SOUTH);

        fenetre.getContentPane().add(panel, BorderLayout.CENTER);

        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        entree.addActionListener(this);

        fenetre.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fenetre.setVisible(true);
        entree.requestFocus();
    }

    public void actionPerformed(ActionEvent e) {
        executerCommande();
    }

    private void executerCommande() {
        String commandeLue = entree.getText();
        entree.setText("");
        jeu.traiterCommande(commandeLue);
    }
    public void afficherMessage(String message) {
        afficher("message");
        afficher();
    }
    public void effacerConsole() {
        // Code pour effacer le contenu de la console
        // Par exemple, si vous avez un JTextArea nommé consoleTextArea :
        texte.setText("");
    }
}
