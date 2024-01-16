package gestionvol;

public class Escale {
    private String aeroport;
    private int tempsEscalesEnMinutes;

    public Escale(String aeroport, int tempsEscalesEnMinutes) {
        this.aeroport = aeroport;
        this.tempsEscalesEnMinutes = tempsEscalesEnMinutes;
    }

    public String getAeroport() {
        return aeroport;
    }

    public int getTempsEscalesEnMinutes() {
        return tempsEscalesEnMinutes;
    }

    // Autres méthodes, getters, setters, etc.
}
