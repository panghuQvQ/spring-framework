package com.zhouyu.postProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author wzy
 * @version 1.0.0
 * @ClassName CeshiBeanFactoryPostProcessor.java
 * @Description TODO
 * @createTime 2022年09月01日 21:19:00
 */
@Component
public class CeshiBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
	}
}
