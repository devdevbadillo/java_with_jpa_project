package com.david.jpa_project.model.datasource.jpql.employee;

import com.david.jpa_project.config.DatabaseConfig;
import com.david.jpa_project.model.entities.entity.Employee;
import com.david.jpa_project.model.exceptions.NotResultException;
import jakarta.persistence.EntityManager;

public class DaoEmployeeImpl implements IDaoEmployee{

    public Employee getEmployeeById(Long id) throws NotResultException {
        try(EntityManager em = DatabaseConfig.getEntityManager(); ) {
            String jpql = "SELECT e FROM Employee e WHERE e.id = :id";
            Employee employee = em.createQuery(jpql, Employee.class).setParameter("id", id).getSingleResult();

            if (employee != null) return employee;

            throw new NotResultException("Employee not found");
        }
    }
}
