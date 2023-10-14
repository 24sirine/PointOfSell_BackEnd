package dynamix_services.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dynamix_services.entities.Magasin;
@Repository
public interface MagasinRepository  extends CrudRepository<Magasin, String>{

}
