package xyz.afrinnov.kafka.poc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import xyz.afrinnov.kafka.poc.dto.UserDTO;

@SpringBootApplication
public class PocApplication {

    public static void main(String[] args) {
        SpringApplication.run(PocApplication.class, args);
    }

    /*@Bean
    CommandLineRunner commandLineRunner(KafkaTemplate<String,String> kafkaTemplate){
        return args -> {

            for (int i = 0; i < 10_000; i++) {

                kafkaTemplate.send("afrinnovtopic", "hello kafka :) " + i);

            }

        };
    }
*/
    @Bean
    CommandLineRunner commandLineRunner(KafkaTemplate<String, UserDTO> userDTOKafkaTemplate) {
        return args -> {

            for (int i = 0; i < 10; i++) {

                userDTOKafkaTemplate.send("afrinnovtopic", new UserDTO("user" + i, "user" + i + "@afrinnov.xyz"));

            }

        };
    }

}
