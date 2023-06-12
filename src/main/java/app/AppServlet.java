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
        resp.getWriter().printf("<h1>How do you do?</h1>");
        resp.getWriter().printf("<h1>Did it ever make sense to you to say bye? (Bye bye)</h1>");
        resp.getWriter().printf("<h1>I see you in that chair with perfect skin</h1>");
        resp.getWriter().printf("<h1>Well, how have you been, baby, livin′ in sin?</h1>");
        resp.getWriter().printf("<h1>Hey, I gotta know, did you say hello?</h1>");
        resp.getWriter().printf("<h1>How do you do?(How do you do?)</h1>");
        resp.getWriter().printf("<h1>Well, here we are spending time in the louder part of town</h1>");
        resp.getWriter().printf("<h1>And it feels like everything′s surreal</h1>");
        resp.getWriter().printf("<h1>When I get old I will wait outside your house</h1>");
        resp.getWriter().printf("<h1>Cause your hands have got the power meant to heal</h1>");
        resp.getWriter().printf("</body></html>");
        resp.getWriter().close();
    }


    @Override
    public void init() throws ServletException {
    }

}