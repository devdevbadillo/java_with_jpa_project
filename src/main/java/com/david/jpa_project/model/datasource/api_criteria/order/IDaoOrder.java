package com.david.jpa_project.model.datasource.api_criteria.order;

import com.david.jpa_project.model.entities.entity.Order;

import java.util.List;

public interface IDaoOrder {

    List<Order> getOrdersByCustomer(Long id);

}
