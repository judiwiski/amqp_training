package lernejo.chat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChatMessageController {
    private ChatMessageRepository repository;

    ChatMessageController(ChatMessageRepository repo){
        repository = repo;
    }

    @GetMapping("/api/message")
    public List<String> getTenMessages() {
        return repository.getLastTenMessages();
    }
}

