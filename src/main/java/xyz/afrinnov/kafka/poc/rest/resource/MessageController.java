package xyz.afrinnov.kafka.poc.rest.resource;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.afrinnov.kafka.poc.rest.resource.request.MessageRequest;

@RestController
@RequestMapping("api/v1")
public class MessageController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public MessageController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/message")
    public void publish(@RequestBody MessageRequest request) {
        kafkaTemplate.send("afrinnovtopic", request.message());
    }

}
