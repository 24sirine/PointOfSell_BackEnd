package dynamix_services.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dynamix_services.entities.Magasin;
import dynamix_services.services.IMagasinService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MagasinRestControlImpl {
	@Autowired
	IMagasinService magasinService;
	
	//http://localhost:8083/SpringMVC/servlet/afficher-tous-Magasins
	@GetMapping("/afficher-tous-Magasins")
	public List<Magasin> afficherTousMagasins() {
	List<Magasin> list = magasinService.afficherTousMagasins();
	return list;
	} 
}
