package com.david.jpa_project.model.datasource.api_criteria.products;

import com.david.jpa_project.config.DatabaseConfig;
import com.david.jpa_project.model.entities.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;

import java.util.List;

public class DaoProductImpl implements IDaoProduct {
    @Override
    public List<Product> getProductsByCategory(Long id) {
        try(EntityManager em = DatabaseConfig.getEntityManager(); ) {
            CriteriaBuilder cb = em.getCriteriaBuilder();

            CriteriaQuery<Product> cq = cb.createQuery(Product.class);
            Root<Product> productRoot = cq.from(Product.class);
            Join<Object, Object> categoryJoin = productRoot.join("categories", JoinType.INNER);

            cq.select(productRoot).distinct(true)
                    .where(cb.equal(categoryJoin.get("id"), id));

            return em.createQuery(cq).getResultList();
        }
    }
}
