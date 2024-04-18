package jeu;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jeu {

    private GUI gui;
    private Joueur joueur;
    private Zone zoneCourante;
    private List<Zone> zonesDisponibles;
    private List<Zone> zonesVisitees;

    public Jeu() {
    	 gui = new GUI(this);
        joueur = new Joueur(zoneCourante);
        zonesDisponibles = new ArrayList<>(); 
        zonesVisitees = new ArrayList<>(); 

        initialiserJeu();
    }
    public GUI getGUI() {
    	return this.gui;
    }
    public Joueur getJoueur() {
    	return this.joueur;
    }


    public void setGUI(GUI g) {
        gui = g;
        
        g.afficheImageZoneActuelle();
      
    }

    private void initialiserJeu() {
        creerZones();
        choisirNouvelleZone();
        
        
    }




    
    public void afficher(String s) {
        gui.afficher(s);
    }
    
    public void afficher() {
       gui.afficher();
    }
    

    private void creerZones() {
    	
        Plage plage = new Plage("Plage");
        Foret foret = new Foret("Foret");
        Village village = new Village("Village");
        Zone labyrinthe= new Labyrinthe("Labyrinthe");
        /*
        Zone maison = new Zone("Maison");
        
        Zone grotte = new Zone("Grotte");
        Zone maisonisolee = new Zone("Maisonisolee");

        Zone monstre = new Zone("Monstre");
        Zone temple = new Zone("Temple");
        Zone sorcierelieu= new Zone("Sorciere");*/

        

        plage.ajouterImage("plage.png");
        plage.ajouterImage("plage2.png");
        foret.ajouterImage("foret.png");
        village.ajouterImage("village.png");
        village.ajouterImage("village2.png");
        labyrinthe.ajouterImage("labyrinthe.png");
        labyrinthe.ajouterImage("labyrinthe2.png");
        /*
        maison.ajouterImage("maison.png");
      
        grotte.ajouterImage("grotte.png");
        maisonisolee.ajouterImage("maisonisolee.png");

        monstre.ajouterImage("monstre.png");
        temple.ajouterImage("temple.png");
        sorcierelieu.ajouterImage("sorcierelieu.png");*/
        
       

        
          
        
        


       

        zonesDisponibles.add(plage);
        zonesDisponibles.add(foret);
        zonesDisponibles.add(village);
        zonesDisponibles.add(labyrinthe);
        /*
        zonesDisponibles.add(maison);
       
        zonesDisponibles.add(grotte);
        zonesDisponibles.add(maisonisolee);

        zonesDisponibles.add(monstre); 
        zonesDisponibles.add(temple);
        zonesDisponibles.add(sorcierelieu);*/

        

    }
    
    
    private void choisirNouvelleZone() {
    	
    	Zone n = new Plage("Fin");
    	n.ajouterImage("zonefin1.png");
    	
    	
    	
        if (zonesVisitees.isEmpty()) {
            zoneCourante = trouverZoneParNom("Plage");
            zonesDisponibles.remove(zoneCourante);
            zonesVisitees.add(zoneCourante);
        } else if (zonesVisitees.size() == 1) {
        	
            zoneCourante = trouverZoneParNom("Foret");
            zonesDisponibles.remove(zoneCourante);
            zonesVisitees.add(zoneCourante);
            System.out.println(zonesDisponibles.size());
        	System.out.println(zonesVisitees);
        } else if (zonesDisponibles.isEmpty()) {
        	
            zoneCourante = n;
            zoneCourante.getDescription();

            
            
        } else {
        	
            Random random = new Random();
            int index = random.nextInt(zonesDisponibles.size());
            zoneCourante = zonesDisponibles.get(index);
            zonesDisponibles.remove(zoneCourante);
            zonesVisitees.add(zoneCourante);
        	System.out.println(zonesDisponibles);

            System.out.println(zonesDisponibles.size());
        	System.out.println(zonesVisitees);
        	System.out.println(zonesDisponibles.isEmpty());

        }
        joueur.deplacerVers(zoneCourante);
      
        afficherMessageDeBienvenue(zoneCourante);
    }



    
    private void afficherMessageDeBienvenue(Zone zone) {
    	gui.effacerConsole();
        gui.afficher("Bienvenue !");
        gui.afficher();
        gui.afficher("Tapez '?' pour obtenir de l'aide.");
        gui.afficher();
        afficherLocalisation(zone);
    }
    private Zone trouverZoneParNom(String nom) {
        for (Zone zone : zonesDisponibles) {
            if (zone.getDescription().equalsIgnoreCase(nom)) {
                return zone;
            }
        }
        return null;
    }


 
    private void afficherCommandesDisponibles() {
        List<String> commandes = zoneCourante.getCommandesDisponibles();
        gui.afficher("Commandes disponibles : " + String.join(", ", commandes));
    }
    private void afficherCommandesRestantes() {
        List<String> commandes = zoneCourante.getCommandesRestantes();
        gui.afficher("Commandes restantes : " + String.join(", ", commandes));
    }
    private void afficherCommandesDéplacements() {
    	List<String> deplacements = zoneCourante.getCommandesDeplacements();
        gui.afficher("Commandes Ddeplacements : " + String.join(", ", deplacements));
    }
    private void afficherAutresCommandes() {
        List<String> deplacements = zoneCourante.getAutrescommandes();
        gui.afficher("Autres commandes : " + String.join(", ", deplacements));
    }

          



    public Zone getZoneCourante() {
        return zoneCourante;
    }

  

    public void afficherLocalisation(Zone zone) {
    	
        gui.afficher(zone.getDescription());
        gui.afficher();
        afficherCommandesDisponibles();
        gui.afficher(zone.getObjetsDisponibles());
        gui.afficher();
        gui.afficheImageZoneActuelle();
    }

    

    private void ramasserObjet() {
        Zone zoneActuelle = getZoneCourante();
        Objet objet = zoneActuelle.ramasserObjet();
        if (objet != null) {
            joueur.ramasserObjet(objet);
            gui.afficher("Vous avez ramassé : " + objet.getNom());
            afficherInventaire();
        } else {
            gui.afficher("Il n'y a rien à ramasser ici. Objets disponibles : " + zoneActuelle.getObjetsDisponibles());
        }
        gui.afficherLocalisation();
    }

    private void afficherInventaire() {
        List<Objet> inventaire = joueur.getObjets();
        if (!inventaire.isEmpty()) {
            StringBuilder inventaireText = new StringBuilder("Inventaire : ");
            for (Objet objet : inventaire) {
                inventaireText.append(objet.getNom()).append(", ");
            }

            inventaireText.delete(inventaireText.length() - 2, inventaireText.length());
            gui.afficher(inventaireText.toString());
        } else {
            gui.afficher("Votre inventaire est vide.");
        }
    }

    public void traiterCommande(String commandeLue) {
    	
    	   gui.afficher("> " + commandeLue + "\n");

    	    if (zoneCourante.getCommandesRestantes().size() >= 1) {
    	    	
    	        zoneCourante.executerCommandeSpecifique(commandeLue.toUpperCase());
    	        if(zoneCourante.getCommandesRestantes().size()==0) {
    	        	afficherCommandesDéplacements();
                    afficherAutresCommandes();
    	        	}
    	        else {
    	        	 afficherCommandesRestantes();
    	        }
    	       
    	    }
    	    /*else if(zoneCourante.getCommandesRestantes().size()==0) {
    	    	zoneCourante.executerCommandeSpecifique(commandeLue);
    	    	
    	    }*/
    	    switch (commandeLue) {
    	    	case "VERS LA FORET":
                case "NORD":
                case "N":
                case "EST":
                case "E":
                case "SUD":
                case "S":
                case "OUEST":
                case "O":
                    choisirNouvelleZone();
                    break;
                case "INVENTAIRE":
                case "I":
                    afficherInventaire();
                    break;
                /*case "AIDE":
                    afficherAide();
                    break;*/
    	    }
    	    
    	    
    	    System.out.println(zoneCourante.getCommandesDeplacements());
    	    System.out.println(zoneCourante.getCommandesRestantes());
        
        /*switch (commandeLue.toUpperCase()) {
        case "NORD":
        case "N":
        case "EST":
        case "E":
        case "SUD":
        case "S":
        case "OUEST":
        case "O":
            choisirNouvelleZone();
            break;
        case "?":

        case "R":
        case "RAMASSER":
                ramasserObjet();
                break;
        case "I":
        case "INVENTAIRE":
                afficherInventaire();
                break;
        case "Q":
        case "QUITTER":
                terminer();
                break;
        default:
                gui.afficher("Commande inconnue");
                break;
        }*/
        
    }

    private void afficherAide() {
        gui.afficher("Etes-vous perdu ?");
        gui.afficher();
        gui.afficher("Les commandes autorisées sont :");
        gui.afficher();
        gui.afficher();
    }

    void terminer() {
        gui.afficher("Au revoir...");
        gui.enable(false);
    }
    void terminerJeu() {
        // Arrête l'exécution du jeu
        System.exit(0);
    }
}
