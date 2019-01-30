package com.bootdo.system.config;

import com.bootdo.system.shiro.UserRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.HashMap;
import java.util.Map;

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

        bean.setLoginUrl("/login");
        bean.setSuccessUrl("/index");
        bean.setUnauthorizedUrl("403");
        Map<String, String> filterChainMap = new HashMap<>();
        filterChainMap.put("/login", "anon");
        filterChainMap.put("/css/**", "anon");
        filterChainMap.put("/docs/**", "anon");
        filterChainMap.put("/editor-app/**", "anon");
        filterChainMap.put("/fonts/**", "anon");
        filterChainMap.put("/img/**", "anon");
        filterChainMap.put("/js/**", "anon");
        filterChainMap.put("/css/**", "anon");
        filterChainMap.put("/**", "authc");             // 全部拦截
        bean.setFilterChainDefinitionMap(filterChainMap);
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
