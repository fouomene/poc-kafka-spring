package xyz.afrinnov.kafka.poc.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(
            topics = "afrinnovtopic",
            groupId = "afrinnov1"
    )
    void listener(String data) {
        System.out.println(" Listener Received Message : " + data);
    }
}
