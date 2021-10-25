package com.hnust.consumerb.controller;

import com.hnust.consumerb.services.ServerProvierC;
import com.hnust.consumerb.services.ServerProvierD;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by javy on 2021/7/1 16:57
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DcControllerTest {
    @Autowired
    ServerProvierC serverProvierC;
    @Autowired
    ServerProvierD serverProvierD;
    @Test
    public void runC(){
        System.out.println(serverProvierC.C_Server("asdas"));
    }
    @Test
    public void runD(){
        System.out.println(serverProvierD.D_Server("dasee"));
    }
}
