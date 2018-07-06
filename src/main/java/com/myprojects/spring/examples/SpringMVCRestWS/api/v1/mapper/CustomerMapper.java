package com.myprojects.spring.examples.SpringMVCRestWS.api.v1.mapper;

import com.myprojects.spring.examples.SpringMVCRestWS.api.v1.model.CustomerDTO;
import com.myprojects.spring.examples.SpringMVCRestWS.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDTO cusomterToCustomerDTO(Customer customer);
}
