package cg.assesment1;

// 14 March 2026

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class App {
    static OrderDao dao = new OrderDaoImpl();
    static Scanner scan = new Scanner(System.in);
    
	public static void main(String[] args) {
		String opt = null;
		do {
			System.out.println("\nMenu: 1-ADD, 2-VIEW BY ORDER ID, 3-VIEW BY CUSTOMER NAME");
			System.out.print("Choose option: ");
			int mtype = scan.nextInt();
			scan.nextLine();
			processMenu(mtype);
			System.out.println("\nPress y to continue");
			opt = scan.nextLine();
		} while (opt.equalsIgnoreCase("y"));

	}
	
	public static void processMenu(int mtype) {
		switch(mtype) {
		case 1:
			addOrder();
			break;
		case 2:
			viewOrderByOrderID();
			break;
		case 3:
			viewOrdersByCustName();
			break;
		default:
			System.out.println("Invalid option");
		}
	}

	public static void addOrder() {
		Order order = new Order();
        order.setOrderDate(new Date());
        System.out.print("Enter customer id: ");
        int custId = scan.nextInt();
        System.out.print("Enter order amount: ");
        double orderAmount = scan.nextDouble();
        scan.nextLine();

        order.setOrderAmount(orderAmount);

        boolean added = dao.addOrder(order, custId);
        if (added) {
            System.out.println("Order added successfully.");
            System.out.println("Order details: id=" + order.getOrderId() + ", amount=" + order.getOrderAmount()
                    + ", date=" + order.getOrderDate() + ", customerId=" + custId);
        } else {
            System.out.println("Order Failed");
        }
	}
	
	public static void viewOrderByOrderID() {
		System.out.print("Enter order id: ");
		int orderId = scan.nextInt();
		scan.nextLine();
		Order order = dao.getOrder(orderId);
		if (order == null) {
			System.out.println("Order not found for id " + orderId);
			return;
		}

		System.out.println("Order Id: " + order.getOrderId());
		System.out.println("Order Date: " + order.getOrderDate());
		System.out.println("Order Amount: " + order.getOrderAmount());
		Customer c = order.getCustomer();
		if (c != null) {
			System.out.println("Customer Id: " + c.getCustomerId());
			System.out.println("Customer Name: " + c.getCustomerName());
		} else {
			System.out.println("Customer details not found.");
		}
	}
	
	public static void viewOrdersByCustName() {
		System.out.print("Enter customer name: ");
		String customerName = scan.nextLine().trim();
		List<Order> orders = dao.getOrders(customerName);
		if (orders == null || orders.isEmpty()) {
			System.out.println("No orders found for customer " + customerName);
			return;
		}

		System.out.println("Orders for customer: " + customerName);
		for (Order order : orders) {
			System.out.println("- Order Id: " + order.getOrderId() + ", Amount: " + order.getOrderAmount()
				+ ", Date: " + order.getOrderDate());
		}
	}
 }
