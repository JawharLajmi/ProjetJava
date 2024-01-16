package gestionclients;

import gestionreservations.Reservation;
import gestionvol.Vol;

public class PersonneMorale extends Client {
    private String raisonSociale;

    public PersonneMorale(String nom, String cin, String raisonSociale) {
        super(nom, cin);
        this.raisonSociale = raisonSociale;
    }

    public Reservation creerReservation(Passager passager, Vol vol) {
        // Implémentation spécifique pour la création de réservation pour une personne morale
        Reservation reservation = new Reservation(passager, vol);
        reservations.add(reservation);
		if (vol.getPlaces() > 0) {
			System.out.println("Réservation "+reservation+" passé status: "+reservation.getStatus());}
		else {
			reservation.setStatus("Refusé");
			System.out.println("Pas de places disponibles, réservation "+reservation +" refusé");
			reservations.remove(reservation);
		}
    	return reservation;
    }

    public Reservation creerReservation(Vol vol) {
    	
        // Création d'un passager par défaut associé au client
    		Passager passagerParDefaut = new Passager(this.nom, this.cin);
    		Reservation reservation = new Reservation(passagerParDefaut, vol);
    		reservations.add(reservation);
    		if (vol.getPlaces() > 0) {
    			System.out.println("Réservation passé status: "+reservation.getStatus());}
    		else {
    			reservation.setStatus("Refusé");
    			System.out.println("Pas de places disponibles");
    			reservations.remove(reservation);
    		}
        	return reservation;
    		
    		
    }
    

    // Autres méthodes, getters, setters, etc.
}
