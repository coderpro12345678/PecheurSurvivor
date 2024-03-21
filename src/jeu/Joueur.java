package jeu;

import java.util.ArrayList;
import java.util.List;

public class Joueur {
    private Zone zoneActuelle;
    private List<Objet> objets;

    public Joueur(Zone zoneInitiale) {
        this.zoneActuelle = zoneInitiale;
        this.objets = new ArrayList<>();
    }

    public List<Objet> getObjets() {
        return objets;
    }

    public void ramasserObjet(Objet objet) {
        objets.add(objet);
        Main.jeu.getGUI().afficher("Vous avez rammassé " + objet.getNom());
    }

   
    public Zone getZoneActuelle() {
        return zoneActuelle;
    }

    public void deplacerVers(Zone nouvelleZone) {
        zoneActuelle = nouvelleZone;
    }
}

