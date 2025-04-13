package com.example.banco2025.service;

import com.example.banco2025.DTO.CustomerDTO;
import com.example.banco2025.entity.Customer;
import com.example.banco2025.repository.CustomerRepository;
import com.example.banco2025.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public List<CustomerDTO> getAllCustomer(){
        return customerRepository.findAll().stream()
                .map(customerMapper::customerToCustomerDTO).toList();
    }

    public CustomerDTO getCustomerById(Long id){
        return customerRepository.findById(id).map(customerMapper::customerToCustomerDTO)
                .orElseThrow(()->new RuntimeException("Cliente no encontrado"));
    }

    public CustomerDTO createCustomer(CustomerDTO customerDTO){
        Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
        return customerMapper.customerToCustomerDTO(customerRepository.save(customer));
    }

    public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO){
        Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
        customer.setId(id);
        return customerMapper.customerToCustomerDTO(customerRepository.save(customer));
    }

    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }
}
