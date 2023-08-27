package com.muratkapparov.carrentapp.CarRentApp.Controller;

import com.muratkapparov.carrentapp.CarRentApp.Service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rents")
public class RentController {
    @Autowired
    private RentService rentService;

}
