package gestionreservations;

public class RefuserReservationCommand implements Command {
    private Reservation reservation;

    public RefuserReservationCommand(Reservation reservation) {
        this.reservation = reservation;
    }
    
    public void executer() {
        reservation.refuser();
    }
}