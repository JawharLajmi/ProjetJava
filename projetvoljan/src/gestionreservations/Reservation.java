package gestionreservations;

import gestionclients.Passager;
import gestionvol.Vol;

public class Reservation {
    private Passager passager;
    private Vol vol;
    private String status = "En attente";
    private int prix = 1000;
    
    
    public Reservation(Passager passager, Vol vol) {
        this.passager = passager;
        this.vol = vol;
    }
    
    public int getPrix() {
    	return this.prix;
    }
    public void setPrix(int prix) {
    	this.prix = prix ;
    }

    public void accepter() {
    	if (vol.getPlaces()==0) {
    		this.refuser();
    	}
    	else {
        this.status = "Accepté";
        vol.setPlaces(vol.getPlaces()-1);
        System.out.println("La réservation " + this + "  a été acceptée.");
    }
    }

    public Passager getPassager() {
		return passager;
	}

	public void setPassager(Passager passager) {
		this.passager = passager;
	}

	public Vol getVol() {
		return vol;
	}

	public void setVol(Vol vol) {
		this.vol = vol;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void refuser() {
        this.status = "Refusé";
        System.out.println("La réservation " + this + " a été refusée.");
    }
}