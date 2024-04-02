package com.wongdarren;

import com.wongdarren.config.LoggingFilter;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.jboss.logging.Logger;

@QuarkusMain
@ApplicationPath("/api")
public class GymApplication extends Application {


  public static void main(String[] args) {
    // Any additional setup or initialization can go here
    final Logger LOG = Logger.getLogger(LoggingFilter.class);

    // Start the Quarkus application
    LOG.info("Starting Quarkus application...");
    Quarkus.run(args);
  }
}