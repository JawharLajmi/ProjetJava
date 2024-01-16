package gestionreservations;

public abstract class AssuranceDecorator extends Reservation {
    protected Reservation reservation;

    public AssuranceDecorator(Reservation reservation) {
        super(reservation.getPassager(), reservation.getVol());
        this.setStatus(reservation.getStatus());
        this.setPrix(reservation.getPrix());
        this.reservation = reservation;
    }

    @Override
    public abstract int getPrix();
}

