package app.repositories;

import app.converters.OrderConverter;
import app.data.Material;
import app.data.Order;
import app.data.Size;
import app.data.Type;
import app.dto.OrderDTO;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class OrderRepositoryTest {

    @Test
    void findAll() {
        OrderRepository orderRepository = new OrderRepository();
        List<Order> orderList = new ArrayList<>();
        Set<Size> sizes = new LinkedHashSet<>();
        sizes.add(new Size(1L, 42));
        orderList.add(new Order(1L, 10, new Type(1L, "T_shirt"), new Material(1L, "cooler"), "25-07-2023", sizes));
        Assertions.assertEquals(orderList.get(0), orderRepository.findAll().get(0));
    }
}