package br.com.gusthavo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.gusthavo.repository.ClientRepository;

@Configuration
public class ClientConfing implements CommandLineRunner{
	@SuppressWarnings("unused")
	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public void run(String... args) throws Exception {
	/*	
		Client c1 = new Client(null, "Gusthavo", "gusthavo@gmail.com", "RO", "69992584270");
		Client c2 = new Client(null, "Jamile", "jamile@gmail.com", "RO", "69992537474");
		clientRepository.saveAll(Arrays.asList(c1,c2));
		*/
	}

}
