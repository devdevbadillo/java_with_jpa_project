package com.david.jpa_project.model.datasource.native_queries.address;

import com.david.jpa_project.model.entities.entity.Address;

import java.util.List;

public interface IDaoAddress {

    public List<Address> getAddressesByCustomer(Long id);

}
