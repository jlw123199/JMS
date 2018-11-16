package com.xl.orderservice;


import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/order")
@RestController
public class OrderController {
    private final Logger logger = Logger.getLogger(getClass());

    @RequestMapping(value = "/ping" ,method = RequestMethod.GET)
    public String verify(){
        return "Pong";
    }
}
