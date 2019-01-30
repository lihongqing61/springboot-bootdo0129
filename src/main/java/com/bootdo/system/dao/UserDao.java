package com.bootdo.system.dao;

import com.bootdo.system.domain.UserDO;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Lihq
 * @Date: 2019/1/30 14:38
 * @Description:
 */

//@Mapper
public interface UserDao {

    List<UserDO> list(Map paramMap);
}
