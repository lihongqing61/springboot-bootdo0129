package com.bootdo.blog.controller;

import com.bootdo.common.controller.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: Lihq
 * @Date: 2019/1/29 21:51
 * @Description: 博客控制器
 */

@Controller
@Slf4j
@RequestMapping("/blog")
public class BlogController extends BaseController {

    /**
     * 跳转到blog/index/main页面
     * @return
     */
    @GetMapping("")
    public String blog() {
        return "blog/index/main";
    }
}
