package dynamix_services.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dynamix_services.entities.Magasin;
import dynamix_services.repositories.MagasinRepository;
@Service
public class MagasinService implements IMagasinService{
	@Autowired
	MagasinRepository MagasinRepository;
	public  List<Magasin > afficherTousMagasins() 
	{return (List<Magasin>) MagasinRepository.findAll();}
}
