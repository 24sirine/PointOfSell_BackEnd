package dynamix_services.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dynamix_services.services.ICaissierService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CaissierRestControlImpl {
	
	@Autowired
	private ICaissierService caissierService ;
	//http://localhost:8083/SpringMVC/servlet/caissier/{email}/{mdp}
	@GetMapping("caissier/{email}/{mdp}")
	public int caissierLogin(@PathVariable("email") String email ,  @PathVariable("mdp") String mdp )
	 {	
		int flag = caissierService.validateCaissier( email , mdp );
		if (flag ==0) {return 0 ;}
		else return flag ; 
		

	 }
	}
