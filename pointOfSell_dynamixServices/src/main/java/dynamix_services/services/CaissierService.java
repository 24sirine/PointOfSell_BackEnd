package dynamix_services.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DButil.DButil;
import dynamix_services.entities.caissier;
import dynamix_services.repositories.CaissierRepository;




@Service
public class CaissierService implements ICaissierService {
	@Autowired
	CaissierRepository  CaissierRepository;
	Connection connection ;
	int flag = 0; 
	public CaissierService() throws SQLException {
		connection = DButil.getConnection();
		
	}
	
	

	@Override
	public int validateCaissier( String email ,  String mdp ) {
		
		try {
			PreparedStatement statement = connection.prepareStatement(" SELECT * FROM T_CAISSIERS  WHERE   CAISSIERS_EMAIL='" + email+"'  and CAISSIERS_PASSWORD='" + mdp+"'   " );
			ResultSet rs = statement.executeQuery();
		
			while (rs.next())
			{ if ( rs.getString(2).equals(email)  && rs.getString(3).equals(mdp)  )
				{flag =1;
				}
			else {System.out.println("Données non Valides");
			flag=0;}
				}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	return flag ;}
	
	
public void ajouterCaissier(caissier a) {
		
		CaissierRepository.save(a); 
	}
}
