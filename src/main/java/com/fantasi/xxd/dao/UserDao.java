package com.fantasi.xxd.dao;

import com.fantasi.xxd.entity.User;

import java.util.List;

/**
 * @author xxd
 * @date 2019/12/16 10:47
 */
public interface UserDao {

    List<User> selectUsers();

    int insertUser(User user);
}
