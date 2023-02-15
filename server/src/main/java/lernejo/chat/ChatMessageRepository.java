package lernejo.chat;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ChatMessageRepository {

    private List<String> messageRepository = new ArrayList<>();
    private int i = 0;

    public void addChatMessage(String message){
        if(messageRepository.size() > 9){
            messageRepository.set(i,message);
            i++;
        }else {
            messageRepository.add(message);
            i++;
        }
        if(i == 10){
            i = 0;
        }
    }

    public List<String> getLastTenMessages(){
        return messageRepository;
    }
}
