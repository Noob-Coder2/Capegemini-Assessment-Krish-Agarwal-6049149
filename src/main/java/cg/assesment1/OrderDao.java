package cg.assesment1;

import java.util.List;

public interface OrderDao {
    public boolean addOrder(Order order, int customerId);
    public Order getOrder(int orderId);
    public List<Order> getOrders(String customerName);
}