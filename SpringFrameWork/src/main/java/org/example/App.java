package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        // Engine eng = (Dev) context.getBean("dev");
        Engine eng = context.getBean("engine", Engine.class);
        eng.start();
    }
}
