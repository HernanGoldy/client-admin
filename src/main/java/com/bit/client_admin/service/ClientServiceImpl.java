package com.bit.client_admin.service;

import com.bit.client_admin.model.Client;
import com.bit.client_admin.repository.IClientRepository;
import com.bit.client_admin.service.dto.AddressVerifyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientServiceImpl implements IClientService {

    @Autowired
    private IClientRepository clientRepository;

    // Find all clients
    @Override
    @Transactional(readOnly = true)
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    // Find client by id
    @Override
    @Transactional(readOnly = true)
    public Client findById(Long id) {
        return clientRepository.findById(id).orElseThrow();
    }

    // Create client
    @Override
    @Transactional
    public Client createClient(Client client) {

        if (client.getId() == null) {
            return clientRepository.save(client);
        } else {
            Client currentClient = clientRepository.findById(client.getId()).orElseThrow();
            currentClient.setFechaAlta(client.getFechaAlta());
            currentClient.setNumeroCliente(client.getNumeroCliente());
            currentClient.setNumeroDocumento(client.getNumeroDocumento());
            currentClient.setApellidos(client.getApellidos());
            currentClient.setNombres(client.getNombres());
            currentClient.setNombreCalle(client.getNombreCalle());
            currentClient.setNumeroCalle(client.getNumeroCalle());
            currentClient.setPiso(client.getPiso());
            currentClient.setDepartamento(client.getDepartamento());
            currentClient.setNombreEdificio(client.getNombreEdificio());
            currentClient.setManzana(client.getManzana());
            currentClient.setCasa(client.getCasa());
            currentClient.setEntreCalle1(client.getEntreCalle1());
            currentClient.setEntreCalle2(client.getEntreCalle2());
            currentClient.setSobreCalle(client.getSobreCalle());
            currentClient.setDescripcionCasa(client.getDescripcionCasa());
            currentClient.setBarrio(client.getBarrio());
            currentClient.setCiudad(client.getCiudad());
            currentClient.setProvincia(client.getProvincia());
            currentClient.setPais(client.getPais());
            currentClient.setCoordenadasGoogleMaps(client.getCoordenadasGoogleMaps());
            currentClient.setTelefonoFijo(client.getTelefonoFijo());
            currentClient.setTelefonoMovil1(client.getTelefonoMovil1());
            currentClient.setTelefonoMovil2(client.getTelefonoMovil2());
            currentClient.setEmail(client.getEmail());
            currentClient.setInstagram(client.getInstagram());
            currentClient.setFacebook(client.getFacebook());

            return clientRepository.save(currentClient);
        }
    }

    // Delete client
    @Override
    @Transactional
    public String deleteClient(Long id) {
        clientRepository.deleteById(id);
        return null;
    }

    // Verify address
    @Override
    public String verifyAddress(AddressVerifyDTO addressVerifyDTO) {

        if (addressVerifyDTO == null) {
            return "No se ha enviado una dirección, por favor ingrese una dirección";
        }

        List<Client> list = clientRepository.existe(addressVerifyDTO.getNombreCalle(),
                String.valueOf(addressVerifyDTO.getNumeroCalle()),
                addressVerifyDTO.getPiso(),
                addressVerifyDTO.getDepartamento(),
                addressVerifyDTO.getNombreEdificio());

        return list.size() == 0
                ? "La dirección no existe en la base de datos"
                : "La dirección ya existe " + list.size() + " veces en la base de datos." ;
    }
}
