package app.repositories;

import app.data.Material;
import app.data.Order;
import app.data.Size;
import app.data.Type;
import app.services.ConnectionToDB;
import app.services.OrderService;
import jakarta.transaction.Transactional;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderRepository {

    @Transactional
    public List<Order> findAll() {

        List<Order> orderList = new ArrayList<>();
        Map<Long, HashSet> sizeMap = createSizeMapForOrderList();

        StringBuilder statementStr2 = new StringBuilder();
        statementStr2.append("select orders.id, orders.units, orders.deadlines, ")
                .append("material.id as material_id, material.title as material_title, ")
                .append("types.id as type_id, types.title as type_title ")
                .append("from orders ")
                .append("inner join material on orders.material_id = material.id ")
                .append("inner join types on orders.type_id = types.id ");
        ConnectionToDB connectionToDB = new ConnectionToDB();
        ResultSet result2 = connectionToDB.connect(String.valueOf(statementStr2));
        try {
            while (result2.next()) {
                Long orderID = result2.getLong("id");
                int orderUnits = result2.getInt("units");
                String orderDeadline = result2.getString("deadlines");
                Type orderType = new Type(result2.getLong("type_id"), result2.getString("type_title"));
                Material orderMaterial = new Material(result2.getLong("material_id"), result2.getString("material_title"));
                orderList.add(new Order(orderID, orderUnits, orderType, orderMaterial, orderDeadline, sizeMap.get(orderID)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }

    private Map<Long, HashSet> createSizeMapForOrderList() {
        StringBuilder statementStr1 = new StringBuilder();
        statementStr1.append("select orders_sizes.orders_id as order_id, orders_sizes.sizes_id as size_id, size.title as size ")
                .append("from orders_sizes ")
                .append("inner join size on size.id = orders_sizes.sizes_id ");
        ConnectionToDB connectionToDB = new ConnectionToDB();
        ResultSet result1 = connectionToDB.connect(String.valueOf(statementStr1));
        Map<Long, HashSet> sizeMap = new HashMap<>();
        try {
            while (result1.next()) {
                Long orderID = result1.getLong("order_id");
                Size orderSize = new Size(result1.getLong("size_id"), result1.getInt("size"));
                if (sizeMap.containsKey(orderID)) {
                    sizeMap.get(orderID).add(orderSize);
                } else {
                    Set<Size> sizeSet = new HashSet<>();
                    sizeSet.add(orderSize);
                    sizeMap.put(orderID, (HashSet) sizeSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sizeMap;
    }
}
