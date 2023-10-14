package dynamix_services.services;

import java.util.List;

import dynamix_services.entities.Article;

public interface IArticleService {
	//pour afficher la liste des articles
	public List<Article> afficherListeArticles();
	public Article ajouterArticle(Article a);
	public Article findArticleById(String code);
	public String findLibelleByCode ( String code );
	public String findUrlByCode(String code);
	public int findQteStockByCode ( String code );
	public String findDescriptionByCode( String code );
	public float findprixUnitaireByCode( String code );
	public float findremiseByCode( String code );
	public int changerQteStock ( String code , int qteEnleve);
}
