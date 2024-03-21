package jeu;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public abstract class Zone {

    private String description;
    private List<String> images;
    protected List<String> sorties;
    private int situationActuelle;
    private List<Objet> objets;
    protected List<String> commandes;
    
    



    public Zone(String description) {
        this.description = description;
        images = new ArrayList<>();
        sorties = new ArrayList<>();
        situationActuelle = 0; 
 
        objets = new ArrayList<>();
        ;

    }

    public void ajouterImage(String image) {
        images.add(image);
    }
    
    public String nomImage() {
        if (situationActuelle >= 0 && situationActuelle < images.size()) {
            return images.get(situationActuelle);
        } else {
            return null;
        }
    }
   

    /*public void changerSituation(int nouvelleSituation) {
       this.situationActuelle++;
       GUI.class
       
    }*/
    public abstract List<String> getCommandesSpecifiques();
    public List<String> getCommandesDisponibles() {
        List<String> commandes = new ArrayList<>();
        commandes.addAll(getCommandesSpecifiques());
        // Ajoutez d'autres commandes générales si nécessaire
        return commandes;
    }
    public List<String> getCommandesRestantes(){
    	return commandes;
    }
    public List<String> getCommandesDeplacements(){
    	return sorties;
    }
    public abstract void executerCommandeSpecifique(String commande);
    



   public String toString() {

       return description;

   }



   public String descriptionLongue()  {

       return "Vous êtes dans " + description + "\nSorties : " ;

   }
   
 

   

    public String getDescription() {
    	return this.description;
    }

   /*private String sorties() {

       return sorties.keySet().toString();

   }*/
   
   public void traiterCommandeZone(String commande) {
      
   }




   /*public Zone obtientSortie(String direction) {

    return sorties.get(direction);

   }*/
   
   public void ajouterObjet(Objet objet) {
       objets.add(objet);
   }

   public Objet ramasserObjet() {
       if (!objets.isEmpty()) {
           Objet objetRamasse = objets.remove(0);
           return objetRamasse;
       }
       return null;
   }
   public String getObjetsDisponibles() {
	   
	    if (!objets.isEmpty()) {
	        StringBuilder objetsText = new StringBuilder("Objets disponibles : ");
	        for (Objet objet : objets) {
	            objetsText.append(objet.getNom()).append(", ");
	        }
	        
	        
	        objetsText.delete(objetsText.length() - 2, objetsText.length());
	        return objetsText.toString();
	    } else {
	        return "Aucun objet à ramasser ici.";
	    }
	}
    public List<Objet> getObjets(){
       return this.objets;
    }
   

}


