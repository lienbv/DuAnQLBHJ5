package com.asm.service;

public interface ICartService {

    void addToCart(long productId, long amount);

    void changeProductQuantity(long productId);
    void changeProductQuantityUp(long productId);

    void removeProduct(long productId);

    void removeProducts();

}
