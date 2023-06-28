package app.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderServiceTest {
    @Test
    void getOrderList() {
        OrderService orderService = new OrderService();
        String str = "[{\"id\":1,\"units\":10,\"deadlines\":\"25-07-2023\",\"productType\":\"Футболка\",\"material\":\"Кулирка\",\"size\":\"[ 42 ]\"}, {\"id\":2,\"units\":8,\"deadlines\":\"25-07-2023\",\"productType\":\"Домашний костюм\",\"material\":\"Футер\",\"size\":\"[ 42 - 50 ]\"}, {\"id\":3,\"units\":20,\"deadlines\":\"25-07-2023\",\"productType\":\"Пижама\",\"material\":\"Велюр\",\"size\":\"[ 46 ]\"}, {\"id\":4,\"units\":5,\"deadlines\":\"25-07-2023\",\"productType\":\"Брюки\",\"material\":\"Футер\",\"size\":\"[ 48 ]\"}, {\"id\":5,\"units\":15,\"deadlines\":\"25-07-2023\",\"productType\":\"Домашний костюм\",\"material\":\"Кулирка\",\"size\":\"[ 50 ]\"}, {\"id\":6,\"units\":30,\"deadlines\":\"25-07-2023\",\"productType\":\"Халат\",\"material\":\"Велюр\",\"size\":\"[ 52 ]\"}]";
        Assertions.assertEquals(str, orderService.getOrderList().toString());
    }
}