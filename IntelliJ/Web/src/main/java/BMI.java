import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/BMI")
public class BMI extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/bmi.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        String value1 = req.getParameter("kgvalue");
        String value2 = req.getParameter("mvalue");

        float kg = Float.parseFloat(value1);
        float m = Float.parseFloat(value2);

        float result = kg / (m * m);

        PrintWriter writer = resp.getWriter();

        writer.append("Bạn vừa gửi yêu cầu POST");
        writer.append("<br>");
        writer.append("Giá trị chiều cao (m): ");
        writer.append(value1);
        writer.append("<br>");

        writer.append("Giá trị cân nặng (kg): ");
        writer.append(value2);

        writer.append("<br>");
        writer.append("Giá trị BMI: ");
        writer.append(String.valueOf(result));
    }
}
