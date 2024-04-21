package jeu;

import java.util.List;

public class Grotte extends Zone{
    public Grotte (String description){
        super(description);
    }



    @Override
    public List<String> getCommandesSpecifiques() {
        return null;
    }

    @Override
    public void executerCommandeSpecifique(String commande) {

    }
}
