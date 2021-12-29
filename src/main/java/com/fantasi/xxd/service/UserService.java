package com.fantasi.xxd.service;

import com.fantasi.xxd.entity.User;
import com.github.pagehelper.PageInfo;

/**
 * @author xxd
 * @date 2019/12/16 10:55
 */
public interface UserService {
    PageInfo<User> findAllUser(int pageNum, int pageSize);

    int addUser(User user);
}
