package dynamix_services.services;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import dynamix_services.entities.Client;
import dynamix_services.entities.caissier;








@Component
public class StartupDataInitializer implements CommandLineRunner{

		 
	  private final ClientService cltser;
	  private final CaissierService caissierser ;
		    public StartupDataInitializer( ClientService cltser , CaissierService caissierser) {
		       this.caissierser=caissierser ;       
		      this.cltser=cltser; 
		    } 
	@Override
	public void run(String... args) throws Exception {
		
		caissier c = new caissier();
	     c.setEmail("sirine.bourbiaa11@gmail.com");
	     c.setMdp("123");
	     caissierser.ajouterCaissier(c);
		
		
		
	    // Vérifier si le client existe déjà dans la base de données
	    Client existingClient = cltser.getClientById(95); 
    
	    if (existingClient == null) {
	        // Le client n'existe pas, vous pouvez l'ajouter
	        Client c1 = new Client();
	        c1.setId(95);
	        c1.setName("passager");
	        cltser.ajouterClient(c1); 
	    } else {
	        // Le client existe déjà dans la base de données
	        System.out.println("Le client existe déjà dans la base de données.");
	    }
	}}
