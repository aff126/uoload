package com.sofftron.softtronvodeo.domain;


import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;



public class WindowsCondition implements Condition {
	/**
	 * @param conditionContext:判断条件能使用的上下文环境
	 * @param annotatedTypeMetadata:注解所在位置的注释信息
	 * */
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //获取ioc使用的beanFactory
		ConfigurableListableBeanFactory  configurableListableBeanFactory = context.getBeanFactory();
        //获取类加载器
		ClassLoader classLoader = context.getClassLoader();
		 //获取当前环境信息
		Environment environment = context.getEnvironment();
		//获取bean定义的注册类
		BeanDefinitionRegistry beanDefinitionRegistry = context.getRegistry();
		//获得当前系统名	
		String priperties = environment.getProperty("os.name");
		//包含Windows则说明是windows系统，返回true
		if(priperties.contains("Windows")) {
			return true;
		}
		return false;
	}
	
}
