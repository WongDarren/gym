package com.wongdarren;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.jboss.logging.Logger;

@QuarkusMain
public class Application {
    private static final Logger LOGGER = Logger.getLogger(Application.class);

    public static void main(String[] args) {
        // Any additional setup or initialization can go here

        // Start the Quarkus application
        LOGGER.info("Starting Quarkus application...");
        Quarkus.run(args);
    }
}