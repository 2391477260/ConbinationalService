package com.hnust.consumerb.services;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by javy on 2021/7/1 16:29
 */
@FeignClient(name="eureka-provider-C",path="/C-service")
public interface ServerProvierC {
    @RequestMapping(path = "/",method = RequestMethod.GET)
    String C_Server(@RequestParam("str") String str);
}
