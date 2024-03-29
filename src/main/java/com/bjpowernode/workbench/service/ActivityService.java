package com.bjpowernode.workbench.service;

import com.bjpowernode.settings.domain.User;
import com.bjpowernode.vo.PaginationVO;
import com.bjpowernode.workbench.domain.Activity;
import com.bjpowernode.workbench.domain.ActivityRemark;

import java.util.List;
import java.util.Map;

public interface ActivityService {
    List<User> getUserList();

    Boolean save(Activity a);

    PaginationVO<Activity> pageList(Map<String, Object> map);

    boolean delete(String[] ids);

    Map<String, Object> getUserListAndActivity(String id);

    Boolean update(Activity a);

    Activity detail(String id);

    List<ActivityRemark> getRemarkListByAid(String id);

    Boolean deleteById(String id);

    Boolean saveRemark(ActivityRemark ar);

    Boolean updateRemark(ActivityRemark ar);
}
