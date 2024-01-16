package test;

import gestionclients.Client;
import gestionclients.CreateurClients;
import gestionclients.Passager;
import gestionreservations.AccepterReservationCommand;
import gestionreservations.AssuranceBagage;
import gestionreservations.AssuranceMedicale;
import gestionreservations.Command;
import gestionreservations.FermerReservationsCommand;
import gestionreservations.GestionnaireCommandes;
import gestionreservations.OuvrirReservationsCommand;
import gestionreservations.RefuserReservationCommand;
import gestionreservations.Reservation;
import gestionvol.Aeroport;
import gestionvol.CompagnieAerienne;
import gestionvol.Escale;
import gestionvol.Vol;
import gestionvol.VolFactory;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
        // Création de la compagnie aérienne
        CompagnieAerienne compagnieAerienne = new CompagnieAerienne("Airline");

        // Création du gestionnaire de commandes
        GestionnaireCommandes gestionnaireCommandes = new GestionnaireCommandes();

        // Création des aéroports
        Aeroport aeroport1 = new Aeroport("Aeroport1", "Ville1");
        Aeroport aeroport2 = new Aeroport("Aeroport2", "Ville2");

        // Création des vols
        Vol vol1 = compagnieAerienne.creerVol(1, 100, "10:00", "12:00", aeroport1, aeroport2, new ArrayList<>());
        Vol vol2 = compagnieAerienne.creerVol(2, 50, "14:00", "16:00", aeroport2, aeroport1, new ArrayList<>());
        
        // Création du créateur de clients
        CreateurClients createurClients = CreateurClients.getInstance();

        // Création de clients
        Client client1 = createurClients.creerPersonnePhysique("Client1", "CIN1");
        Client client2 = createurClients.creerPersonneMorale("Client2", "CIN2","Raison Sociale");

        // Ajout de clients à la compagnie aérienne
        compagnieAerienne.ajouterClient(client1);
        compagnieAerienne.ajouterClient(client2);

        // Création de passagers
        Passager passager1 = createurClients.creerPassager("Passager1", "CINPassager1");
        Passager passager2 = createurClients.creerPassager("Passager2", "CINPassager2");

        // Création de commandes pour ouvrir les réservations
        Command ouvrirReservationsCommand1 = new OuvrirReservationsCommand(compagnieAerienne, vol1);
        Command ouvrirReservationsCommand2 = new OuvrirReservationsCommand(compagnieAerienne, vol2);

        // Ajout des commandes au gestionnaire de commandes
        gestionnaireCommandes.ajouterCommande(ouvrirReservationsCommand1);
        gestionnaireCommandes.ajouterCommande(ouvrirReservationsCommand2);

        // Exécution des commandes
        gestionnaireCommandes.executerCommandes();
        
        // Création de réservations
        Reservation reservation1 = client1.creerReservation(passager1, vol1);
        Reservation reservation2 = client2.creerReservation(passager2, vol2);

        // Création de commandes pour accepter et refuser des réservations
        Command accepterReservationCommand = new AccepterReservationCommand(reservation1);
        Command refuserReservationCommand = new RefuserReservationCommand(reservation2);

        // Ajout des commandes au gestionnaire de commandes
        gestionnaireCommandes.ajouterCommande(accepterReservationCommand);
        gestionnaireCommandes.ajouterCommande(refuserReservationCommand);

        // Exécution des commandes
        gestionnaireCommandes.executerCommandes();

        // Affichage du statut mis à jour des réservations après acceptation et refus
        System.out.println("Statut de la réservation pour le passager 1 après acceptation : " + reservation1.getStatus());
        System.out.println("Statut de la réservation pour le passager 2 après refus : " + reservation2.getStatus());

        // Ajout d'assurances aux réservations
        Reservation reservationAvecAssurance1 = new AssuranceMedicale(reservation1);
        
        // Affichage du prix des réservations avec assurances
        System.out.println("Prix de la réservation 1 avec assurances medicale : " + reservationAvecAssurance1.getPrix());
        Reservation reservationAvecAssurance2 = new AssuranceBagage(reservationAvecAssurance1);
        // Affichage du prix des réservations avec assurances
        System.out.println("Prix de la réservation 1 avec assurance medicale et bagage : " + reservationAvecAssurance2.getPrix());
        
        
        
        // Fermeture des réservations
        Command fermerReservationsCommand1 = new FermerReservationsCommand(compagnieAerienne, vol1);
        Command fermerReservationsCommand2 = new FermerReservationsCommand(compagnieAerienne, vol2);

        // Ajout des commandes au gestionnaire de commandes
        gestionnaireCommandes.ajouterCommande(fermerReservationsCommand1);
        gestionnaireCommandes.ajouterCommande(fermerReservationsCommand2);

        // Exécution des commandes
        gestionnaireCommandes.executerCommandes();

	}
}