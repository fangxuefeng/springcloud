package springcloud.eureka.client.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class Log {

    private Logger logger = LoggerFactory.getLogger(Log.class);

    @Pointcut(value = "execution(public * springcloud.eureka.client.service.impl.HelloRemote.*(..))")
    private void log() {
//        logger.info("this is a aop test!");

    }

    @Before(value = "log()")
    public void before(JoinPoint joinPoint) {
        ServletRequestAttributes sa = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sa.getRequest();
        // 获取用户访问的url
        logger.info("url={}", request.getRequestURL());
        // 获取用户访问的方式，get/post
        logger.info("method={}", request.getMethod());
        // 获取的ip
        logger.info("ip={}", request.getRemoteAddr());
        // 获取用户访问的是哪个方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        // 获取方法的参数
        logger.info("args={}", joinPoint.getArgs());
    }

    @After(value = "log()")
    public void after() {
        logger.info("记录操作后");
    }

    //    @AfterReturning(value= "log()")
//    public void afterReturning(){
//        logger.info("正常返回后操作！");
//    }
    @AfterThrowing(value = "log()",throwing = "e")
    public void throwAfterReturning(Exception e) {
        logger.info("异常返回后操作！");
    }


    @Around(value = "log()")
    public Object aroundAdvice(ProceedingJoinPoint jp) throws Throwable {
        logger.info("环绕通知前操作！");
        Object obj = jp.proceed();
        logger.info("环绕通知后操作！");
        return obj;
    }

    /**
     * 打印返回的内容
     *
     * @param object
     */
    @AfterReturning(value = "log()", returning = "object")
    public void afterReturn(Object object) {
        logger.info("object={}", object);
    }

}
