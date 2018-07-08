package com.myprojects.spring.examples.SpringMVCRestWS.services;

import com.myprojects.spring.examples.SpringMVCRestWS.api.v1.mapper.CustomerMapper;
import com.myprojects.spring.examples.SpringMVCRestWS.api.v1.model.CustomerDTO;
import com.myprojects.spring.examples.SpringMVCRestWS.domain.Customer;
import com.myprojects.spring.examples.SpringMVCRestWS.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerMapper customerMapper;
    private CustomerRepository customerRepository;

    @Autowired
    public void setCustomerMapper(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


//    public CustomerServiceImpl(CustomerMapper customerMapper, CustomerRepository customerRepository) {
//        this.customerMapper = customerMapper;
//        this.customerRepository = customerRepository;
//    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository
                .findAll()
                .stream()
                .map(customer -> {
                    CustomerDTO customerDTO = customerMapper.cusomterToCustomerDTO(customer);
                    customerDTO.setCustomerUrl("/api/v1/customers/"+customer.getId());
                    return customerDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {
        return customerRepository.findById(id)
                .map(customerMapper::cusomterToCustomerDTO)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public CustomerDTO createNewCustomer(CustomerDTO customerDTO) {

        Customer customer = customerMapper.customerDtoToCustomer(customerDTO);

        Customer savedCusomter = customerRepository.save(customer);

        CustomerDTO returnDto = customerMapper.cusomterToCustomerDTO(savedCusomter);

        returnDto.setCustomerUrl("/api/v1/customer/" + savedCusomter.getId());

        return returnDto;
    }





}
