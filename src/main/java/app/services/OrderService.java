package app.services;

import app.data.Order;
import app.repositories.OrderRepository;

import java.util.List;



public class OrderService {
    private OrderRepository orderRepo = new OrderRepository();
    public List<Order> getOrderList() {
        return (List<Order>) orderRepo.findAll();
    }
}
