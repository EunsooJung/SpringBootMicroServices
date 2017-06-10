/**
 * 
 */
package com.ej.microservices.initializer;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @author eunsoojung
 *
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExampleApplicationContextInitializer
		implements ApplicationContextInitializer<ConfigurableApplicationContext> {

	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		applicationContext.getBeanFactory()
			.registerSingleton("printNamePostProcessor", 
					new BeanPostProcessor() {

						/* (non-Javadoc)
						 * @see org.springframework.beans.factory.config.BeanPostProcessor#postProcessBeforeInitialization(java.lang.Object, java.lang.String)
						 */
						@Override
						public Object postProcessBeforeInitialization(Object bean, String beanName)
								throws BeansException {
							return bean;
						}

						/* (non-Javadoc)
						 * @see org.springframework.beans.factory.config.BeanPostProcessor#postProcessAfterInitialization(java.lang.Object, java.lang.String)
						 */
						@Override
						public Object postProcessAfterInitialization(Object bean, String beanName)
								throws BeansException {
							System.out.println("Initialized bean: " + beanName);
							return bean;
						}
				
			});
	}

}
