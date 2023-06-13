package app.repositories;
import app.data.Material;
import app.data.Order;
import app.data.Size;
import app.data.Type;
import app.services.OrderService;
import jakarta.transaction.Transactional;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderRepository {
    private StringBuilder statementStr = new StringBuilder();
    @Transactional
    public List<Order> findAll() {

        List<Order> orderList = new ArrayList<>();

        Connection connection = null;
        String url = "jdbc:postgresql://127.0.0.1:5432/tester";
        String name = "postgres";
        String password = "new_password";
        statementStr.append("select orders.id, orders.units, orders.deadlines, ")
                .append("material.id as material_id, material.title as material_title, ")
                .append("types.id as type_id, types.title as type_title, ")
                .append("size.id as size_id, size.title as size ")
                .append("from orders ")
                .append("inner join material on orders.material_id = material.id ")
                .append("inner join types on orders.type_id = types.id ")
                .append(" inner join orders_sizes on orders.id = orders_sizes.orders_id ")
                .append("inner join size on size.id = orders_sizes.sizes_id ");

        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Драйвер подключен");
            connection = DriverManager.getConnection(url, name, password);
            System.out.println("Соединение установлено");
            Statement statement = null;

            statement = connection.createStatement();
            ResultSet result1 = statement.executeQuery(
                    String.valueOf(statementStr));
            System.out.println("Выводим statement");
            while (result1.next()) {
                Long orderID = result1.getLong("id");
                int orderUnits = result1.getInt("units");
                String orderDeadline = result1.getString("deadlines");
                Type orderType = new Type(result1.getLong("type_id"), result1.getString("type_title"));
                Material orderMaterial = new Material(result1.getLong("material_id"), result1.getString("material_title"));
                Size orderSize = new Size(result1.getLong("size_id"), result1.getInt("size"));
                Set<Size> sizeSet = new HashSet<>();
                sizeSet.add(orderSize);
                orderList.add(new Order(orderID, orderUnits, orderType, orderMaterial, orderDeadline, sizeSet));
            }
        } catch (Exception ex) {
            //выводим наиболее значимые сообщения
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return orderList;
    }
}
