package org.scc.fin.demo.service;

import org.scc.fin.demo.model.dto.Customer;
import org.scc.fin.demo.model.entity.schema1.CustomerEntity1;
import org.scc.fin.demo.repo.schema1.CustomerRepo1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService1 {

    @Autowired
    private CustomerRepo1 customerRepo1;

    public List<Customer> list() {
        return customerRepo1.findAll().stream()
                .map(this::getCustomerEntityToDto)
                .collect(Collectors.toList());
    }

    public Customer create(Customer dto) {
        return getCustomerEntityToDto(customerRepo1.save(getCustomerDtoToEntity(dto)));
    }

    public Customer update(Customer dto) {
        return getCustomerEntityToDto(customerRepo1.save(getCustomerDtoToEntity(dto)));
    }

    public void delete(String id) {
        customerRepo1.deleteById(id);
    }

    private Customer getCustomerEntityToDto(CustomerEntity1 entity) {
        Customer dto = new Customer();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    private CustomerEntity1 getCustomerDtoToEntity(Customer dto) {
        CustomerEntity1 entity = new CustomerEntity1();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        return entity;
    }
}
