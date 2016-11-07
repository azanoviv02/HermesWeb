package com.hermes.hermes.userinterface;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ivan on 05.11.16.
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Controller controller = context.getBean(Controller.class);
        controller.launch();
    }
}
