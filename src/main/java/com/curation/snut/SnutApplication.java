package com.curation.snut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
<<<<<<< HEAD
@EnableJpaAuditing
=======

>>>>>>> ca64f923ad2d113526a840b7f662fa703d16aa2f
@SpringBootApplication
@EnableJpaAuditing
public class SnutApplication {

    public static void main(String[] args) {
        SpringApplication.run(SnutApplication.class, args);
    }

}
