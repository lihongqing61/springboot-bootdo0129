package com.bootdo.common.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Auther: Lihq
 * @Date: 2019/1/30 21:48
 * @Description: 切面
 */

@Aspect     // 1. @Aspect 表明这是一个切面类
@Slf4j
@Component
public class WebLogAspect {

    /**
     * 2. 定义切点
     */
    @Pointcut("execution(* com.bootdo..controller.*.*(..))")    // 两个..代表所有子目录，最后括号里的两个..代表所有参数
    public void pointcut() {}

    /**
     * 3. 前置监听
     * @param point
     */
    @Before(value = "pointcut()")
    public void before(JoinPoint point) {
        // 获取request对象
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        log.info("请求地址:"+request.getRequestURL().toString());
        log.info("请求方法:"+point.getSignature().getDeclaringTypeName()+"."+point.getSignature().getName());
        log.info("请求方式:"+request.getMethod());
        log.info("请求参数:"+Arrays.asList(point.getArgs()));
    }

    /**
     * 4. 环绕监听
     */
    @Around(value = "pointcut()")
    public Object around(ProceedingJoinPoint pip) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object obj = pip.proceed();
        log.info("共计耗时:"+(System.currentTimeMillis() - startTime));
        return obj;
    }

    /**
     * 5. 后置监听
     */
    @AfterReturning(value = "pointcut()", returning = "ret")
    public void after(Object ret) {
        log.info("返回值:"+ret);
    }
}
