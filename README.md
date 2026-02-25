# 🍔 Console-Based Online Food Ordering System (Java OOP Project)

A CLI-based Online Food Ordering System built using Core Java.

This project demonstrates strong understanding of Object-Oriented Programming principles and Java Collections Framework by modeling a real-world multi-customer food ordering workflow.

---

## 📌 Project Overview

This system allows:

- Multiple customer registration
- Menu management
- Customer-specific cart handling
- Order placement with cart snapshot
- FIFO order processing using queue
- Order status tracking

The project is fully console-based and focuses on backend logic and system modeling.

---

## 🧠 OOP Concepts Implemented

### 1️⃣ Encapsulation
- All class fields are declared `private`
- Access through getters/setters
- Internal data protected from direct modification

### 2️⃣ Abstraction
- `FoodItem` is an abstract class
- Defines abstract method:
  ```java
  abstract int calculatePrice();
  ```

### 3️⃣ Inheritance
Food items are categorized using inheritance:

```
FoodItem (Abstract)
   ├── VegItem
   ├── NonVegItem
   └── Beverage
```

Each subclass overrides `calculatePrice()` with its own pricing logic.

### 4️⃣ Polymorphism
Food items are stored as:

```java
ArrayList<FoodItem>
```

Runtime polymorphism is used when calculating order totals.

### 5️⃣ Interface
`OrderProcess` interface defines contract:

- placeOrder()
- processNextOrder()
- displayPendingOrders()

Implemented by `FoodManager`.

---

## 📚 Collections Used

### 🔹 ArrayList
Used for:
- Menu storage
- Customer list
- Customer cart
- Order item snapshot

### 🔹 LinkedList
Used as:
- Order queue (FIFO)

Orders are processed using:

```java
removeFirst()
```

---

## 🏗️ System Architecture

### Core Classes

| Class | Responsibility |
|--------|---------------|
| `FoodItem` | Base class for menu items |
| `VegItem`, `NonVegItem`, `Beverage` | Specific pricing logic |
| `Customer` | Stores customer details and cart |
| `Order` | Snapshot of cart at purchase time |
| `FoodManager` | System controller (menu, customers, queue) |
| `UI_Main` | CLI interaction layer |

---

## 🔄 System Flow

### 1️⃣ Register Customer
Stores customer in:

```java
ArrayList<Customer>
```

Each customer has an independent cart.

---

### 2️⃣ Add Items to Cart
Items are added to the specific customer's cart.

Each cart is isolated per customer.

---

### 3️⃣ Place Order
When placing order:

- Cart items are copied into Order (snapshot)
- Order added to queue
- Cart cleared
- Order marked as pending

Snapshot logic prevents future cart changes from affecting past orders.

---

### 4️⃣ Process Order
- First order in queue is processed
- Status updated
- Removed from queue

FIFO logic ensured using LinkedList.

---

## 💰 Pricing Logic

| Type | Pricing Rule |
|------|-------------|
| VegItem | Base price |
| NonVegItem | +10% |
| Beverage | +5% |

Polymorphism ensures correct pricing per item type.

---

## 🖥️ Sample CLI Menu

```
1. Add Customer
2. Show Items
3. Customer Order
4. Show Customer Cart
5. Place Order
6. Process Next Order
7. Show Pending Orders
8. Add Items
9. Exit
```

---

## 🚀 Key Design Highlights

- Proper separation of responsibilities
- Cart ownership inside Customer
- Order snapshot to maintain transaction integrity
- Queue-based order processing
- Clean OOP structure
- No external frameworks
- No advanced Java features
- Focused purely on core backend modeling

---

## 📈 Learning Outcomes

Through this project:

- Strengthened OOP fundamentals
- Understood object ownership & reference behavior
- Practiced real-world data modeling
- Implemented queue-based system logic
- Applied abstraction and polymorphism effectively

---

## 🔧 Technologies Used

- Java (Core)
- Java Collections Framework
- Console-based UI

---

## 🏁 Future Improvements

- Persistent storage (File / Database)
- Payment handling logic
- Order history tracking
- Admin authentication
- GUI version using JavaFX

---

## 👨‍💻 Author

Developed as a backend-focused OOP project to strengthen Java fundamentals and system design thinking.
