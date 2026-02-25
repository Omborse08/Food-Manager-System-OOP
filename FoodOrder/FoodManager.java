package FoodOrder;

import java.util.*;

class FoodManager implements OrderProcess{
    private ArrayList<Customer> customers;
    private ArrayList<FoodItem> menu;
    private LinkedList<Order> ordersQueue;
    private int ordercount = 501;

    FoodManager() {
        menu = new ArrayList<>();
        customers = new ArrayList<>();
        ordersQueue = new LinkedList<>();
    }

    void addCustomer(Customer customer) {
        customers.add(customer);
    }

    boolean addFoodItem(FoodItem foodItem) {
        if (foodItem != null) {
            menu.add(foodItem);
            return true;
        }
        return false;
    }

    void showMenu() {
        if (menu.size() != 0) {
            for (int i=0;i< menu.size();i++) {
                FoodItem fi = menu.get(i);
                System.out.println(fi.getId()+". "+fi.getName()+"     $"+fi.calculatePrice());
            }
        }
        else {
            System.out.println("No Items Yet!");
        }
    }

    Customer findCustomerById(int id) {
        for (int i=0;i<customers.size();i++) {
            if (id == customers.get(i).getId()) {
                return customers.get(i);
            }
        }
        return null;
    }

    boolean addItemToCustomerCart(int id,int cid) {
        for (int i=0;i<menu.size();i++) {
            if (id == menu.get(i).getId()) {
                Customer c = findCustomerById(cid);
                if (c != null) {
                    c.addInCart(menu.get(i));
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean placeOrder(int id) {
        for (int i=0;i<customers.size();i++) {
            if (id == customers.get(i).getId()) {
                Order ord = new Order(ordercount,customers.get(i),customers.get(i).getCart());
                ordersQueue.add(ord);
                System.out.println("Order ID: "+ordercount++);
                System.out.println("Total Bill: "+ord.getTotalAmount());
                customers.get(i).clearCart();
                System.out.println("Order Status: "+ord.isPending());
                return true;
            }
        }
        return false;
    }

    @Override
    public void showPendingOrder() {
        for (int i=0;i<ordersQueue.size();i++) {
            System.out.println("Order ID: "+ordersQueue.get(i).getOrderid()+"   Customer Name: "+ordersQueue.get(i).getCustomer().getName());
        }
    }

    @Override
    public void processNextOrder() {
        if (!ordersQueue.isEmpty()) {
            System.out.println("Order ID: "+ordersQueue.getFirst().getOrderid());
            System.out.println("Order Status: "+ordersQueue.getFirst().isPending());
            System.out.println("Order Process Completes");
            ordersQueue.getFirst().setStatus(false);
            ordersQueue.removeFirst();
        }
        else {
            System.out.println("No Orders!");
        }
    }


}
