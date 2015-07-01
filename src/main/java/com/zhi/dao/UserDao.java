package com.zhi.dao;

import com.zhi.entity.User;

/**
 * Created by paul on 2015/7/1.
 */
public interface UserDao {
    int login(User user);
    boolean register(User user);
}
