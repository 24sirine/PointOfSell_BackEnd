package dynamix_services.services;
import java.sql.Date;
import java.util.List;
import dynamix_services.entities.Commande;


public interface ICommandeService {
	public Commande ajouterCommande (Commande c);
	public List<Commande> afficherListeCommande();
	public Commande findCommandeById(int id_commande);
	public Commande StatusValide(int id_commande);
	public Commande StatusSuspendu(int id_commande);
	public List<Commande> afficherCommandeOuvertes();
	public List<Commande> afficherCommandeSuspendu();
	public List<Commande> afficherCommandeValidees();
	public Commande methodepaiementVisa(int id_commande);
	public Commande methodepaiementMastercard(int id_commande);
	public Commande methodepaiementCheque(int id_commande);
	public Commande methodepaiementCash(int id_commande);
	public Commande methodepaiementeDinards(int id_commande);
	
	public Date getdateparCommande(int id_commande);
	public Commande paiement(int id_commande , float paiement);
	public Float getSumOfPaymentsForToday();
}
