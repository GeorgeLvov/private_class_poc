package com.test.core;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.retry.annotation.EnableRetry;

import java.time.ZoneId;
import java.util.TimeZone;

@EnableRetry
@ComponentScan(
        basePackages = {
                "com.test.core"})
public class Application {

    public static void main(final String[] args)
    {
        SpringApplication.run(Application.class, args);
    }
}
