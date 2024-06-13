package com.bit.client_admin.service;

import com.bit.client_admin.model.Client;
import com.bit.client_admin.service.dto.AddressVerifyDTO;

import java.util.List;

public interface IClientService {

    // Find all clients
    List<Client> findAll();

    // Find client by id
    Client findById(Long id);

    // Create adn update client
    Client createClient(Client client);

    // Delete client
    String deleteClient(Long id);

    // Verify address
    String verifyAddress(AddressVerifyDTO addressVerifyDTO);
}
