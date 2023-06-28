package app.converters;

import app.data.Order;
import app.dto.OrderDTO;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderConverter {
    public List<String> DtoToJSON (List<Order> orderList) {
        List<OrderDTO> orderDTOList = entityToDto(orderList);
        ObjectMapper objectMapper = new ObjectMapper();
        List<String> jsonList = new ArrayList<>();
            try {
                for (int i = 0; i < orderDTOList.size(); i++) {
                jsonList.add(objectMapper.writeValueAsString(orderDTOList.get(i)));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        return jsonList;
    }
    public List<OrderDTO> entityToDto (List<Order> orderList) {
        List<OrderDTO> orderDTOList = new ArrayList<>();
        for (int i = 0; i < orderList.size(); i++) {
            orderDTOList.add(new OrderDTO(orderList.get(i)));
        }
        return orderDTOList;
    }

}
