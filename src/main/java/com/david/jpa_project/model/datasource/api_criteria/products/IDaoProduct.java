package com.david.jpa_project.model.datasource.api_criteria.products;

import com.david.jpa_project.model.entities.entity.Product;

import java.util.List;

public interface IDaoProduct {

    List<Product> getProductsByCategory(Long id);

}
