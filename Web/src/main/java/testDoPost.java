import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/TestDoPost")
public class testDoPost extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html");
//        resp.setCharacterEncoding("utf-8");
//
//        PrintWriter writer = resp.getWriter();
//        writer.append("Bạn vừa yêu cầu Get");
//        String noidungHtml = "<form method=\"post\" action=\"TestDoPost\">" +
//                "<label>Họ</label>" +
//                "<input name=\"fname\" type=\"text\">" +
//                "<br>" +
//                "<label>Tên</label>" +
//                "<input name=\"lname\" type=\"text\">" +
//                "<br>" +
//                "<input type=\"submit\" value=\"Gửi\">" +
//                "</form>";
//        writer.append(noidungHtml);
//    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/testDoPost.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        String value1 = req.getParameter("fname");
        String value2 = req.getParameter("lname");

        PrintWriter writer = resp.getWriter();

        writer.append("Bạn vừa gửi yêu cầu POST");
        writer.append("<br>");
        writer.append("Giá trị tham số fname: ");
        writer.append(value1);
        writer.append("<br>");

        writer.append("Giá trị tham số lname: ");
        writer.append(value2);
    }
}
