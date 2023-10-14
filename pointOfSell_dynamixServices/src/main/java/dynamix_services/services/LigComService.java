package dynamix_services.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import dynamix_services.entities.AssocCommande_article_PK;
import dynamix_services.entities.LigCom;

import dynamix_services.repositories.LigComRepository;
@Service
public class LigComService implements ILigComService{
	
	@Autowired
	LigComRepository LigneRepository;
	
	public  LigComService() {}
	
	
	public LigCom ajouterLigneCom (LigCom l) {
		return LigneRepository.save(l);
	}
	public void supprimerLigneCom (LigCom l) {
		LigneRepository.delete(l);
	}
	public void supprimerLigneComById( AssocCommande_article_PK id) {
		LigneRepository.deleteById( id);
	}
	public List<LigCom > afficherTousLignes() {
		return (List<LigCom>) LigneRepository.findAll();
	}
	public List<LigCom> afficherLignesParCode(String code) {
		 return LigneRepository.retreiveLignByCode(code);
	
	}
}
