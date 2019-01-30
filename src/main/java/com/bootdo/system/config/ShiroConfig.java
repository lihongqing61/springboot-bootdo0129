package com.bootdo.system.config;

import com.bootdo.system.shiro.UserRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: Lihq
 * @Date: 2019/1/29 21:43
 * @Description: shiro配置类
 */

@Configuration
public class ShiroConfig {

    /**
     *  shiroFilterFactoryBean
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();

        //1. 设置安全管理器
        bean.setSecurityManager(securityManager);
        return bean;
    }

    /**
     * 安全管理器
     * @return
     */
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //1. 设置realm
        securityManager.setRealm(userRealm());
        return securityManager;
    }

    /**
     * userRealm
     * @return
     */
    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }
}
