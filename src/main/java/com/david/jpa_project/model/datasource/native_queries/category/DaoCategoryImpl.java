package com.david.jpa_project.model.datasource.native_queries.category;

import com.david.jpa_project.config.DatabaseConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class DaoCategoryImpl implements IDaoCategory {
    @Override
    public Integer getTotalProductsByCategory(Long id) {
        try (EntityManager em = DatabaseConfig.getEntityManager()) {
            Query query = em.createNativeQuery(
                    "SELECT COUNT(*) FROM demo.T_PRODUCT_CATEGORIES pc WHERE pc.category_id = ?id"
            );

            query.setParameter("id", id);

            Number result = (Number) query.getSingleResult();
            return result.intValue();
        }
    }

}
