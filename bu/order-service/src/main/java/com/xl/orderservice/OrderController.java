package com.xl.orderservice;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/order")
@RestController
public class OrderController {
    private final Logger logger = Logger.getLogger(getClass());
    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @RequestMapping(value = "/ping" ,method = RequestMethod.GET)
    public String verify(){
        return "Pong";
    }

    @RequestMapping(value = "/setValue" ,method = RequestMethod.GET)
    public String writeRedis( @RequestParam String redisKey, @RequestParam String redisValue ){
        try {
            stringRedisTemplate.opsForValue().set( redisKey , redisValue);
            return  stringRedisTemplate.opsForValue().get( redisKey );
        }
        catch (Exception ex){
            return ex.getMessage();
        }
    }

    @RequestMapping(value = "/getValue" ,method = RequestMethod.GET)
    public String readRedis( @RequestParam String redisKey ){
        return  stringRedisTemplate.opsForValue().get( redisKey );
    }
}
