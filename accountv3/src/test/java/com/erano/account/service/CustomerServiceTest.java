package com.erano.account.service;

import com.erano.account.dto.CustomerDto;
import com.erano.account.dto.CustomerDtoConverter;
import com.erano.account.exception.CustomerNotFoundException;
import com.erano.account.model.Customer;
import com.erano.account.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;
import java.util.Set;

import static org.mockito.Mockito.mock;

public class CustomerServiceTest {

    private CustomerService service;

    private CustomerRepository customerRepository;
    private CustomerDtoConverter converter;


    @BeforeEach
    public void setUp(){
        customerRepository= mock(CustomerRepository.class);
        converter = mock(CustomerDtoConverter.class);
        service = new CustomerService(customerRepository,converter);
    }

    @Test
    public void testFindByCustomerId_whenCustomerIdExist_shouldReturnCustomer(){
        Customer customer = new Customer("id","name","surname", Set.of());
        Mockito.when(customerRepository.findById("id")).thenReturn(Optional.of(customer));
        Customer result = service.findCustomerById("id");
        assertEquals(result,
                customer);
    }

    @Test
    public void testFindByCustomerId_whenCustomerIdDoesNotExist_shouldThrowCustomerNotFoundException(){
        Mockito.when(customerRepository.findById("id")).thenReturn(Optional.empty());
        assertThrows(CustomerNotFoundException.class,
                ()-> service.findCustomerById("id"));


    }

    @Test
    public void testGetCustomerById_whenCustomerIdExist_shouldReturnCustomer(){
        Customer customer = new Customer("id","name","surname", Set.of());
        CustomerDto customerDto = new CustomerDto("id","name","surname", Set.of());

        Mockito.when(customerRepository.findById("id")).thenReturn(Optional.of(customer));
        Mockito.when(converter.convertToCustomerDto(customer)).thenReturn(customerDto);

        CustomerDto result = service.getCustomerById("id");

        assertEquals(result,
                customerDto);
    }
    @Test
    public void testGetCustomerById_whenCustomerIdDoesNotExist_shouldThrowCustomerNotFoundException(){

        Mockito.when(customerRepository.findById("id")).thenReturn(Optional.empty());

        assertThrows(CustomerNotFoundException.class,
                () -> service.getCustomerById("id"));

        Mockito.verifyNoInteractions(converter);
    }
}