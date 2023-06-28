package app;

import app.dto.OrderDTO;
import app.services.OrderService;
import netscape.javascript.JSObject;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "OrderServlet", urlPatterns = "/order")
public class OrderController extends HttpServlet {
    OrderService orderService = new OrderService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write(String.valueOf(getOrderList()));
        /*resp.getWriter().printf("<html><body>");
        resp.getWriter().printf("<h1>Order list</h1>");*/
        //resp.getWriter().printf(getOrderList().toString());
        /*resp.getWriter().printf("</body></html>");*/
        resp.getWriter().close();
    }

    public List<String> getOrderList(){
        return orderService.getOrderList();
    }

    @Override
    public void init() throws ServletException {
    }

}