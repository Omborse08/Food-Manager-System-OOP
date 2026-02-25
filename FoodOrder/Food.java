package FoodOrder;

abstract class FoodItem{
    private int id;
    private String name;
    private int price;

    FoodItem(int id,String name,int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    abstract int calculatePrice();
}

class VegItem extends FoodItem {
    VegItem(int id,String name,int price) {
        super(id,name,price);
    }
    @Override
    int calculatePrice() {
        return getPrice();
    }
}

class NonVegItem extends FoodItem {
    NonVegItem(int id,String name,int price) {
        super(id,name,price);
    }
    @Override
    int calculatePrice() {
        return getPrice() + (int)(getPrice() * 0.10);
    }
}

class Beverage extends FoodItem {
    Beverage(int id,String name,int price) {
        super(id,name,price);
    }
    @Override
    int calculatePrice() {
        return getPrice() + (int)(getPrice() * 0.05);
    }
}
