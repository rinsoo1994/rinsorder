package com.rinsorder.beanfind;

import com.rinsorder.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(AppConfig.class);
    static String beanTemplate = "-------Print bean-------";

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionNames = acac.getBeanDefinitionNames();

        System.out.println(beanTemplate);
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = acac.getBean(beanDefinitionName);
            System.out.println("name: " + beanDefinitionName + "bean object: " + bean);
        }
    }

    @Test
    @DisplayName("직접 등록한 애플리케이션빈 출력하기")
    void findApplicationBean() {
        String[] beanDefinitionNames = acac.getBeanDefinitionNames();

        // BeanDefinition.ROLE_APPLICATION: 직접 등록한 애플리케이션 빈
        // BeanDefinition.ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈
        System.out.println(beanTemplate);
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = acac.getBeanDefinition(beanDefinitionName);
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = acac.getBean(beanDefinitionName);
                System.out.println("name: " + beanDefinitionName + "bean object: " + bean);
            }
        }
    }
}
