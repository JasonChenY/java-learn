package com.cpq.b.b;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;


@EnableHelloWorld
public class B_Bootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(B_Bootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        String helloWorld = context.getBean("helloWorld",String.class);
        System.out.println("获取到bean " + helloWorld);

        Bean01 bean01 =  context.getBean("bean01", Bean01.class);
        System.out.println("获取bean01   "+ bean01.toString());

        context.close();
    }
}
