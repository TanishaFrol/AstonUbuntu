package app.services;

import app.converters.OrderConverter;
import app.data.Order;
import app.repositories.OrderRepository;
import java.util.List;



public class OrderService {
    private OrderRepository orderRepo = new OrderRepository();
    private OrderConverter orderConverter = new OrderConverter();
    public List<String> getOrderList() {
        List<Order> orderList = orderRepo.findAll();
        return orderConverter.DtoToJSON(orderList);
    }
}
