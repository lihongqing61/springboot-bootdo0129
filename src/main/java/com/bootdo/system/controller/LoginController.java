package com.bootdo.system.controller;

import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
    public Result ajaxLogin(String username, String password) {
        return null;
    }
}
