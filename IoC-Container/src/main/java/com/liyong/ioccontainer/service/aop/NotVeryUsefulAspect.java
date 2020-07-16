package com.liyong.ioccontainer.service.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className NotVeryUsefulAspect
 * @description
 * @JunitTest: {@link  }
 * @date 2020-07-16 21:42
 **/
@Aspect
public class NotVeryUsefulAspect {

    /**
     * 定义命名切入点
     */
    @Pointcut("execution(public * *(..))")
    private void anyPublicOperation() {
    }

    /**
     * 在这个com.liyong.ioccontainer.service.aop.busness包中所有方法被拦截
     */
    @Pointcut("within(com.liyong.ioccontainer.service.aop.busness..*)")
    private void inBusness() {
    }

    /**
     * 使用anyPublicOperation和inBusness切入点
     */
    @Pointcut("anyPublicOperation() && inBusness()")
    private void tradingOperation() {
    }


    @Pointcut("this(com.liyong.ioccontainer.service.aop.busness.Busness)")
    private void thisOperation() {
    }

    @Pointcut("this(com.liyong.ioccontainer.service.aop.AopService)")
    private void thisAopServiceOperation() {
    }

    /**
     * 例如A继承了B接口，则使用target（"B"），target（"A"）均可以匹配到A
     */
    //@Pointcut("target(com.liyong.ioccontainer.service.aop.busness.Busness)")
    @Pointcut("target(com.liyong.ioccontainer.service.aop.busness.BusnessImpl)")
    private void targetOperation() {
    }


    /**
     * 匹配bean名称或id以Impl结尾的bean
     */
    @Pointcut("bean(*Impl)")
    private void beanOperation() {
    }

    /**
     * 方法上存在指定注解
     */
    @Pointcut("@annotation(org.springframework.beans.factory.annotation.Qualifier)")
    private void annotationOperation() {
    }

    /**
     * 方法参数引用类型中存在指定注解
     */
    @Pointcut("@args(com.liyong.ioccontainer.service.aop.Monitor)")
    private void argsOperation() {
    }

    /**
     * 在目标对象上持有注解，接口上无效
     */
    @Pointcut("@target(com.liyong.ioccontainer.service.aop.Monitor)")
    private void annotationTargetOperation() {
    }

    /**
     * 在目标对象上持有注解，接口上无效
     */
    @Pointcut("@within(com.liyong.ioccontainer.service.aop.MyWithin)")
    private void annotationWithinOperation() { }

    /**
     * 在目标对象上持有注解，接口上无效
     */
    @Pointcut("args(com.liyong.ioccontainer.service.aop.Person)")
    private void argsWithinOperation() { }

    /**
     * 前置通知并使用anyPublicOperation切入点
     */
//    @Before("com.liyong.ioccontainer.service.aop.NotVeryUsefulAspect.anyPublicOperation()")
//    public void doAccessCheck() {
//        System.out.println("the doAccessCheck is exec Before notification");
//    }


//    @Before("com.liyong.ioccontainer.service.aop.NotVeryUsefulAspect.thisOperation()")
//    public void doThis(){
//        System.out.println("the doThis is exec Before notification");
//    }

//    @Before("com.liyong.ioccontainer.service.aop.NotVeryUsefulAspect.targetOperation()")
//    public void doTarget(){
//        System.out.println("the doTarget is exec Before notification");
//    }

//    @Before("com.liyong.ioccontainer.service.aop.NotVeryUsefulAspect.beanOperation()")
//    public void doBean() {
//        System.out.println("the doBean is exec Before notification");
//    }

//    @Before("com.liyong.ioccontainer.service.aop.NotVeryUsefulAspect.annotationOperation()")
//    public void doAnnotation() {
//        System.out.println("the doAnnotation is exec Before notification");
//    }

//    @Before("com.liyong.ioccontainer.service.aop.NotVeryUsefulAspect.argsOperation()")
//    public void doArgs() {
//        System.out.println("the doArgs is exec Before notification");
//    }

//    @Before("com.liyong.ioccontainer.service.aop.NotVeryUsefulAspect.annotationTargetOperation()")
//    public void doAnnotationTargetOperation() {
//        System.out.println("the doAnnotationTargetOperation is exec Before notification");
//    }

//    @Before("com.liyong.ioccontainer.service.aop.NotVeryUsefulAspect.annotationWithinOperation()")
//    public void doAnnotationWithinOperation() {
//        System.out.println("the doAnnotationWithinOperation is exec Before notification");
//    }

    /**
     * 前置通知
     */
    @Before("com.liyong.ioccontainer.service.aop.NotVeryUsefulAspect.argsWithinOperation()")
    public void doArgsWithinOperation() {
        System.out.println("the doArgsWithinOperation is exec Before notification");
    }

    /**
     * 返回通知
     * @param retVal
     */
    @AfterReturning(pointcut = "com.liyong.ioccontainer.service.aop.NotVeryUsefulAspect.argsWithinOperation()",returning="retVal")
    public void doAccessCheck(Object retVal) {
        System.out.println("the doArgsWithinOperation is exec AfterReturning notification and thd return value is "+retVal);
    }


    @AfterThrowing(pointcut = "com.liyong.ioccontainer.service.aop.NotVeryUsefulAspect.thisAopServiceOperation()",throwing="ex")
    public void doRecoveryActions(RuntimeException ex) {

        System.out.println("the doRecoveryActions is exec AfterThrowing notification");

        System.out.println(ex.getMessage());

    }

    @After("com.liyong.ioccontainer.service.aop.NotVeryUsefulAspect.argsWithinOperation()")
    public void doReleaseLock() {

        System.out.println("the doReleaseLock is exec After notification");

    }

    @Around("com.liyong.ioccontainer.service.aop.NotVeryUsefulAspect.argsWithinOperation()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("the doBasicProfiling is exec Before notification");
        // start stopwatch
        Object retVal = pjp.proceed();
        System.out.println("the doBasicProfiling is exec After notification");
        // stop stopwatch
        return retVal;
    }

}
