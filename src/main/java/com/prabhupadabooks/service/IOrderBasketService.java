package com.prabhupadabooks.service;


import com.prabhupadabooks.entity.OrderBasket;
import com.prabhupadabooks.entity.User;

import java.util.List;

public interface IOrderBasketService {
    List<OrderBasket> getAllOrderBaskets();

    public List<OrderBasket> listOrderBasket(User user);

    public Integer addProduct(Integer productId, Integer quantity, User user);

    public float updateQuantity(Integer productId, Integer quantity, User user);

    public void removeProduct(Integer productId, User user);
}
