package org.starzplay.payment.paymentmethod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
/**
 * 
 * @author Fahad
 *  Starter class for initiating the Video PlatformService.
 */

@Configuration
@SpringBootApplication()
@ComponentScan("org.starzplay.payment.paymentmethod.*")



public class VideoPlatformServiceStarter extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(VideoPlatformServiceStarter.class, args);
    }
}
