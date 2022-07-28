package xyz.afrinnov.kafka.poc.rest.resource;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.afrinnov.kafka.poc.dto.UserDTO;

@RestController
@RequestMapping("api/v1")
public class UserController {


    private final KafkaTemplate<String, UserDTO> userDTOKafkaTemplate;

    public UserController(KafkaTemplate<String, UserDTO> userDTOKafkaTemplate) {
        this.userDTOKafkaTemplate = userDTOKafkaTemplate;
    }

    @PostMapping("/createuser")
    public void publishUserDTO(@RequestBody UserDTO userDTO) {
        userDTOKafkaTemplate.send("afrinnovtopic", userDTO);
    }
}
