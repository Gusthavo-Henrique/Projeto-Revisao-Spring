package br.com.gusthavo.dto;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import br.com.gusthavo.entity.Client;

public class ClientDTO extends RepresentationModel<ClientDTO> implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String email;
	private String Address;
	private String phone;
	
	public ClientDTO() {
		
	}
	
	public ClientDTO(Client client) {
		super();
		id = client.getId();
		name = client.getName();
		email = client.getEmail();
		Address = client.getAddress();
		phone = client.getPhone();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Address, email, id, name, phone);
	}

	
}
