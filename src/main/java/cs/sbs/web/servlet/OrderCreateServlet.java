package cs.sbs.web.servlet;

import cs.sbs.web.model.Order;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class OrderCreateServlet extends HttpServlet {
    private static List<Order> orders = new ArrayList<>();
    private static int nextOrderId = 1001;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain; charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String customer = request.getParameter("customer");
        String food = request.getParameter("food");
        String quantityStr = request.getParameter("quantity");
        
        if (customer == null || customer.isEmpty() || food == null || food.isEmpty()) {
            out.println("Error: Customer name and food name cannot be empty");
            out.close();
            return;
        }
        
        int quantity;
        try {
            quantity = Integer.parseInt(quantityStr);
            if (quantity <= 0) {
                out.println("Error: Quantity must be a positive integer");
                out.close();
                return;
            }
        } catch (NumberFormatException e) {
            out.println("Error: Quantity must be a valid number");
            out.close();
            return;
        }
        
        int orderId = nextOrderId++;
        Order order = new Order(orderId, customer, food, quantity);
        orders.add(order);
        
        out.println("Order Created: " + orderId);
        out.close();
    }
    
    public static List<Order> getOrders() {
        return orders;
    }
}
