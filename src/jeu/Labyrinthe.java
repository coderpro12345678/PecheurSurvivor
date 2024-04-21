package jeu;

import java.util.ArrayList;
import java.util.List;

public class Labyrinthe extends Zone {
    private Objet coffre;
    private Objet cordes;
    private static int chances = 3;
    public Labyrinthe(String description) {
        super(description + "\n" + "Vous etes maintenant dans un labyrinthe. Pour y sortir c'est simple \n il " +
                "vous faudra taper la bonne séquence de mouvements. Les mouvements possibles sont\n " +
                "D pour tourner à Droite et G pour tourner à Gauche (vous ne pouvez pas faire marche arrière)\n " +
                "Si sur une ligne droite vous avez plusieurs possibilités de tourner à droite ou à gauche vous devez spécifier \n" +
                "quelle droite ou quelle gauche en mettant un chiffre devant. Exemple : Vous avez 2 possibilités d'aller à gauche \n" +
                "sur une ligne droite si vous voulez passer par la 1ere gauche vous devez taper 1G, la 2e 2G. Vous devez taper la \n" +
                "séquence entière sur une seule ligne sans espace. Vous avez 3 essais. Bon courage " +
                "");
        commandes = new ArrayList<String>();
        this.coffre = new Objet("coffre");
        this.cordes = new Objet("cordes");
        super.getObjets().add(coffre);
        sorties.add("EST-E");
        commandes.add("Aucune commandes disponibles");
       
    }

    @Override
    public List<String> getCommandesSpecifiques() {

        return commandes;
    }

    @Override
    public void executerCommandeSpecifique(String commande) {

            switch (commande.toUpperCase()) {
                case "D2G2D1GDGGDD":
                    Main.jeu.getGUI().afficheImage("labyrinthe2.png");
                    Main.jeu.afficher("Félicitations vous avez réussi à sortir du labyrinthe. Vous trouvez à la sortie " +
                            "un coffre. Vous trouvez dans le coffre des cordes.");
                    Main.jeu.getJoueur().ramasserObjet(cordes);
                    commandes.remove("Aucune commandes disponibles");

                    break;
                default:
                    Main.jeu.afficher("Vous avez tapez la mauvaise séquence ");
                    chances = chances -1;
                    if(chances==0){
                        Main.jeu.afficher("Il ne vous reste plus d'essais.Vous avez perdu");
                        Main.jeu.terminer();
                    }
                    else{
                        Main.jeu.afficher("Il vous reste " + chances + " essais" );
                    }
                    break;
        }
    }

    @Override
    public void traiterCommandeZone(String commande) {

    }

    private void faireqlqchose() {
       
    }
}

