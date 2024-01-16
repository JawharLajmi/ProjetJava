package gestionvol;

import java.util.ArrayList;
import java.util.List;

import gestionclients.Client;
import gestionreservations.Reservation;

public class CompagnieAerienne implements VolFactory {
    private String nom;
    private List<Client> clients = new ArrayList<>();
    private List<Vol> vols = new ArrayList<>();
    
    public void ajouterClient(Client client) {
    	clients.add(client);
    }
    
    public void supprimerClient(Client client) {
    	clients.remove(client);
    }

    public CompagnieAerienne(String nom) {
        this.nom = nom;
    }

    public void ouvrirReservations(Vol vol) {
    	if (vol.getPlaces()>0) {
        vol.setReservationStatus(true);
        notifierClients(vol, "La réservation est ouverte pour le vol numéro " + vol.getNumVol());
    	}
        else {
        	vol.setReservationStatus(false);
        	notifierClients(vol, "On a voulu ouvrir les réservatios pour vol "
        	+vol.getNumVol()+" mais pas de places disponibles.");
    	}

        }
    

    public void fermerReservations(Vol vol) {
        vol.setReservationStatus(false);
        notifierClients(vol, "La réservation est fermée pour le vol numéro " + vol.getNumVol());
    }

    public void accepterReservations(Reservation reservation) {
        reservation.accepter();
    }

    public void refuserReservations(Reservation reservation) {
        reservation.refuser();
    }

    public Vol creerVol(int numVol, int places, String heureDepart, String heureArrivee,
                        Aeroport aeroportDepart, Aeroport aeroportArrive, List<Escale> escales) {
        System.out.println("Vol numéro " + numVol + " créé.");
        Vol vol = new Vol(numVol, places, heureDepart, heureArrivee, aeroportDepart, aeroportArrive);
        vols.add(vol);
        return vol;
    }

    public void notifierClients(Vol vol, String message) {
        for (Client client : clients) {
            client.update("*(!)(!)* Mail vers " + client.getNom()+ " de la compagnie : " + this.nom + " " + 
            		message );
        }
    }
}
