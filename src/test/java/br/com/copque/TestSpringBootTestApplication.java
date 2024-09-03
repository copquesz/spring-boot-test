package br.com.copque;

import org.springframework.boot.SpringApplication;

public class TestSpringBootTestApplication {

    public static void main(String[] args) {
        SpringApplication.from(SpringBootTestApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
