import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/subpage")
public class ServletSubpage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String value1 = req.getParameter("param1");
        String value2 = req.getParameter("param2");

        PrintWriter pw = resp.getWriter();
        pw.append("Giá trị param 1: ");
        pw.append(value1);

        pw.append("<br>Giá trị param 2: ");
        pw.append(value2);
    }
}
