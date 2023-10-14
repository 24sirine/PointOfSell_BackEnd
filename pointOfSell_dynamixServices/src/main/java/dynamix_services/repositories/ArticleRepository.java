package dynamix_services.repositories;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dynamix_services.entities.Article;

@Repository
public interface ArticleRepository extends CrudRepository<Article, String>{


}
