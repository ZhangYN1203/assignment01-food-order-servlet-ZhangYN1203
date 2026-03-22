package cs.sbs.web.servlet;

import cs.sbs.web.model.MenuItem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MenuListServlet extends HttpServlet {
    private List<MenuItem> menuItems;
    
    @Override
    public void init() throws ServletException {
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(1, "Fried Rice", 8.0));
        menuItems.add(new MenuItem(2, "Fried Noodles", 9.0));
        menuItems.add(new MenuItem(3, "Burger", 10.0));
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain; charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String nameQuery = request.getParameter("name");
        List<MenuItem> filteredItems = new ArrayList<>();
        
        if (nameQuery == null || nameQuery.isEmpty()) {
            filteredItems = menuItems;
        } else {
            for (MenuItem item : menuItems) {
                if (item.getName().toLowerCase().contains(nameQuery.toLowerCase())) {
                    filteredItems.add(item);
                }
            }
        }
        
        out.println("Menu List:");
        for (int i = 0; i < filteredItems.size(); i++) {
            MenuItem item = filteredItems.get(i);
            out.printf("%d. %s - $%.0f%n", i + 1, item.getName(), item.getPrice());
        }
        
        out.close();
    }
}
