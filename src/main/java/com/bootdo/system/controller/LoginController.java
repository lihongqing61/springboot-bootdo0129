package com.bootdo.system.controller;

import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.MD5Utils;
import com.bootdo.common.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: Lihq
 * @Date: 2019/1/29 21:40
 * @Description: 登录控制器
 */

@Controller
@Slf4j
public class LoginController extends BaseController {

    /**
     * 首页
     * @return
     */
    @GetMapping({"", "/"})
    public String welcome() {
        return "redirect:/blog";
    }

    /**
     * 跳转到登录页面
     * @return
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }


    /**
     * 处理登录请求
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public Result ajaxLogin(String username, String password) {
        password = MD5Utils.encrypt(username, password);

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(username, password, true);

        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            return Result.error("不存在的用户名");
        } catch (IncorrectCredentialsException e) {
            return Result.error("用户名/密码错误");
        } catch (DisabledAccountException e) {
            return Result.error("帐号被禁用, 请联系管理员");
        }
        return Result.ok();
    }

    @GetMapping("/index")
    public String index() {
        return null;
    }
}
