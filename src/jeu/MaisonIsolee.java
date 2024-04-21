package jeu;

import java.util.ArrayList;
import java.util.List;

public class MaisonIsolee extends Zone {
    private static int nbessais = 3;
    private Objet lampe;
    public MaisonIsolee(String description) {
        super(description);

        commandes = new ArrayList<String>();
        commandes.add("Parler au vieux monsieur");
        sorties.add("NORD-N");
        this.lampe = new Objet("Lampe");
       
    }

    @Override
    public List<String> getCommandesSpecifiques() {

        return commandes;
    }

    @Override
    public void executerCommandeSpecifique(String commande) {



        switch (commande){

            case "PARLER AU VIEUX MONSIEUR":
                Main.jeu.getGUI().afficheImage("MAISONISOLE2.png");
                Main.jeu.afficher("Bonjour jeune voyageur. Ca tombe bien que tu sois la tu vas pouvoir m'aider. \n" +
                                "J'ai perdu près de chez moi un pendentif très cher à mes yeux. Je ne sais plus exactement là où \n" +
                                "je l'ai perdu mais il ne doit pas être tres loin d'ici. Aide moi à le retrouver et je t'aiderai en retour.\n\n\n" +
                                "Règles: Pour aider le vieux monsieur à retrouver son objet vous aurez une liste de commandes de plusieurs positions dans la zone. Seul une seule \n " +
                                "position cache l'objet. Vous aurerz 3  essais");
                commandes.remove("Parler au vieux monsieur");
                commandes.addAll(List.of("A", "B", "C", "D", "E", "F", "G"));
                break;
            case "A" :
                Main.jeu.getGUI().afficheImage("MAISONISOLE3.png");
                Main.jeu.afficher("Vous fouillez ces buissons... mais vous n'y trouvez rien qui puisse ressembler à un pendentif.");
                commandes.remove("A");
                nbessais--;
                if(nbessais ==0) {

                    Main.jeu.afficher("Vous n'avez pas trouvez à temps l'objet perdu. Vous avez échoué.");
                    Main.jeu.terminer();
                }
                break;
            case "B":
                Main.jeu.getGUI().afficheImage("MAISONISOLE4.png");
                Main.jeu.afficher("Vous fouillez ces buissons... mais vous n'y trouvez rien qui puisse ressembler à un pendentif.");
                commandes.remove("B");
                nbessais--;
                        if(nbessais ==0) {

                            Main.jeu.afficher("Vous n'avez pas trouvez à temps l'objet perdu. Vous avez échoué.");
                            Main.jeu.terminer();
                        }
                break;
            case "E":
                Main.jeu.getGUI().afficheImage("MAISONISOLE7.png");
                Main.jeu.afficher("Vous fouillez ces buissons... mais vous n'y trouvez rien qui puisse ressembler à un pendentif.");
                commandes.remove("E");
                nbessais--;
                        if(nbessais ==0) {

                            Main.jeu.afficher("Vous n'avez pas trouvez à temps l'objet perdu. Vous avez échoué.");
                            Main.jeu.terminer();
                        }
                break;

            case "C":
                Main.jeu.getGUI().afficheImage("MAISONISOLE5.png");
                Main.jeu.afficher("Vous regardez au fond de l'eau et vous distinguez un objet brillant. Vous vous penchez pour le ramasser et c'est un collier avec une photo d'une vieille dame dessus. \n" +
                                "Vous avez trouvez l'objet! ");
                commandes.clear();
                commandes.add("RETOURNER PARLER AU VIEUX MONSIEUR");
                break;
            case "D":
                Main.jeu.getGUI().afficheImage("MAISONISOLE6.png");
                Main.jeu.afficher("Vous soulevez les 2 rochers de tout vos forces mais vos efforts ont été vain parce qu'il n'y a rien en dessous.");
                commandes.remove("D");
                nbessais--;
                if(nbessais ==0) {

                    Main.jeu.afficher("Vous n'avez pas trouvez à temps l'objet perdu. Vous avez échoué.");
                    Main.jeu.terminer();
                }
                break;
            case "F":
                Main.jeu.getGUI().afficheImage("MAISONISOLE8.png");
                Main.jeu.afficher("Vous fouillez chaque recoin des hautes herbes mais vous ne trouvez toujours rien.");
                commandes.remove("F");
                nbessais--;
                if(nbessais ==0) {

                    Main.jeu.afficher("Vous n'avez pas trouvez à temps l'objet perdu. Vous avez échoué.");
                    Main.jeu.terminer();
                }
                break;
            case "G":
                Main.jeu.getGUI().afficheImage("MAISONISOLE9.png");
                Main.jeu.afficher("Malgré qu'elle ne vous appartient pas vous décidez de fouiller la maison du vieux en vous disant peut-être qu'elle est sur une table et que le monsieur ne l'a pas vu \n" +
                        "Vous fouillez de fond en comble mais vous ne l'a trouvez pas.");
                commandes.remove("G");
                nbessais--;
                if(nbessais ==0) {

                    Main.jeu.afficher("Vous n'avez pas trouvez à temps l'objet perdu. Vous avez échoué.");
                    Main.jeu.terminer();
                }
                break;
            case "RETOURNER PARLER AU VIEUX MONSIEUR":
                Main.jeu.getGUI().afficheImage("MAISONISOLE2.png");
                Main.jeu.afficher("Merci jeune homme de l'avoir retrouvé. Ca faisait plus de 2 ans que je l'avais perdu depuis que ma femme m'avait abandonné" +
                        "pour une raison que je ne peux te dire mais qui sait peut-être que tu l'as croisera sur ton chemin voyageur. Comme promis voila ta recompense");
                Main.jeu.getJoueur().ramasserObjet(lampe);
                Main.jeu.afficher("*Vous vous demandez pourquoi vous a t-il donné cette lampe mais vous l'a rangé sans trop poser de questions.*\n" +
                        "Maintenant va et laisse moi partir en paix . *Il met le pendentif autour de son cou et vous voyez ses yeux se refermés*");
                commandes.remove("RETOURNER PARLER AU VIEUX MONSIEUR");
                break;

                default:
                    Main.jeu.afficher("Commande inconnue ");
                    if(nbessais!=0){
                        Main.jeu.afficher("Il vous reste " + nbessais + " essais");
                    }
                    break;

                }}



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

