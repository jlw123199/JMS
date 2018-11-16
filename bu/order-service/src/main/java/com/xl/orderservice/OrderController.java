package com.xl.orderservice;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.xl.orderservice.modules.OrderModel;
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

    @RequestMapping(value = "/setValueWithPost" ,method = RequestMethod.POST)
    public String writeRedisWithPost( @RequestBody OrderModel orderModel){
        try {
            ObjectMapper mapper = new ObjectMapper();

            stringRedisTemplate.opsForValue().set( orderModel.getOrderId() , mapper.writeValueAsString(orderModel));
            return  stringRedisTemplate.opsForValue().get( orderModel.getOrderId() );
        }
        catch (Exception ex){
            return ex.getMessage();
        }
    }

    @RequestMapping(value = "/getValue" ,method = RequestMethod.GET)
    public String readRedis( String redisKey ){
        return  stringRedisTemplate.opsForValue().get( redisKey );
    }


}
