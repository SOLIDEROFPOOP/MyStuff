package com.muratkapparov.carrentapp.CarRentApp.Service;

import com.muratkapparov.carrentapp.CarRentApp.Repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentService {
    private RentRepository rentRepository;
    @Autowired
    public RentService(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }
}
