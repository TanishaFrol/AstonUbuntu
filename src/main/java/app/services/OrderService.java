package app.services;

import app.converters.OrderConverter;
import app.data.Order;
import app.dto.OrderDTO;
import app.repositories.OrderRepository;

import java.util.List;



public class OrderService {
    private OrderRepository orderRepo = new OrderRepository();
    private OrderConverter orderConverter = new OrderConverter();
    public List<OrderDTO> getOrderList() {

        List<Order> orderList = (List<Order>) orderRepo.findAll();
        return orderConverter.entityToDto(orderList);
    }
}
