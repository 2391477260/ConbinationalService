package com.hnust.serverproviderd.controller;


import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
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
 * Created by javy on 2021/7/1 14:29
 */
@RestController
public class DcController {
    @Value("${server.port}")
    private String port;
    @RequestMapping(value="/D-service", method= RequestMethod.GET)
    public String D_service(@RequestParam String str) {
        try {
            Entry entry= SphU.entry("FlowRulesName");
            String result = new StringBuilder(str).reverse().toString();
            InetAddress address=InetAddress.getLocalHost();
            return "逆序结果为："+result
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
        rule.setCount(2000);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);

    }
}

