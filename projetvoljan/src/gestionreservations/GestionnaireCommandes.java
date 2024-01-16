
package gestionreservations;

import java.util.ArrayList;
import java.util.List;

public class GestionnaireCommandes {
    private List<Command> commandes = new ArrayList<>();

    public void ajouterCommande(Command commande) {
        commandes.add(commande);
    }

    public void executerCommandes() {
        for (Command commande : commandes) {
            commande.executer();
        }
        commandes.clear(); // Vider la liste après l'exécution
    }
}