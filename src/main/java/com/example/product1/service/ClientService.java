package com.example.product1.service;

import com.example.product1.entity.Client;
import com.example.product1.entity.Product;

import java.util.List;

public interface ClientService {
    List<Client> findAll();
    Client findById(int id);
    Client save(Client client);
    Client delete(int id);
    Client update(Client updatedClient);
     List<Product> getFavoriteProducts(int clientId);
     void addFavoriteProduct(int clientId, int productId);
     void removeFavoriteProduct(int clientId, int productId);
}
