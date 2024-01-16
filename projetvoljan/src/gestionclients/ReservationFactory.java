package gestionclients;

import gestionreservations.Reservation;
import gestionvol.Vol;

public interface ReservationFactory {
	Reservation creerReservation(Vol vol);
	Reservation creerReservation(Passager passager, Vol vol);

}
