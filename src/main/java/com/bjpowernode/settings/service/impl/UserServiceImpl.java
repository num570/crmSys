package com.bjpowernode.settings.service.impl;

import com.bjpowernode.exception.LoginException;
import com.bjpowernode.settings.dao.UserDao;
import com.bjpowernode.settings.domain.User;
import com.bjpowernode.settings.service.UserService;
import com.bjpowernode.utils.DateTimeUtil;
import com.bjpowernode.utils.SqlSessionUtil;

public class UserServiceImpl implements UserService {
    UserDao userDao = SqlSessionUtil.getSqlSession().getMapper(UserDao.class);

    @Override
    public User login(String loginAct, String loginPwd, String ip) throws LoginException {
        User user = userDao.login(loginAct,loginPwd);

        if(user==null){
            throw new LoginException("账号密码错误");
        }

        String expireTime = user.getExpireTime();
        if(DateTimeUtil.getSysTime().compareTo(expireTime) > 0){
            throw new LoginException("账号已失效");
        }
        String lockState = user.getLockState();
        if("0".equals(lockState)){
            throw new LoginException("账号已锁定");
        }

        String allowIps = user.getAllowIps();
        if(!allowIps.contains(ip)){
            throw new LoginException("ip地址受限");
        }
        return user;
    }
}
