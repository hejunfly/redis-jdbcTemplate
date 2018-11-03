package com.hj.u.service;

import com.hj.u.bean.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by HeJun on 2018/11/1.
 */
@Service("stockService")
public class StockServiceImpl implements StockService{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addStock() {
        RowMapper<Stock> rowMapper=new BeanPropertyRowMapper<Stock>(Stock.class);
        Stock stock=new Stock();
        stock.setStockName("python");
        stock.setStockCode("1111");
        String sqlCmd="insert into stock(stock_name,stock_code) values(?,?)";
        jdbcTemplate.update(sqlCmd,new Object[]{stock.getStockName(),stock.getStockCode()});
        //throw new Exception("test");
    }
}
