package gestionvol;

import java.util.List;

public interface VolFactory {
	Vol creerVol(int numVol, int places, String heureDepart, String heureArrivee, 
			Aeroport aeroportDepart, Aeroport aeroportArrive, List<Escale> escales);

}
