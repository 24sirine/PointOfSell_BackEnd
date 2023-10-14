package dynamix_services.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dynamix_services.entities.Commande;
@Repository
public interface CommandeRepository extends CrudRepository <Commande,Long>{
	@Query(value="SELECT l FROM Commande l  WHERE l.statu= 'ouverte' ")
	List<Commande> retreiveCommandeOuverte();
	
	@Query(value="SELECT l FROM Commande l  WHERE l.statu= 'validée' ")
	List<Commande> retreiveCommandeValide();
	
	@Query(value="SELECT l FROM Commande l  WHERE l.statu= 'Suspendu' ")
	List<Commande> retreiveCommandeSuspendu();

	List<Commande> findByDatecmd(LocalDate datecmd);
	
	
	
}
