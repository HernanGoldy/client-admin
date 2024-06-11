package com.bit.client_admin.service;

import com.bit.client_admin.service.dto.AddressVerifyDTO;
import com.bit.client_admin.service.dto.ClientDTO;

import java.util.List;

public interface IClientService {

    // Find all clients
    List<ClientDTO> findAll();

    // Find client by id
    ClientDTO findById(Long id);

    // Create client
    ClientDTO createClient(ClientDTO clientDTO);

    // Update client
    ClientDTO updateClient(ClientDTO clientDTO, Long id);

    // Delete client
    String deleteClient(Long id);

    // Verify address
    String verifyAddress(AddressVerifyDTO addressVerifyDTO);
}
