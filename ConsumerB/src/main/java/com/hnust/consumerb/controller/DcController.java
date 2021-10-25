package com.hnust.consumerb.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.hnust.consumerb.services.ServerProvierC;
import com.hnust.consumerb.services.ServerProvierD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by javy on 2021/9/15 15:03
 */
@RestController
public class DcController {
    @Autowired
    ServerProvierC serverProvierC;
    @Autowired
    ServerProvierD serverProvierD;
    @RequestMapping(value="/B_C", method= RequestMethod.GET)
    public String Call_C_Service(@RequestParam String str){
        try {
            Entry entry= SphU.entry("FlowRulesName");
            String result = serverProvierC.C_Server(str);
            return result;
        } catch (Exception e){
            e.printStackTrace();
            return "系统繁忙，请稍后";
        }
    }
    @RequestMapping(value="/B_D", method= RequestMethod.GET)
    public String Call_D_Service(@RequestParam String str){
        String result = serverProvierD.D_Server(str);
        return result;
    }
    @RequestMapping(value="/B_Consumer", method= RequestMethod.GET)
    public String B_Consumer(@RequestParam String str){
        String result = Call_C_Service(str) + "<br> <br>";
        result += Call_D_Service(str);
        return result;
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
