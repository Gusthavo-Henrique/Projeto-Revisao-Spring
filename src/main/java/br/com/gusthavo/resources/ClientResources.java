package br.com.gusthavo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gusthavo.dto.ClientDTO;
import br.com.gusthavo.entity.Client;
import br.com.gusthavo.services.ClientServices;

@RestController
@RequestMapping(value = "/api/client")
public class ClientResources {
	
	@Autowired
	private ClientServices services; 
	
	@GetMapping
	public List<ClientDTO> findAll() {
		return services.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public ClientDTO findById(@PathVariable(value = "id") Long id) {
		return services.findById(id);
	}
	@PostMapping
	public ClientDTO create(@RequestBody Client obj) {
		return services.create(obj);
	}
	@PutMapping(value = "/{id}")
	public ClientDTO update(@RequestBody Client obj, @PathVariable(value = "id") Long id) {
		return services.upadte(obj);
	}
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable(value = "id") Long id) {
		services.delete(id);
	}
}
