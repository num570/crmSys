package com.bjpowernode.workbench.service;

import com.bjpowernode.settings.domain.User;
import com.bjpowernode.vo.PaginationVO;
import com.bjpowernode.workbench.domain.Activity;

import java.util.List;
import java.util.Map;

public interface ActivityService {
    List<User> getUserList();

    Boolean save(Activity a);

    PaginationVO<Activity> pageList(Map<String, Object> map);

    boolean delete(String[] ids);

    Map<String, Object> getUserListAndActivity(String id);

    Boolean update(Activity a);
}
