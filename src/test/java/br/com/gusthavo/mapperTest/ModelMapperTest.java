package br.com.gusthavo.mapperTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.meanbean.test.BeanTester;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.gusthavo.dto.ClientDTO;

@ExtendWith(MockitoExtension.class)
public class ModelMapperTest {
	
	@Test
	@DisplayName("test getters e setters from clientDTO")
	void clientDtoTest() {
		BeanTester beanTester = new BeanTester();
		beanTester.testBean(ClientDTO.class);
	}
	
}
