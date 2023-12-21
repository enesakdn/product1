package com.example.product1.controller;

import com.example.product1.entity.Client;
import com.example.product1.entity.Product;
import com.example.product1.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private  ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientService.save(client);
    }

    @PutMapping("/{id}")
    public Client updateClient(@PathVariable int id, @RequestBody Client updatedClient) {
        updatedClient.setId(id);
        return clientService.update(updatedClient);
    }
    @GetMapping
    public List<Client> getClients() {
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public Client getClient(@PathVariable int id) {
        return clientService.findById(id);
    }

    @DeleteMapping("/{id}")
    public Client deleteClient(@PathVariable int id) {
        return clientService.delete(id);
    }

    @PostMapping("/{clientId}/favorite-products/{productId}")
    public void addFavoriteProduct(@PathVariable int clientId, @PathVariable int productId) {
        try {
            clientService.addFavoriteProduct(clientId, productId);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @DeleteMapping("/{clientId}/favorite-products/{productId}")
    public void removeFavoriteProduct(@PathVariable int clientId, @PathVariable int productId) {
        try {
            clientService.removeFavoriteProduct(clientId, productId);
        } catch (RuntimeException e) {
            throw e;
        }
    }



    @GetMapping("/{clientId}/favorite-products")
    public List<Product> getFavoriteProducts(@PathVariable int clientId) {
        return clientService.getFavoriteProducts(clientId);
    }
}
