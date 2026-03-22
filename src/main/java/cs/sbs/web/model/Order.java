package cs.sbs.web.model;

public class Order {
    private int orderId;
    private String customer;
    private String food;
    private int quantity;
    
    public Order() {
    }
    
    public Order(int orderId, String customer, String food, int quantity) {
        this.orderId = orderId;
        this.customer = customer;
        this.food = food;
        this.quantity = quantity;
    }
    
    public int getOrderId() {
        return orderId;
    }
    
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    
    public String getCustomer() {
        return customer;
    }
    
    public void setCustomer(String customer) {
        this.customer = customer;
    }
    
    public String getFood() {
        return food;
    }
    
    public void setFood(String food) {
        this.food = food;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
