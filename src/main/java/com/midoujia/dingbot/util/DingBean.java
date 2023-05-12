package com.midoujia.dingbot.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author zfldiv <zfldiv@163.com>
 */
@Component
public class DingBean implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        DingBean.applicationContext = applicationContext;
    }

    /**
     * 通过名称获取
     * @param name
     * @return
     */
    public static Object getBean(String name) {
        return DingBean.applicationContext.getBean(name);
    }

    /**
     * 通过类型获取
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz){
        return DingBean.applicationContext.getBean(clazz);
    }

    /**
     * 通过名称和类型获取
     * @param name
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(String name, Class<T> clazz){
        return DingBean.applicationContext.getBean(name, clazz);
    }

    /**
     * 获取当前的运行环境信息
     * @return
     */
    public static Environment getEnvironment(){
        return DingBean.applicationContext.getEnvironment();
    }

}