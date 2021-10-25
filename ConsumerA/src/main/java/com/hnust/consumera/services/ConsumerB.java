package com.hnust.consumera.services;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by javy on 2021/7/1 17:12
 */
@FeignClient(name="eureka-consumer-B",path="/B_Consumer")
public interface ConsumerB {
    @RequestMapping(path = "/",method = RequestMethod.GET)
    String B_Consumer(@RequestParam("str") String str);
}
