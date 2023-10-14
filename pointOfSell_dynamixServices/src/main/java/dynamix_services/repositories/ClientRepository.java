package dynamix_services.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dynamix_services.entities.Client;

@Repository

public interface ClientRepository extends CrudRepository<Client, Long>{

}
