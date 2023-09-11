package br.com.gusthavo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import br.com.gusthavo.dto.ClientDTO;
import br.com.gusthavo.entity.Client;
import br.com.gusthavo.repository.ClientRepository;
import br.com.gusthavo.resources.ClientResources;
import br.com.gusthavo.services.exceptions.ClientIdNotFoundException;

@Service
public class ClientServices {

	@Autowired
	private ClientRepository repository;
	
	@Autowired
	private ModelMapper mapper;

	public List<ClientDTO> findAll() {
		List<Client> client = repository.findAll();
		List<ClientDTO> clientdto = client.stream().map(entity -> mapper.map(entity, ClientDTO.class)).collect(Collectors.toList());
		clientdto.stream().forEach(p -> p.add(linkTo(methodOn(ClientResources.class).findById(p.getId())).withSelfRel()));
		return clientdto;
	}

	public ClientDTO findById(Long id) {
		var obj = repository.findById(id).orElseThrow(() -> new ClientIdNotFoundException("Not found client"));
		var entity = mapper.map(obj, ClientDTO.class);
		var dto = entity.add(linkTo(methodOn(ClientResources.class).findById(id)).withSelfRel());
		return dto;
	}

	public ClientDTO create(Client obj) {
		var entity = repository.save(obj);
		var entitydto = mapper.map(entity, ClientDTO.class);
		var dto = entitydto.add(linkTo(methodOn(ClientResources.class).findById(obj.getId())).withSelfRel());
		return dto;
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
		var dto = mapper.map(entity, ClientDTO.class).add(linkTo(methodOn(ClientResources.class).findById(obj.getId())).withSelfRel());
		return dto;
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
}
