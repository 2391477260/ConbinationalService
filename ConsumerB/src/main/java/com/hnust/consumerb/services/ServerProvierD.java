package com.hnust.consumerb.services;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by javy on 2021/7/1 16:39
 */
@FeignClient(name="eureka-provider-D",path="/D-service")
public interface ServerProvierD {
    @RequestMapping(path = "/",method = RequestMethod.GET)
    String D_Server(@RequestParam("str") String str);
}
