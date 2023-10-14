package dynamix_services.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dynamix_services.entities.AssocCommande_article_PK;
import dynamix_services.entities.LigCom;


@Repository
public interface LigComRepository  extends CrudRepository <LigCom, AssocCommande_article_PK>{
	@Query(value="SELECT l FROM LigCom l  WHERE l.assoc_PK.code=?1 ")
	List<LigCom> retreiveLignByCode(String code);
}
