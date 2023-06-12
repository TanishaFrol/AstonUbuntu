package app;

import app.data.Order;
import app.services.OrderService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderServlet", urlPatterns = "/order")
public class OrderController extends HttpServlet {

    OrderService orderService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().printf("<html><body>");
        resp.getWriter().printf("<h1>Order list</h1>");
        resp.getWriter().printf(String.valueOf(getOrderList()));
        resp.getWriter().printf("</body></html>");
        resp.getWriter().close();
    }

    public List<Order> getOrderList(){
        List<Order> orderList = orderService.getOrderList();
        return orderList;
    }

    @Override
    public void init() throws ServletException {
    }

}