package com.example.logging;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.logging.Logger;

@Component
public class MyApplicationRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        Logger logger = Logger.getLogger(MyApplicationRunner.class.getName());
        logger.info("Application Started");
        logger.info("Application Finished");
        try{
            int result = Integer.parseInt(args[0]) / Integer.parseInt(args[1]);
        } catch (ArithmeticException e) {
            logger.warning("Division by zero is not allowed");      
        }
        
        
          
    }
}