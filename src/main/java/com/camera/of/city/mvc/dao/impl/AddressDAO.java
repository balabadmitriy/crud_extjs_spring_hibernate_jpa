package com.camera.of.city.mvc.dao.impl;

import com.camera.of.city.mvc.dao.AbstractDAO;
import com.camera.of.city.mvc.domain.Address;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDAO extends AbstractDAO<Address> {
    public AddressDAO() {
        super(Address.class);
    }

}
