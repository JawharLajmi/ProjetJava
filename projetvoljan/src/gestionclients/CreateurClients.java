package gestionclients;

public class CreateurClients implements ClientsFactory {
	private static CreateurClients instance= new CreateurClients();
	private CreateurClients() {}
	
	public static CreateurClients getInstance() {
		return instance;
	}

	public Client creerPersonnePhysique(String nom, String cin) {
		// TODO Auto-generated method stub
		return new PersonnePhysique(nom,cin);
	}

	public Client creerPersonneMorale(String nom, String cin, String raisonSociale) {
		// TODO Auto-generated method stub
		return new PersonneMorale(nom,cin,raisonSociale);
	}

	public Passager creerPassager(String nom, String cin) {
		// TODO Auto-generated method stub
		return new Passager(nom,cin);
	}
	
	

}
