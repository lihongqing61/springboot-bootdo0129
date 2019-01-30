package com.bootdo.system.controller;

import com.bootdo.common.controller.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}
