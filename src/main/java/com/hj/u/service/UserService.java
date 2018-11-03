package com.hj.u.service;

import com.hj.u.bean.User;

import java.util.List;

/**
 * Created by HeJun on 2018/11/1.
 */
public interface UserService {
    public List<User> getUsers();
    public void addUser() throws Exception;
}
