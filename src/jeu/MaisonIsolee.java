package jeu;

import java.util.List;

public class MaisonIsolee extends Zone {

    public MaisonIsolee() {
        super("MaisonIsolee");
        ajouterImage("maisonisolee.png");
       
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
            case "COUPER_ARBRE":
                couperArbre();
                break;
            default:
                super.traiterCommandeZone(commande);
        }
    }

    private void couperArbre() {
       
    }
}

