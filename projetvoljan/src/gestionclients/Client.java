package gestionclients;

import java.util.ArrayList;
import java.util.List;

import gestionreservations.Reservation;
import gestionvol.Vol;

public abstract class Client implements ClientObserver ,ReservationFactory {
    protected String nom;
    protected String cin;
    protected String mailReceiver;
    protected List<Reservation> reservations;

    public Client(String nom, String cin) {
        this.nom = nom;
        this.cin = cin;
        this.reservations = new ArrayList<>();
    }

    public abstract Reservation creerReservation(Passager passager, Vol vol) ;

    public abstract Reservation creerReservation(Vol vol) ;
    
    public void update(String mailReceiver) {
    	this.mailReceiver=mailReceiver;
    	System.out.println(mailReceiver);
    }
    public String getNom() {
    	return this.nom ;
    }

    // Autres méthodes, getters, setters, etc.
}
