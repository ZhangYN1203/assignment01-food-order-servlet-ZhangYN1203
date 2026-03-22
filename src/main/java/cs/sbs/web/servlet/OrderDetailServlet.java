package cs.sbs.web.servlet;

import cs.sbs.web.model.Order;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class OrderDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain; charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String pathInfo = request.getPathInfo();
        if (pathInfo == null || pathInfo.length() <= 1) {
            out.println("Error: Order ID is required");
            out.close();
            return;
        }
        
        String orderIdStr = pathInfo.substring(1);
        int orderId;
        try {
            orderId = Integer.parseInt(orderIdStr);
        } catch (NumberFormatException e) {
            out.println("Error: Invalid order ID");
            out.close();
            return;
        }
        
        List<Order> orders = OrderCreateServlet.getOrders();
        Order foundOrder = null;
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                foundOrder = order;
                break;
            }
        }
        
        if (foundOrder != null) {
            out.println("Order Detail");
            out.println("Order ID: " + foundOrder.getOrderId());
            out.println("Customer: " + foundOrder.getCustomer());
            out.println("Food: " + foundOrder.getFood());
            out.println("Quantity: " + foundOrder.getQuantity());
        } else {
            out.println("Error: Order not found");
        }
        
        out.close();
    }
}
