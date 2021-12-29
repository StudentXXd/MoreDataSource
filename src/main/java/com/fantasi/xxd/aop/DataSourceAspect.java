package com.fantasi.xxd.aop;

import com.fantasi.xxd.config.DataSource;
import com.fantasi.xxd.config.DataSourceContextHolder;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author xxd
 * @date 2019/12/17 15:15
 */
@Aspect
@Component
public class DataSourceAspect {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * @annotation  代表 拦截所有带@DataSource的方法   @within 代表  拦截所有带@DataSource的类
     */
    @Pointcut("@annotation(com.fantasi.xxd.config.DataSource) || @within(com.fantasi.xxd.config.DataSource)")
    public void dbPointCut(){}

    @Before("@annotation(dataSource)")
    public void beforeSwitchDS(DataSource dataSource){
        logger.info("选择数据源---"+dataSource.value().getValue());
        DataSourceContextHolder.setDB(dataSource.value());
    }

    @After("dbPointCut()")
    public void doAfter(){
        DataSourceContextHolder.clearDB();
    }

//    @Pointcut("@annotation(com.fantasi.xxd.config.DataSource)")
//    public void dbPointCut(){}
//
//    @Before("dbPointCut()")
//    public void beforeSwitchDS(JoinPoint point){
//        //获得当前访问的class
//        Class<?> className = point.getTarget().getClass();
//        //获得访问的方法名
//        String methodName = point.getSignature().getName();
//        //得到方法的参数的类型
//        Class[] argClass = ((MethodSignature)point.getSignature()).getParameterTypes();
//        String dataSource = DataSourceContextHolder.DEFAULT_DS;
//        try{
//            // 得到访问的方法对象
//            Method method = className.getMethod(methodName, argClass);
//            // 判断是否存在@DateSource注解
//            if (method.isAnnotationPresent(DataSource.class)){
//                DataSource annotation = method.getAnnotation(DataSource.class);
//                // 切换数据源  枚举类
////                DataSourceContextHolder.setDB(annotation.value());
//                // 取出注解中的数据源名
//                dataSource = annotation.value().getValue();
//            }
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//        // 切换数据源  字符串
//        DataSourceContextHolder.setDB(dataSource);
//    }
//
//    @After("dbPointCut()")
//    public void afterSwitchDS(JoinPoint point){
//        DataSourceContextHolder.clearDB();
//    }
}
