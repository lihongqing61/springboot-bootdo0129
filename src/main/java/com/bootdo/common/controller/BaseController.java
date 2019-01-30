package com.bootdo.common.controller;

import com.bootdo.common.utils.ShiroUtils;
import com.bootdo.system.domain.UserDO;

/**
 * @Auther: Lihq
 * @Date: 2019/1/29 21:41
 * @Description: 基本控制器
 */
public class BaseController {

    /**
     * 获取当前用户
     * @return
     */
    public UserDO getUser() {
        return ShiroUtils.getUser();
    }

    /**
     * 获取当前用户id
     * @return
     */
    public Long getUserId() {
        return getUser().getUserId();
    }

    /**
     * 获取当前用户名
     * @return
     */
    public String getUsername() {
        return getUser().getUsername();
    }
}
