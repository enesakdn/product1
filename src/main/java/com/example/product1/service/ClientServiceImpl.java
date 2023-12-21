package com.example.product1.service;

import com.example.product1.entity.Product;
import com.example.product1.repository.ClientRepository;
import com.example.product1.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ProductService productService;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, ProductService productService) {
        this.clientRepository = clientRepository;
        this.productService = productService;
    }
    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(int id) {
       Optional<Client> client = clientRepository.findById(id);
       if(client.isPresent()){
           return client.get();
       }
          throw new RuntimeException("Id is not exist" + id);
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client delete(int id) {
        Client client = findById(id);
        clientRepository.delete(client);
        return client;
    }

    @Override
    public Client update(Client updatedClient) {
        Optional<Client> existingClientOptional = clientRepository.findById(updatedClient.getId());

        if (existingClientOptional.isPresent()) {
            Client existingClient = existingClientOptional.get();

            existingClient.setName(updatedClient.getName());
            existingClient.setSurname(updatedClient.getSurname());
            clientRepository.save(existingClient);
            return existingClient;
        } else {
            throw new RuntimeException("Client with ID " + updatedClient.getId() + " not found");
        }
    }

    @Override
    public List<Product> getFavoriteProducts(int clientId) {
        Optional<Client> clientOptional = clientRepository.findById(clientId);
        if (clientOptional.isPresent()) {
            Client client = clientOptional.get();

            return client.getClient_like_product();
        } else {
            throw new RuntimeException("Client with ID " + clientId + " not found");
        }
    }
    // Inside ClientService

    public void addFavoriteProduct(int clientId, int productId) {
        Client client = findById(clientId);
        Product product = productService.findById(productId);

        List<Product> favoriteProducts = client.getClient_like_product();
        if (!favoriteProducts.contains(product)) {
            favoriteProducts.add(product);
            clientRepository.save(client);
        }
    }

    public void removeFavoriteProduct(int clientId, int productId) {
        Client client = findById(clientId);
        Product product = productService.findById(productId);

        List<Product> favoriteProducts = client.getClient_like_product();
        if (favoriteProducts.contains(product)) {
            favoriteProducts.remove(product);
            clientRepository.save(client);
        }
    }

}
