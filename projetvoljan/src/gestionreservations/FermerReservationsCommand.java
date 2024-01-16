package gestionreservations;

import gestionvol.CompagnieAerienne;
import gestionvol.Vol;

public class FermerReservationsCommand implements Command {
    private CompagnieAerienne compagnieAerienne;
    private Vol vol;

    public FermerReservationsCommand(CompagnieAerienne compagnieAerienne, Vol vol) {
        this.compagnieAerienne = compagnieAerienne;
        this.vol = vol;
    }


    public void executer() {
        compagnieAerienne.fermerReservations(vol);
    }
}
