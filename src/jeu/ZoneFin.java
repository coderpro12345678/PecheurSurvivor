package jeu;

import java.util.List;

public class ZoneFin extends Zone {

    public ZoneFin() {
        super("ZoneFin");
        ajouterImage("zonefin1.png");
        ajouterImage("zonefin2.png");

       
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

    private void qlqchose() {
       
    }
}

