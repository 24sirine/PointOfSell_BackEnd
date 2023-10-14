package dynamix_services.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import dynamix_services.entities.caissier;

@Repository
public interface CaissierRepository extends CrudRepository<caissier, Long>{
	//chercher le caissier avec son email
	@Query(value="SELECT * FROM T_CAISSIERS c WHERE c.CAISSIERS_EMAIL=?1 ",nativeQuery=true)
	caissier findByCaissierEmail(String email);

	//chercher le caissier avec son mot de passe
	@Query(value="SELECT * FROM T_CAISSIERS c WHERE c.CAISSIERS_PASSWORD=?1 ",nativeQuery=true)
	caissier findByCaissierMdp(String mdp);
	
}
