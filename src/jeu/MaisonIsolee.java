package jeu;

import java.util.ArrayList;
import java.util.List;

public class MaisonIsolee extends Zone {

    public MaisonIsolee(String description) {
        super(description);
        commandes = new ArrayList<String>();

       
    }

    @Override
    public List<String> getCommandesSpecifiques() {
        commandes.add("Parler au vieux monsieur");
        sorties.add("NORD-N");
        return commandes;
    }

    @Override
    public void executerCommandeSpecifique(String commande) {
            switch (commande){
                case "PARLER AU VIEUX MONSIEUR" :
                    Main.jeu.getGUI().afficheImage("MAISONISOLE2.png");
                    Main.jeu.afficher("Bonjour jeune voyageur. Ca tombe bien que tu sois la tu vas pouvoir m'aider. \n" +
                            "J'ai perdu près de chez moi un pendentif très cher à mes yeux. Je ne sais plus exactement là où \n" +
                            "je l'ai perdu mais il ne doit pas être tres loin d'ici. Aide moi à le retrouver et je t'aiderai en retour.\n\n\n" +
                            "Règles: Pour aider le vieux monsieur à retrouver son objet vous aurez une liste de commandes de plusieurs positions dans la zone. Seul une seule \n " +
                            "position cache l'objet. Vous aurerz 3  essais");
                    commandes.remove("Parler au vieux monsieur");
                    commandes.addAll(List.of("A","B","C","D","E","F","G"));
                    break;
                default:
                    Main.jeu.afficher("Commande inconnue fjezfjzzlfj");
                    break;

            }
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

