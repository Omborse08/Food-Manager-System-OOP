package FoodOrder;
import java.util.*;

class Customer{
    private int id;
    private String name;
    private ArrayList<FoodItem> cart;

    Customer(int id, String name) {
        cart = new ArrayList<>();
        this.id = id;
        this.name = name;
    }

    void addInCart(FoodItem carts) {
        cart.add(carts);
    }

    public void displayCart() {
        if (!cart.isEmpty()) {
            for (int i=0;i<cart.size();i++) {
                FoodItem fi = cart.get(i);
                System.out.println(fi.getId()+". "+fi.getName()+"     $"+fi.getPrice());
            }
        }
    }

    public void clearCart() {
        this.cart.clear();
    }

    public List<FoodItem> getCart() {
        return cart;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}


class Order {
    private int orderid;
    private Customer customer;
    private int totalAmount;
    private boolean isPending = true;
    private ArrayList<FoodItem> items;

    public boolean isPending() {
        return isPending;
    }

    Order(int orderid, Customer customer,List<FoodItem> cartItems) {
        this.orderid = orderid;
        this.customer = customer;
        this.items = new ArrayList<>(cartItems);
    }

    public void calculateTotal() {
        totalAmount = 0;
        for (int i=0;i<items.size();i++) {
            totalAmount += items.get(i).calculatePrice();
        }
    }

    public void setStatus(boolean isWhat) {
        this.isPending = isWhat;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getOrderid() {
        return orderid;
    }
}
