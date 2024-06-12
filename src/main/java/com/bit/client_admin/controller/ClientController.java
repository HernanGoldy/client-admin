package com.bit.client_admin.controller;

import com.bit.client_admin.model.Client;
import com.bit.client_admin.service.IClientService;
import com.bit.client_admin.service.dto.AddressVerifyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private IClientService clientService;

    // Find all clients
    // http://localhost:8080/client/find
    @GetMapping("/find")
    public ResponseEntity<List<Client>> findAll() {
        return new ResponseEntity<>(this.clientService.findAll(), HttpStatus.OK);
    }

    // Find client by id
    // http://localhost:8080/client/find/1
    @GetMapping("/find/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id) {
        return new ResponseEntity<>(this.clientService.findById(id), HttpStatus.OK);
    }

    // Create client
    // http://localhost:8080/client/create
    @PostMapping("/create")
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        return new ResponseEntity<>(this.clientService.createClient(client), HttpStatus.CREATED);
    }


    // Delete client
    @DeleteMapping("/delete/{id}")
    // http://localhost:8080/client/delete/1
    public ResponseEntity<String> deleteClient(@PathVariable Long id) {
        return new ResponseEntity<>(this.clientService.deleteClient(id), HttpStatus.NO_CONTENT);
    }

    // Verify address
    @GetMapping("/verify-address")
    // http://localhost:8080/client/verify-address
    public ResponseEntity<String> verifyAddress(@RequestBody AddressVerifyDTO addressVerifyDTO) {
        return new ResponseEntity<>(this.clientService.verifyAddress(addressVerifyDTO), HttpStatus.OK);
    }
}
