package FoodOrder;

import java.util.*;
public class UI_Main{
    static void showMenu() {
        System.out.println("1.Add Customer\n2.Show Items\n3.Customer Order\n4.Show Customer Order\n5.Placed Order\n6.Process Next Order\n7.Show Pending Order\n8.Add Items\n9.Exit");
    }
    static void main(String[] args) {
        int FID = 101;
        int foodId = 1;
        FoodManager foodManager = new FoodManager();
        Scanner sc = new Scanner(System.in);
        boolean isRun = true;
        showMenu();
        while (isRun) {
            System.out.print("Choose Option: ");
            int choose = sc.nextInt();
            sc.nextLine();
            switch (choose) {
                case 1:
                    System.out.print("Enter Customer Name: ");
                    String name = sc.nextLine();
                    Customer customer = new Customer(FID,name);
                    foodManager.addCustomer(customer);
                    System.out.println("Customer Added Successfully!");
                    System.out.println("Customer ID: "+FID++);
                    break;

                case 8:
                    System.out.print("Enter Food Name: ");
                    String foodName = sc.nextLine().toLowerCase();
                    System.out.print("Enter Food Price: ");
                    int foodPrice = sc.nextInt();
                    FoodItem foodItem;
                    if (foodName.contains("veg")) {
                        foodItem = new VegItem(foodId,foodName,foodPrice);
                    } else if (foodName.contains("non")) {
                        foodItem = new NonVegItem(foodId,foodName,foodPrice);
                    }
                    else {
                        foodItem = new Beverage(foodId,foodName,foodPrice);
                    }
                    if (foodManager.addFoodItem(foodItem)) {
                        System.out.println("Food Item Added Successfully!");
                        System.out.println("Food Item Id: "+foodId++);
                    }
                    else {
                        System.out.println("Something Is Wrong!");
                    }
                    break;

                case 2:
                    System.out.println(" <+><+><+><+> MENU <+><+><+><+>");
                    foodManager.showMenu();
                    break;

                case 3:
                    System.out.print("Enter Customer ID: ");
                    int customerID = sc.nextInt();
                    boolean isAdding = true;
                    if (foodManager.findCustomerById(customerID) != null) {
                        while (isAdding) {
                            System.out.print("Using Id Add Items to Cart (0 for stop): ");
                            int itemid = sc.nextInt();
                            if (itemid == 0) {
                                System.out.println("Items Adding Is Completed!");
                                isAdding = false;
                                break;
                            }
                            else {
                                if (foodManager.addItemToCustomerCart(itemid,customerID)) {
                                    System.out.println("Item Added!");
                                }
                                else {
                                    System.out.println("Not Added!");
                                }
                            }
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter Customer ID: ");
                    int cuID = sc.nextInt();
                    Customer f = foodManager.findCustomerById(cuID);
                    if (f != null) {
                        System.out.println("Cart For "+f.getName());
                        f.displayCart();
                    }
                    else {
                        System.out.println("No Id Found!");
                    }
                    break;

                case 5:
                    System.out.print("Enter Customer ID: ");
                    int cuIDtoOrder = sc.nextInt();
                    if (foodManager.placeOrder(cuIDtoOrder)) {
                        System.out.println("Order Placed Successfully!");
                    }
                    else {
                        System.out.println("Something Is Wrong!");
                    }
                    break;

                case 6:
                    System.out.println("Processing Next Order!");
                    foodManager.processNextOrder();
                    break;

                case 7:
                    System.out.println("Pending Orders!");
                    foodManager.showPendingOrder();
                    break;

                case 9:
                    System.out.println("Thank You Bye");
                    isRun = false;
                    break;


            }
        }
    }
}
