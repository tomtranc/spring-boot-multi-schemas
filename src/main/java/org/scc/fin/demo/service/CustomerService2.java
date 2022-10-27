package org.scc.fin.demo.service;

import org.scc.fin.demo.model.dto.Customer;
import org.scc.fin.demo.model.entity.schema2.CustomerEntity2;
import org.scc.fin.demo.repo.schema2.CustomerRepo2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService2 {

    @Autowired
    private CustomerRepo2 customerRepo2;

    public List<Customer> list() {
        return customerRepo2.findAll().stream()
                .map(this::getCustomerEntityToDto)
                .collect(Collectors.toList());
    }

    public Customer create(Customer dto) {
        return getCustomerEntityToDto(customerRepo2.save(getCustomerDtoToEntity(dto)));
    }

    public Customer update(Customer dto) {
        return getCustomerEntityToDto(customerRepo2.save(getCustomerDtoToEntity(dto)));
    }

    public void delete(String id) {
        customerRepo2.deleteById(id);
    }

    private Customer getCustomerEntityToDto(CustomerEntity2 entity) {
        Customer dto = new Customer();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        Optional.ofNullable(entity.getMetadata()).ifPresent(dto::setMetadata);
        return dto;
    }

    private CustomerEntity2 getCustomerDtoToEntity(Customer dto) {
        CustomerEntity2 entity = new CustomerEntity2();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        Optional.ofNullable(dto.getMetadata()).ifPresent(entity::setMetadata);
        return entity;
    }
}
