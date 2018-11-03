package com.hj.u.handler;

import com.hj.u.service.StockService;
import com.hj.u.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by HeJun on 2018/11/1.
 */
@Component("testHandler")
public class TestHandler {
    @Autowired
    private StockService stockService;
    @Autowired
    private UserService userService;
    @Transactional(rollbackFor = {Exception.class,RuntimeException.class})
    public void handler(){
        try {
            stockService.addStock();
            userService.addUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
