package com.david.jpa_project.model.datasource.jpql.employee;

import com.david.jpa_project.model.entities.entity.Employee;
import com.david.jpa_project.model.exceptions.NotResultException;

public interface IDaoEmployee {

    public Employee getEmployeeById(Long id) throws NotResultException;

}
