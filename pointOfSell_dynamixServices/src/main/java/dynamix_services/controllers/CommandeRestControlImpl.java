package dynamix_services.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dynamix_services.entities.Client;
import dynamix_services.entities.Commande;

import dynamix_services.services.IClientService;
import dynamix_services.services.ICommandeService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CommandeRestControlImpl {
@Autowired 
ICommandeService cmdService;
IClientService cltService;
//http://localhost:8083/SpringMVC/servlet/afficher-tous-Commandes
	@GetMapping("/afficher-tous-Commandes")
	public List<Commande> afficherTousCommandes() {
	List<Commande> list = cmdService.afficherListeCommande();
	return list;
	}
	
	//http://localhost:8083/SpringMVC/servlet/afficher-date-commande/{commande_id}
		@GetMapping("/afficher-date-commande/{commande_id}")
		public Date afficherDateCmd(@PathVariable("commande_id")int commande_id) {
		Date d = cmdService.getdateparCommande(commande_id);
		return d;
		}
		//http://localhost:8083/SpringMVC/servlet/afficher-caisse-today
				@GetMapping("afficher-caisse-today")
				public Float afficherCaisseToday() {
				Float f = cmdService.getSumOfPaymentsForToday();
				return f;
				}
	
	//http://localhost:8083/SpringMVC/servlet/afficher-cmdOuvertes
		@GetMapping("/afficher-cmdOuvertes")
		public List<Commande> afficherCommandesOuvertes() {
		List<Commande> list = cmdService.afficherCommandeOuvertes();
		return list;
		}
		
		//http://localhost:8083/SpringMVC/servlet/afficher-cmdSuspendu
				@GetMapping("/afficher-cmdSuspendu")
				public List<Commande> afficherCommandesSuspendu() {
				List<Commande> list = cmdService.afficherCommandeSuspendu();
				return list;
				}
				//http://localhost:8083/SpringMVC/servlet/afficher-cmdValide
				@GetMapping("/afficher-cmdValide")
				public List<Commande> afficherCommandesValides() {
				List<Commande> list = cmdService.afficherCommandeValidees();
				return list;
				}
		
			//http://localhost:8083/SpringMVC/servlet/add-commande
			@PostMapping("/add-commande")
			@ResponseBody
			public Commande addCommande(@RequestBody Commande c) {
				Client clt =new Client(1,"passager");
				
			c.setClt(clt);
		
				
			        return cmdService.ajouterCommande(c);
			   
			  
			
			}
			
			//http://localhost:8083/SpringMVC/servlet/valider-commande-status/{commande_id}
			@PutMapping("/valider-commande-status/{commande_id}")
			@ResponseBody
			public Commande ValiderCommandeStatus(@PathVariable("commande_id")int commande_id) {
			return cmdService.StatusValide(commande_id);
			
			}
			
			//http://localhost:8083/SpringMVC/servlet/suspendre-commande-status/{commande_id}
			@PutMapping("/suspendre-commande-status/{commande_id}")
			@ResponseBody
			public Commande SuspendreCommandeStatus(@PathVariable("commande_id")int commande_id) {
			 return cmdService.StatusSuspendu(commande_id);
			
			}
			//http://localhost:8083/SpringMVC/servlet/paiement-visa/{commande_id}
			@PutMapping("/paiement-visa/{commande_id}")
			@ResponseBody
			public Commande paiementVisa(@PathVariable("commande_id")int commande_id) {
			 return cmdService.methodepaiementVisa(commande_id);
			
			}
			//http://localhost:8083/SpringMVC/servlet/paiement-mastercard/{commande_id}
			@PutMapping("/paiement-mastercard/{commande_id}")
			@ResponseBody
			public Commande paiementMasterCard(@PathVariable("commande_id")int commande_id) {
			 return cmdService.methodepaiementMastercard(commande_id);
			
			}
			//http://localhost:8083/SpringMVC/servlet/paiement-cheque/{commande_id}
			@PutMapping("/paiement-cheque/{commande_id}")
			@ResponseBody
			public Commande paiementCheque(@PathVariable("commande_id")int commande_id) {
			 return cmdService.methodepaiementCheque(commande_id);
			
			}
			//http://localhost:8083/SpringMVC/servlet/paiement-cash/{commande_id}
			@PutMapping("/paiement-cash/{commande_id}")
			@ResponseBody
			public Commande paiementCash(@PathVariable("commande_id")int commande_id) {
			 return cmdService.methodepaiementCash(commande_id);
			
			}
			//http://localhost:8083/SpringMVC/servlet/paiement-edinards/{commande_id}
			@PutMapping("/paiement-edinards/{commande_id}")
			@ResponseBody
			public Commande paiementEdinards(@PathVariable("commande_id")int commande_id) {
			 return cmdService.methodepaiementeDinards(commande_id);
			
			}
			//http://localhost:8083/SpringMVC/servlet/paiement/{commande_id}/{paiement}
			@PutMapping("/paiement/{commande_id}/{paiement}")
			@ResponseBody
			public Commande paiement(@PathVariable("commande_id")int commande_id,@PathVariable("paiement")float paiement) {
				
			 return cmdService.paiement(commande_id, paiement);
			
			}
		
			}
			
			

