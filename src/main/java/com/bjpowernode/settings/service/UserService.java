package com.bjpowernode.settings.service;

import com.bjpowernode.exception.LoginException;
import com.bjpowernode.settings.domain.User;

public interface UserService {
    User login(String loginAct, String loginPwd, String ip) throws LoginException;
}
