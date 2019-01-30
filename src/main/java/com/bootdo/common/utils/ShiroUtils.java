package com.bootdo.common.utils;

import com.bootdo.system.domain.UserDO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * @Auther: Lihq
 * @Date: 2019/1/30 21:17
 * @Description: shiro工具类
 */
public class ShiroUtils {

    /**
     * 获取shiro主体
     * @return
     */
    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    /**
     * 获取当前用户信息
     * @return
     */
    public static UserDO getUser() {
        return(UserDO) getSubject().getPrincipal();
    }

    /**
     * 获取当前用户id
     * @return
     */
    public static Long getUserId() {
        return getUser().getUserId();
    }
}
