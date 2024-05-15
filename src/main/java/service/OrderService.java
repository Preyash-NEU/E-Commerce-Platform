package service;


import entity.Order;
import repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public void createOrder(Order order) {
        orderRepository.save(order);
    }

    @SuppressWarnings("unchecked")
	public List<Order> getOrdersByUserId(Long userId) {
        return (List<Order>) orderRepository.findByUserId(userId);
    }
}
