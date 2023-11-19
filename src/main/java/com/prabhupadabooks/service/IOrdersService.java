package com.prabhupadabooks.service;



import com.prabhupadabooks.entity.Order;
import com.prabhupadabooks.entity.OrderBasket;
import com.prabhupadabooks.entity.User;
import com.prabhupadabooks.exception.OrderNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IOrdersService {
    public List<Order> getAllOrders();

    List<Order> getAllOrdersByUser(User user);

    public void saveOrder(Order orders);

    public Order getOrder(int id);

    public Order getOrderByUser(User user) throws OrderNotFoundException;

    float countSum(List<OrderBasket> orderBaskets);

    public void deleteOrder(int id) throws OrderNotFoundException;


    Page<Order> listByPage(int pageNum);
}
