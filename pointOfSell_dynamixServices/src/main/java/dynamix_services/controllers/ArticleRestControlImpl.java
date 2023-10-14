package dynamix_services.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dynamix_services.entities.Article;

import dynamix_services.services.IArticleService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ArticleRestControlImpl {
@Autowired
IArticleService articleservice;



//http://localhost:8083/SpringMVC/servlet/afficher-tous-Articles
@GetMapping("/afficher-tous-Articles")
public List<Article> afficherTousArticles() {
List<Article> list = articleservice.afficherListeArticles();
return list;
} 

//http://localhost:8083/SpringMVC/servlet/afficherLibelleArticle/{code}
@GetMapping("/afficherLibelleArticle/{code}")
public String afficherLibelleArticle(@PathVariable("code") String code)
{ return articleservice. findLibelleByCode( code)	;
}

//http://localhost:8083/SpringMVC/servlet/afficherStockArticle/{code}
@GetMapping("/afficherStockArticle/{code}")
public int afficherQteStockArticle(@PathVariable("code") String code)
{ return articleservice.findQteStockByCode(code);
}


  //http://localhost:8083/SpringMVC/servlet/afficherImgArticle/{code}
 
@GetMapping("/afficherImgArticle/{code}")
public String afficherImgArticle(@PathVariable("code") String code)
{ return articleservice.findUrlByCode( code)	;
}

//http://localhost:8083/SpringMVC/servlet/afficherDescription/{code}
@GetMapping("/afficherDescription/{code}")
public String afficherDescriptionArticle(@PathVariable("code") String code)
{ return articleservice.findDescriptionByCode(code)	;
}

//http://localhost:8083/SpringMVC/servlet/afficherPrix/{code}
@GetMapping("/afficherPrix/{code}")
public float afficherPrixArticle(@PathVariable("code") String code)
{ return articleservice.findprixUnitaireByCode(code);
}

//http://localhost:8083/SpringMVC/servlet/afficherRemise/{code}
@GetMapping("/afficherRemise/{code}")
public float afficherRemiseArticle(@PathVariable("code") String code)
{ return articleservice.findremiseByCode(code);
}



//http://localhost:8083/SpringMVC/servlet/changer_qtedispo/{code}/{qteEnleve}
@PutMapping("/changer_qtedispo/{code}/{qteEnleve}")
@ResponseBody
public int ChangerQteDispo(@PathVariable("code")String code,@PathVariable("qteEnleve")int qteEnleve) {
return articleservice.changerQteStock(code, qteEnleve);

}
}
