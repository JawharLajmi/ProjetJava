package gestionreservations;

import gestionvol.CompagnieAerienne;
import gestionvol.Vol;

public class OuvrirReservationsCommand implements Command {
    private CompagnieAerienne compagnieAerienne;
    private Vol vol;

    public OuvrirReservationsCommand(CompagnieAerienne compagnieAerienne, Vol vol) {
        this.compagnieAerienne = compagnieAerienne;
        this.vol = vol;
    }

    public void executer() {
        compagnieAerienne.ouvrirReservations(vol);
    }
}