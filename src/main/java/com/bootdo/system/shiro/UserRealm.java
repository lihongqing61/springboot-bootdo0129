package com.bootdo.system.shiro;

import com.bootdo.system.dao.UserDao;
import com.bootdo.system.domain.UserDO;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Lihq
 * @Date: 2019/1/29 21:47
 * @Description: UserRealm
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserDao userDao;

    /**
     * 用户认证方法
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());

        Map paramMap = new HashMap();
        paramMap.put("username", username);
        List<UserDO> userList = userDao.list(paramMap);

        if (userList == null || userList.size() == 0) {
            throw new UnknownAccountException();
        } else {
            UserDO user = userList.get(0);
            if (!password.equals(user.getPassword())) {
                throw new IncorrectCredentialsException();
                // 0 禁用
            } else if (0 == user.getStatus()) {
                throw new DisabledAccountException();
            }

            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
            return info;
        }
    }


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

}
