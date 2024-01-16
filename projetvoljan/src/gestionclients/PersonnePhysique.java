package gestionclients;

import gestionreservations.Reservation;
import gestionvol.Vol;

public class PersonnePhysique extends Client {
    public PersonnePhysique(String nom, String cin) {
        super(nom, cin);
    }

    public Reservation creerReservation(Passager passager, Vol vol) {
        // Implémentation spécifique pour la création de réservation pour une personne physique
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
			System.out.println("Réservation "+reservation+" passé status: "+reservation.getStatus());}
		else {
			reservation.setStatus("Refusé");
			System.out.println("Pas de places disponibles, réservation "+reservation +" refusé");
			reservations.remove(reservation);
		}
    	return reservation;
    }
    
}
