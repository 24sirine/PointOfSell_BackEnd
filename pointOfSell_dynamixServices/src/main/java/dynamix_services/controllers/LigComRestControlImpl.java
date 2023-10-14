package dynamix_services.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dynamix_services.entities.Article;
import dynamix_services.entities.AssocCommande_article_PK;
import dynamix_services.entities.Commande;
import dynamix_services.entities.LigCom;
import dynamix_services.services.IArticleService;
import dynamix_services.services.ICommandeService;
import dynamix_services.services.ILigComService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LigComRestControlImpl {
@Autowired
ILigComService ligComService;
@Autowired
ICommandeService commandeService ;
@Autowired
IArticleService articleService ;
private static int lastId = 0;
//http://localhost:8083/SpringMVC/servlet/afficher-tous-Lignes
@GetMapping("/afficher-tous-Lignes")
public List<LigCom> afficherTousLignes() {
	
	List<LigCom>  list = ligComService.afficherTousLignes();
return list;
}
//http://localhost:8083/SpringMVC/servlet/afficher-LigneParcode/{code}
@GetMapping("/afficher-LigneParcode/{code}")
public List<LigCom> afficherLignesParCode( @PathVariable String code) {
	
	List<LigCom>  list = ligComService.afficherLignesParCode(code);
return list;
}
//http://localhost:8083/SpringMVC/servlet/add-Lig-comm/{code}/{id_commande}
@PostMapping("/add-Lig-comm/{code}/{id_commande}")
@ResponseBody
public LigCom addLigComm(@RequestBody LigCom l, @PathVariable String code, @PathVariable int id_commande) {
	  AssocCommande_article_PK ass= new   AssocCommande_article_PK(code,id_commande);
	
ass.setId_Ass(lastId++);
	   l.setAssoc_PK(ass);
	   Article a = articleService.findArticleById(code);
    Commande c = commandeService.findCommandeById(id_commande);
    l.setEtArticle(a);
    l.setEtCommande(c);
  
    // Enregistrer la ligne de commande avec les associations appropriées
    return ligComService.ajouterLigneCom(l);
}

		//http://localhost:8083/SpringMVC/servlet/remove-Lig-comm/{ligCom-id}
		@DeleteMapping("/remove-Lig-comm/{ligCom-id}")
		@ResponseBody
		public void removeLigComm(@PathVariable("ligCom-id")AssocCommande_article_PK id) {

		ligComService.supprimerLigneComById(id);
		}
}
