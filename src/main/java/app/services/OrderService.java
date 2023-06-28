package app.services;

import app.converters.OrderConverter;
import app.data.Order;
import app.dto.OrderDTO;
import app.repositories.OrderRepository;

import java.util.List;



public class OrderService {
    private OrderRepository orderRepo = new OrderRepository();
    private OrderConverter orderConverter = new OrderConverter();
    public List<String> getOrderList() {
        List<Order> orderList = orderRepo.findAll();
        System.out.println(orderList);
        return orderConverter.DtoToJSON(orderList);
    }
}
