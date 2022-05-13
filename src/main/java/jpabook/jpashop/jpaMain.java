package jpabook.jpashop;

import com.sun.org.apache.xpath.internal.operations.Or;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class jpaMain {

    public static void main(String[] args){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try{

            Order order = new Order();
            em.persist(order);

            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order); // 이렇게 하면 객체를 다루면서, 연관관계를 통해 잘 들어가게됨.

            em.persist(orderItem);

            tx.commit();

        } catch(Exception e){

            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }
}
