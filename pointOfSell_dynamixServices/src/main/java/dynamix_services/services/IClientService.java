package dynamix_services.services;

import java.util.List;

import dynamix_services.entities.Client;

public interface IClientService {
public Client ajouterClient (Client c);
public void supprimerClient (Client c);
public void supprimerclientById(int id);
public Client modifierClient(Client c , long i);
public List<Client> afficherListeClients();
public  Client getClientById(int id);

}
