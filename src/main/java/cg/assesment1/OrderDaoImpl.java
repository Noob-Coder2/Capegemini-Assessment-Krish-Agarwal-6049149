package cg.assesment1;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;

public class OrderDaoImpl implements OrderDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");
    EntityManager em = emf.createEntityManager();

    @Override
    public boolean addOrder(Order order, int customerId) {
        try {
            em.getTransaction().begin();
            Customer cus = em.find(Customer.class, customerId);
            order.setCustomer(cus);
            em.persist(order);
            em.getTransaction().commit();
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    @Override
    public Order getOrder(int orderId) {
        return em.find(Order.class, orderId);
    }

    @Override
    public List<Order> getOrders(String customerName) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Order> cq = cb.createQuery(Order.class);
        Root<Order> root = cq.from(Order.class);
        Join<Order, Customer> cust = root.join("customer");
        cq.select(root).where(cb.equal(cust.get("customerName"), customerName));
        return em.createQuery(cq).getResultList();

    }
}
