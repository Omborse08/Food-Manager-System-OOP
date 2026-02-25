package FoodOrder;

interface OrderProcess {
    boolean placeOrder(int id);

    void processNextOrder();

    void showPendingOrder();
}
