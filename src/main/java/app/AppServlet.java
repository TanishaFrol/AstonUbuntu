package app;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AppServlet", urlPatterns = "/home")
public class AppServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().printf("<html><body>");
        resp.getWriter().printf("<h1>How do you do the things that you do?</h1>");
        resp.getWriter().printf("<h1>No one I know could ever keep up with you</h1>");
        resp.getWriter().printf("</body></html>");
        resp.getWriter().close();
    }
    @Override
    public void init() throws ServletException {
    }

}