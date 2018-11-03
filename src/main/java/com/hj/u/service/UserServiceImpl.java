package com.hj.u.service;

import com.hj.u.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by HeJun on 2018/11/1.
 */
@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<User> getUsers() {
        String sqlCmd="select id,age,name from user";
        /*List<User> rs=jdbcTemplate.query(sqlCmd, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User userTmp=new User();
                userTmp.setId((int) resultSet.getLong("id"));
                userTmp.setAge(resultSet.getInt("age"));
                userTmp.setName(resultSet.getString("name"));
                return userTmp;
            }
        });*/
        RowMapper<User> rowMapper=new BeanPropertyRowMapper<User>(User.class);
        List<User> rs=jdbcTemplate.query(sqlCmd,rowMapper);
        return rs;
    }

    @Override
    @Transactional(rollbackFor = {RuntimeException.class,Exception.class})
    public void addUser(){
        User user=new User();
        user.setId(3);
        user.setAge(50);
        user.setName("ddd");
        String sqlCmd="insert into user(id,age,name) values(?,?,?)";
        jdbcTemplate.update(sqlCmd,new Object[]{user.getId(),user.getAge(),user.getName()});
        throw new RuntimeException("测试回滚");
    }
}
