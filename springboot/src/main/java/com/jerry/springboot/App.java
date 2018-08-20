package com.jerry.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages={"com.jerry"})
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    	System.out.println( "Hello World!" );
    }
}
