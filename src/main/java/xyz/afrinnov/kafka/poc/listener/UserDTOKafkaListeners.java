package xyz.afrinnov.kafka.poc.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import xyz.afrinnov.kafka.poc.dto.UserDTO;

@Component
public class UserDTOKafkaListeners {

    @KafkaListener(
            topics = "afrinnovtopic",
            groupId = "afrinnov2",
            containerFactory = "userDTOFactory"
    )
    void listener(UserDTO data) {
        System.out.println(" Listener Received User : " + data.toString());
    }
}
