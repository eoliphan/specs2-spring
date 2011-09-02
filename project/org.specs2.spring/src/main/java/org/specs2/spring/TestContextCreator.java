package org.specs2.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.test.context.ContextConfiguration;

/**
 * Creates Spring ApplicationContext for the test
 *
 * @author janmachacek
 */
class TestContextCreator {

	/**
	 * Creates the {@link ApplicationContext} and autowire the fields / setters test object.
	 *
	 * @param specification the specification object to set up.
	 */
	void createAndAutowire(Object specification) {
		final ContextConfiguration contextConfiguration = AnnotationUtils.findAnnotation(specification.getClass(), ContextConfiguration.class);
		if (contextConfiguration == null) return;
		
		ApplicationContext context = new ClassPathXmlApplicationContext(contextConfiguration.value());
		context.getAutowireCapableBeanFactory().autowireBean(specification);
	}

}