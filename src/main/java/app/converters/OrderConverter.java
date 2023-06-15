package app.converters;

import app.data.Order;
import app.dto.OrderDTO;

import java.util.ArrayList;
import java.util.List;

public class OrderConverter {
    public List<OrderDTO> entityToDto (List<Order> orderList) {
        List<OrderDTO> orderDTOList = new ArrayList<>();
        for (int i = 0; i < orderList.size(); i++) {
            orderDTOList.add(new OrderDTO(orderList.get(i)));
        }
        return orderDTOList;
    }
}
