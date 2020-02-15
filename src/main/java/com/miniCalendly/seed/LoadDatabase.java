package com.miniCalendly.seed;

import com.miniCalendly.model.Opening;
import com.miniCalendly.model.User;
import com.miniCalendly.repository.OpeningRepository;
import com.miniCalendly.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {
    @Bean
    CommandLineRunner initUserTable(UserRepository repository) {
        return args -> {
            log.info("Preloading " + repository
                    .save(new User("bilbo", "Bilbo Baggins", "03:00")));
            log.info("Preloading " + repository
                    .save(new User("frodo", "Frodo Baggins", "02:00")));
        };
    }

    @Bean
    CommandLineRunner initOpeningTable(OpeningRepository repository) {
        return args -> {
            log.info("Preloading " + repository
                    .save(new Opening((long) 1, "2020-02-15T16:20:13.274+0000")));
            log.info("Preloading " + repository
                    .save(new Opening((long) 1, "2020-02-16T16:20:13.274+0000")));
            log.info("Preloading " + repository
                    .save(new Opening((long) 1, "2020-02-17T16:20:13.274+0000")));
            log.info("Preloading " + repository
                    .save(new Opening((long) 1, "2020-02-18T16:20:13.274+0000")));
            log.info("Preloading " + repository
                    .save(new Opening((long) 1, "2020-02-19T16:20:13.274+0000")));
            log.info("Preloading " + repository
                    .save(new Opening((long) 1, "2020-02-20T16:20:13.274+0000")));
        };
    }
}
