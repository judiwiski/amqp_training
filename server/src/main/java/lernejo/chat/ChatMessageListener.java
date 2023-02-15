package lernejo.chat;

import org.springframework.stereotype.Component;

@Component
public class ChatMessageListener{

    private final ChatMessageRepository repositoryMessage;

    ChatMessageListener(ChatMessageRepository repo){
        repositoryMessage = repo;
    }

    public void onMessage (String message){
        repositoryMessage.addChatMessage(message);
    }
}
