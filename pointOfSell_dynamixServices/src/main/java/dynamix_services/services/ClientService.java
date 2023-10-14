package dynamix_services.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dynamix_services.entities.Client;
import dynamix_services.repositories.ClientRepository;
@Service
public class ClientService implements IClientService{
	@Autowired
	ClientRepository ClientRepository;
	public  ClientService() {}
	public Client ajouterClient (Client clt) {
		return ClientRepository.save(clt);
	}
	public void supprimerClient (Client clt) {
		ClientRepository.delete(clt);
	}
	public Client modifierClient(Client c , long i) {
		
		Client clt = ClientRepository.findById(i).get();
		clt.setName(c.getName());
		clt.setAdresse(c.getAdresse());
		clt.setVille(c.getVille());
		clt.setCodePostal(c.getCodePostal());
		clt.setMail(c.getMail());
		clt.setImgClient(c.getImgClient());
		clt.setTel(c.getTel());
		clt.setRegion(c.getRegion());
		return ClientRepository.save(clt);
		
	}
	public List<Client> afficherListeClients() {
		return (List<Client>) ClientRepository.findAll();
	}
	
	public void supprimerclientById(int id) {
		ClientRepository.deleteById((long) id);
	}
	public  Client getClientById(int id) {
		Optional<Client> clientOptional = ClientRepository.findById((long) id);
	        return clientOptional.get();
	    
	}}
	

