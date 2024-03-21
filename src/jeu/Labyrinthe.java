package jeu;

import java.util.List;

public class Labyrinthe extends Zone {

    public Labyrinthe() {
        super("Labyrinthe");
        ajouterImage("labyrinthe.png");
       
    }

    @Override
    public List<String> getCommandesSpecifiques() {
        return null;
    }

    @Override
    public void executerCommandeSpecifique(String commande) {

    }

    @Override
    public void traiterCommandeZone(String commande) {
        switch (commande.toUpperCase()) {
            case "":
                ;
                break;
            default:
                super.traiterCommandeZone(commande);
        }
    }

    private void faireqlqchose() {
       
    }
}

