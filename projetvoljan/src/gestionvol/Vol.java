package gestionvol;

import java.util.ArrayList;
import java.util.List;

public class Vol {
    private int numVol, places;
    private String heureDepart, heureArrivee;
    private Aeroport aeroportDepart, aeroportArrive;
    private List<Escale> escales;
    private boolean reservationStatus;

    public Vol(int numVol, int places, String heureDepart, String heureArrivee,
               Aeroport aeroportDepart, Aeroport aeroportArrive) {
        this.numVol = numVol;
        this.places = places;
        this.heureDepart = heureDepart;
        this.heureArrivee = heureArrivee;
        this.aeroportDepart = aeroportDepart;
        this.aeroportArrive = aeroportArrive;
        this.escales = new ArrayList<>();
        this.reservationStatus = false;
    }
    
    public void setPlaces(int places) {
    	this.places=places ;
    }

    public int getNumVol() {
        return numVol;
    }

    public int getPlaces() {
        return places;
    }

    public String getHeureDepart() {
        return heureDepart;
    }

    public String getHeureArrivee() {
        return heureArrivee;
    }

    public Aeroport getAeroportDepart() {
        return aeroportDepart;
    }

    public Aeroport getAeroportArrive() {
        return aeroportArrive;
    }

    public List<Escale> getEscales() {
        return escales;
    }

    public boolean getReservationStatus() {
        return reservationStatus;
    }

    public void ajouterEscale(Escale escale) {
        this.escales.add(escale);
    }

    public void setReservationStatus(boolean status) {
        this.reservationStatus = status;
    }
}
