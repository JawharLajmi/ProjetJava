package gestionclients;

public interface ClientsFactory {
	Client creerPersonnePhysique(String nom, String cin);
	Client creerPersonneMorale(String nom, String cin,String raisonSociale);
	Passager creerPassager(String noom, String cin);
	
}
