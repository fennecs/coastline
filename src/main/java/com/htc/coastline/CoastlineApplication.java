package com.htc.coastline;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoastlineApplication {
    private static final Logger log = LoggerFactory.getLogger(CoastlineApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CoastlineApplication.class, args);
    }
}
