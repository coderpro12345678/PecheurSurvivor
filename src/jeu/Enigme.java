package jeu;

public class Enigme {
	
	
    private String question;
    private String reponse;

    
    
    public Enigme(String question, String reponse) {
        this.question = question;
        this.reponse = reponse;
    }

    
    public boolean estBonneReponse(String reponseJoueur) {
        return reponse.equalsIgnoreCase(reponseJoueur);
    }
}
