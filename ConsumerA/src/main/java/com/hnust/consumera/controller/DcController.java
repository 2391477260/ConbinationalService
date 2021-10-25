package com.hnust.consumera.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.hnust.consumera.services.ConsumerB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by javy on 2021/7/1 17:14
 */
@RestController
public class DcController {
    @Autowired
    ConsumerB consumerB;
    @RequestMapping(value="/A_Consumer", method= RequestMethod.GET)
    public String Call_B_Consumer(@RequestParam String str){
        try {
            Entry entry= SphU.entry("FlowRulesName");
            String result = consumerB.B_Consumer(str);
            return result;
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
        rule.setCount(2);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);

    }
}
