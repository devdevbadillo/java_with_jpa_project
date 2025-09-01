package com.david.jpa_project.model.datasource.jpql.customer;

import com.david.jpa_project.config.DatabaseConfig;
import com.david.jpa_project.model.entities.entity.Customer;
import com.david.jpa_project.model.exceptions.NotResultException;
import jakarta.persistence.EntityManager;

public class DaoCustomerImpl implements IDaoCustomer {

    public Customer getCustomerById(Long id) throws NotResultException{
        try( EntityManager em = DatabaseConfig.getEntityManager(); ) {
            String jpql = "SELECT c FROM Customer c WHERE c.id = :id";
            Customer customer = em.createQuery(jpql, Customer.class).setParameter("id", id).getSingleResult();

            if(customer != null) return customer;

            throw new NotResultException("Customer not found");
        }
    }

}
