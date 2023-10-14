package dynamix_services.services;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dynamix_services.entities.Commande;
import dynamix_services.repositories.CommandeRepository;
@Service
public class CommandeService implements ICommandeService {
	@Autowired
	CommandeRepository cmdrepo ;
	CommandeService(){}
	public Commande ajouterCommande (Commande c) {
		return cmdrepo.save(c);
	}
	public List<Commande> afficherListeCommande() {
		return (List<Commande>) cmdrepo.findAll();
	}
	public Commande findCommandeById(int id_commande) {  
		Optional<Commande> optionalcmd = cmdrepo.findById((long) id_commande);  
	return optionalcmd.get();
	}

	public List<Commande> afficherCommandeOuvertes()
	{return cmdrepo.retreiveCommandeOuverte();}
	public List<Commande> afficherCommandeSuspendu()
	{ return cmdrepo.retreiveCommandeSuspendu();}
	public List<Commande> afficherCommandeValidees()
	{ return cmdrepo.retreiveCommandeValide();}
	
	@Override
	public Commande StatusValide(int id_commande) {
		Commande c = cmdrepo.findById((long) id_commande).get();
		c.setStatu("validée");
	return	cmdrepo.save(c);
		
	}
	
	public Commande paiement(int id_commande,float paiement)
	{
		Commande c = cmdrepo.findById((long)id_commande).get();
		c.setPaiement(paiement);
		return cmdrepo.save(c); 
	}
	public Commande methodepaiementVisa(int id_commande)
	{ Commande c =cmdrepo.findById((long)id_commande).get();
	c.setMoyenPaiement("visa");
		return cmdrepo.save(c);
		
	}
	
	public Commande methodepaiementMastercard(int id_commande)
	{
		Commande c =cmdrepo.findById((long)id_commande).get();
		c.setMoyenPaiement("mastercard");
			return cmdrepo.save(c);	
	}
	public Commande methodepaiementCheque(int id_commande) {
		Commande c =cmdrepo.findById((long)id_commande).get();
		c.setMoyenPaiement("cheque");
			return cmdrepo.save(c);
	}
	public Commande methodepaiementCash(int id_commande)
	{Commande c =cmdrepo.findById((long)id_commande).get();
	c.setMoyenPaiement("cash");
	return cmdrepo.save(c);}
	public Commande methodepaiementeDinards(int id_commande)
	{Commande c =cmdrepo.findById((long)id_commande).get();
	c.setMoyenPaiement("edinards");
	return cmdrepo.save(c);}
	public Commande StatusSuspendu(int id_commande)
	{
		Commande c = cmdrepo.findById((long) id_commande).get();
		c.setStatu("Suspendu");
		return cmdrepo.save(c);
		
	}
	public Date getdateparCommande(int id_commande)
	{Commande c = cmdrepo.findById((long) id_commande).get();
	return c.getDatecmd();
	}

	public Float getSumOfPaymentsForToday() {
        LocalDate today = LocalDate.now();
        List<Commande> ordersToday = cmdrepo.findByDatecmd(today);
        Float sum = 0.0f;

        for (Commande order : ordersToday) {
            if (order.getPaiement() != null) {
                sum += order.getPaiement();
            }
        }

        return sum;
    }
	
}
