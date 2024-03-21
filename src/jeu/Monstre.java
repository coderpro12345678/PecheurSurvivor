package jeu;

import java.util.List;

public class Monstre extends Zone {

    public Monstre() {
        super("Monstre");
        ajouterImage("monstre .png");
       
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
               
                break;
            default:
                super.traiterCommandeZone(commande);
        }
    }

    private void qlqchose(){
       
    }
}

