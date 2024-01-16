package gestionreservations;

public class AssuranceBagage extends AssuranceDecorator {
    public AssuranceBagage(Reservation reservation) {
        super(reservation);
        System.out.println("Assurance pour bagage ajoutée");
    }

    @Override
    public int getPrix() {
        return reservation.getPrix() + 150;
    }
}
