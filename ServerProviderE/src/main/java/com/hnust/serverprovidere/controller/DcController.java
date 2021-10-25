package com.hnust.serverprovidere.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by javy on 2021/9/16 11:02
 */
@RestController
public class DcController {
    @RequestMapping(value="/E-service", method= RequestMethod.GET)
    public Integer CalculateArea(HttpServletRequest req){
        try {
            Entry entry= SphU.entry("FlowRulesName");
            int x=Integer.parseInt(req.getParameter("x"));
            int y=Integer.parseInt(req.getParameter("y"));
            return x*y/2;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
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
