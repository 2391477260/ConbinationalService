package com.hnust.serverproviderc.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.hnust.serverproviderc.my.JNIDemo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by javy on 2021/7/1 14:15
 */
@RestController
public class DcController {
    @Value("${server.port}")
    private int port;
    @RequestMapping(value = "/C-service", method = RequestMethod.GET)
    public String C_service(@RequestParam String str) {
        try {
            Entry entry= SphU.entry("FlowRulesName");
            InetAddress address=InetAddress.getLocalHost();
            return "Hello结果为："+JNIDemo.Hello(str)
                    +"<br>"+
                    "该服务的IP为：" +address
                    +"<br>" +
                    "该服务端口号为："+port;
        }catch (Exception e){
            e.printStackTrace();
            return "系统繁忙，请稍后";
        }
    }
    /*定义限流规则*/
    @PostConstruct
    public void initFlowRules(){
        List<FlowRule> rules=new ArrayList<>();
        FlowRule rule=new FlowRule();
        rule.setResource("FlowRulesName");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setCount(10);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);

    }

}

