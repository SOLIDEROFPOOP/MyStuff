package com.muratkapparov.carrentapp.CarRentApp.Service;

import com.muratkapparov.carrentapp.CarRentApp.Repository.CarRepository;
import com.muratkapparov.carrentapp.CarRentApp.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;
    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
}
