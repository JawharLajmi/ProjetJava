package gestionreservations;

public class AssuranceMedicale extends AssuranceDecorator {
    public AssuranceMedicale(Reservation reservation) {
        super(reservation);
        System.out.println("Assurance médicale ajoutée");
    }

    @Override
    public int getPrix() {
        return reservation.getPrix() + 100;
    }
}

