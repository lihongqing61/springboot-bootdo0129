package com.bootdo.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * Created by Lihq on 2018/12/11 15:57
 * Description: 用户实体类
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDO extends BaseDO {

    /**
     * 用户主键
     */
    private Long userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户真实姓名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 部门
     */
    private Long deptId;

    /**
     * 用户的部门名称
     */
    private String deptName;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 状态 0:禁用，1:正常
     */
    private Integer status;

    /**
     *  创建用户id
     */
    private Long userIdCreate;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModified;

    /**
     * 角色
     */
    private List<Long> roleIds;

    /**
     * 性别
     */
    private Long sex;

    /**
     * 出身日期
     */
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;

    /**
     * 图片ID
     */
    private Long picId;

    /**
     * 现居住地
     */
    private String liveAddress;

    /**
     * 爱好
     */
    private String hobby;

    /**
     * 省份
     */
    private String province;

    /**
     * 所在城市
     */
    private String city;

    /**
     * 所在地区
     */
    private String district;
}
