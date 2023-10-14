package dynamix_services.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dynamix_services.entities.Article;

import dynamix_services.repositories.ArticleRepository;

@Service
public class ArticleService implements IArticleService{
@Autowired
ArticleRepository articlerepo;	
	
	public ArticleService() {}
	
	@Override
	public List<Article> afficherListeArticles() {
		
		return (List<Article>) articlerepo.findAll();
	}
	public Article ajouterArticle (Article a) {
		return articlerepo.save(a);
	}
	public Article findArticleById(String code)
	{  Optional<Article> optionalArticle = articlerepo.findById( code);  
       return optionalArticle.get();
      }
	//cette méthode permet de trouver le libellé de l'article à partir de son code
	public String findLibelleByCode(String code) {
	    Optional<Article> optionalArticle = articlerepo.findById( code);
	    if (optionalArticle.isPresent()) {
	        Article article = optionalArticle.get();
	        return article.getLibelle();
	    } else {
	       
	        return "Article non trouvé";
	    }
	
	}
	//cette méthode permet de trouver l'image de l'article à partir de son code
	public String findUrlByCode(String code)
	{
		Optional<Article> optionalArticle = articlerepo.findById( code);
	    if (optionalArticle.isPresent()) {
	        Article article = optionalArticle.get();
	        return article.getUrlPhoto();
	    } else {
	       
	        return "Article non trouvé";
	    }	
	}
	//cette méthode permet de trouver la quantité de stock de l'article à partir de son code
	public int findQteStockByCode ( String code )
	{Optional<Article> optionalArticle = articlerepo.findById( code);
	 if (optionalArticle.isPresent()) {
	        Article article = optionalArticle.get();
	        return article.getQteStock();
	    } else {
	       
	        return 0 ;
	    }
		}
	//cette méthode permet de trouver la description de l'article à partir de son code
	public String findDescriptionByCode(String code )
	{Optional<Article> optionalArticle = articlerepo.findById( code);
	 if (optionalArticle.isPresent()) {
	        Article article = optionalArticle.get();
	        return article.getDescription();
	    } else {
	       
	        return "Article non trouvé" ;
	    }}
	//cette méthode permet de trouver le prix unitaire de l'article à partir de son code
	public float findprixUnitaireByCode(String code )
	{Optional<Article> optionalArticle = articlerepo.findById( code);
	 if (optionalArticle.isPresent()) {
	        Article article = optionalArticle.get();
	   
	        return article.getPrixUnitaire();
	    } else {
	       
	        return 0 ;
	    }}
	//cette méthode permet de trouver la remise de l'article à partir de son code
	public float findremiseByCode(String code )
	{Optional<Article> optionalArticle = articlerepo.findById( code);
	 if (optionalArticle.isPresent()) {
	        Article article = optionalArticle.get();
	        return article.getRemise();
	    } else {
	       
	        return 0 ;
	    }}
	//cette méthode permet d'enlever la qte de stock deja commandé
	public int changerQteStock ( String code , int qteEnleve)
	{Optional<Article> optionalArticle = articlerepo.findById( code);
	 if (optionalArticle.isPresent()) {
	        Article article = optionalArticle.get();
	      
	        article.setQteStock((article.getQteStock())-qteEnleve);
	        articlerepo.save(article);
	        return article.getQteStock();
	}
	 else {return 0;}
	}

}
