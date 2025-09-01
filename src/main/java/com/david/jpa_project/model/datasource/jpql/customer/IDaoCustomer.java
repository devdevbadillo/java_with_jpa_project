package com.david.jpa_project.model.datasource.jpql.customer;

import com.david.jpa_project.model.entities.entity.Customer;
import com.david.jpa_project.model.exceptions.NotResultException;

public interface IDaoCustomer {

    Customer getCustomerById(Long id) throws NotResultException;

}
