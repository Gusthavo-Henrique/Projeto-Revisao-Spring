package br.com.gusthavo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gusthavo.dto.ClientDTO;
import br.com.gusthavo.entity.Client;
import br.com.gusthavo.repository.ClientRepository;
import br.com.gusthavo.services.exceptions.ClientIdNotFoundException;

@Service
public class ClientServices {

	@Autowired
	private ClientRepository repository;
	
	@Autowired
	private ModelMapper mapper;

	public List<ClientDTO> findAll() {
		List<Client> client = repository.findAll();
		return client.stream().map(entity -> mapper.map(entity, ClientDTO.class)).collect(Collectors.toList());
	}

	public ClientDTO findById(Long id) {
		var obj = repository.findById(id).orElseThrow(() -> new ClientIdNotFoundException("Not found client"));
		var entity = mapper.map(obj, ClientDTO.class);
		return entity;
	}

	public ClientDTO create(Client obj) {
		var entity = repository.save(obj);
		return mapper.map(entity, ClientDTO.class);
	}

	public ClientDTO upadte(Client obj) {
		var entity = repository.findById(obj.getId())
				.orElseThrow(() -> new ClientIdNotFoundException("Not found client"));
		entity.setId(obj.getId());
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setAddress(obj.getAddress());
		entity.setPhone(obj.getPhone());
		repository.save(entity);
		var dto = mapper.map(entity, ClientDTO.class);
		return dto;
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
}
