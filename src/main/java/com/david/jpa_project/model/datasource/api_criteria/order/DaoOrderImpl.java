package com.david.jpa_project.model.datasource.api_criteria.order;

import com.david.jpa_project.config.DatabaseConfig;
import com.david.jpa_project.model.entities.entity.Customer;
import com.david.jpa_project.model.entities.entity.Order;
import com.david.jpa_project.model.entities.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;

import java.util.List;

public class DaoOrderImpl implements IDaoOrder {

    @Override
    public List<Order> getOrdersByCustomer(Long id) {
        try(EntityManager em = DatabaseConfig.getEntityManager(); ) {
            CriteriaBuilder cb = em.getCriteriaBuilder();

            CriteriaQuery<Order> cq = cb.createQuery(Order.class);
            Root<Customer> customerRoot = cq.from(Customer.class);

            Join<Customer, Order> orderJoin = customerRoot.join("orders", JoinType.LEFT);

            cq.select(orderJoin).where(cb.equal(customerRoot.get("id"), id));

            return em.createQuery(cq).getResultList();
        }
    }
}
