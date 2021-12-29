package com.fantasi.xxd.service.impl;

import com.fantasi.xxd.config.DBTypeEnum;
import com.fantasi.xxd.config.DataSource;
import com.fantasi.xxd.dao.UserDao;
import com.fantasi.xxd.entity.User;
import com.fantasi.xxd.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xxd
 * @date 2019/12/16 10:56
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @DataSource(DBTypeEnum.db1Source)
    public PageInfo<User> findAllUser(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = userDao.selectUsers();
        PageInfo result = new PageInfo(list);
        return result;
    }

    @Override
    @DataSource(DBTypeEnum.db2Source)
    public int addUser(User user) {
        return userDao.insertUser(user);
    }
}
