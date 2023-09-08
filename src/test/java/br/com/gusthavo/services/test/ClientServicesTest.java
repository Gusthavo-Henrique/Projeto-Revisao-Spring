package br.com.gusthavo.services.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import br.com.gusthavo.dto.ClientDTO;
import br.com.gusthavo.entity.Client;
import br.com.gusthavo.repository.ClientRepository;
import br.com.gusthavo.services.ClientServices;

@ExtendWith(MockitoExtension.class)
class ClientServicesTest {
	
	@InjectMocks
	private ClientServices services;
	
	@Mock
	private ModelMapper mapper;

	@Mock
	private ClientRepository repository;
	

	@Test
	@DisplayName("encontrar id com sucesso")
	void findByIdSuccess() {
		Client client;
		client = new Client();
		client.setId(1L);
		client.setName("Gusthavo");
		client.setEmail("gusthavo@gmail.com");
		client.setAddress("RO");
		client.setPhone("69992584270");
		
		when(repository.findById(client.getId())).thenReturn(Optional.of(client));
		
		ClientDTO clients = services.findById(client.getId());
		
		assertEquals(mapper.map(Optional.of(client), ClientDTO.class), clients);
		verify(repository).findById(client.getId());
		verifyNoMoreInteractions(repository);
	}

}
