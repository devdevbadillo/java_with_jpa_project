package com.david.jpa_project.model.datasource.native_queries.address;

import com.david.jpa_project.config.DatabaseConfig;
import com.david.jpa_project.model.entities.entity.Address;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class DaoAddressImpl implements IDaoAddress {
    @Override
    @SuppressWarnings("unchecked")
    public List<Address> getAddressesByCustomer(Long id) {
        try (EntityManager em = DatabaseConfig.getEntityManager()) {
            Query query = em.createNativeQuery(
                    "SELECT * FROM demo.T_ADDRESSES WHERE customer_id = ?id",
                    Address.class
            );
            query.setParameter("id", id);

            return (List<Address>) query.getResultList();
        }
    }
}