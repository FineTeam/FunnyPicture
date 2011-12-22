package ru.ksu.mvc2.servlet;

import org.json.simple.JSONArray;
import ru.ksu.mvc2.vo.Order;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author alexander.shlyannikov
 *         24.11.11 11:22
 */
public class TestSerlvet extends HttpServlet {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyy HH:mm:ss");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("testLoad1")) {
            String date = dateFormat.format(new Date());
            request.setAttribute("date", date);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/testLoad1.jsp");
            requestDispatcher.forward(request, response);
        }
        if (action != null && action.equals("testLoad3")) {
            response.setContentType("application/json");
            JSONArray jsonArray = new JSONArray();
            for (int i = 0; i < 5; i++) {
                Order o = new Order(i, "Address " + i);
                jsonArray.add(o);
            }
            StringWriter out = new StringWriter();
            jsonArray.writeJSONString(out);
            response.getWriter().print(out.toString());
            response.getWriter().close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("testLoad2")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/testLoad2.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
