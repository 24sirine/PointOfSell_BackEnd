package dynamix_services.services;

import java.util.List;


import dynamix_services.entities.AssocCommande_article_PK;
import dynamix_services.entities.LigCom;

public interface ILigComService {
	public LigCom ajouterLigneCom (LigCom l);
	public void supprimerLigneCom (LigCom l);
	public void supprimerLigneComById( AssocCommande_article_PK id);
	public  List<LigCom > afficherTousLignes() ;
	public List<LigCom> afficherLignesParCode(String code);

	
	
}
