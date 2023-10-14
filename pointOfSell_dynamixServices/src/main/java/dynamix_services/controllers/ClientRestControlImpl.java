package dynamix_services.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dynamix_services.entities.Client;
import dynamix_services.services.IClientService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ClientRestControlImpl {
	@Autowired
	IClientService clientService;
	
	
	//http://localhost:8083/SpringMVC/servlet/afficher-tous-clients
	@GetMapping("/afficher-tous-clients")
	public List<Client> afficherTousClients() {
	List<Client> list = clientService.afficherListeClients();
	return list;
	}
	

		
			//http://localhost:8083/SpringMVC/servlet/add-client
			@PostMapping("/add-client")
			@ResponseBody
			public Client addClub(@RequestBody Client c ) {
			return clientService.ajouterClient(c);

			}
			
		
			
			
			//http://localhost:8083/SpringMVC/servlet/modify-client/{id}
			@PutMapping("/modify-client/{id}")
			@ResponseBody
			public Client updateClient(@RequestBody Client c,@PathVariable("id") long id) {
			return clientService.modifierClient(c,id);
			
			}
			
			//http://localhost:8083/SpringMVC/servlet/remove-client/{client-id}
			@DeleteMapping("/remove-client/{client-id}")
			@ResponseBody
			public void removeClient(@PathVariable("client-id") int clientId) {
	
			clientService.supprimerclientById(clientId);
			}
}
