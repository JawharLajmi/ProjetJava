package gestionreservations;

public class AccepterReservationCommand implements Command {
    private Reservation reservation;

    public AccepterReservationCommand(Reservation reservation) {
        this.reservation = reservation;
    }


    public void executer() {
        reservation.accepter();
    }
}