package chat.myChat.repository;

import chat.myChat.model.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ChatMessageRepository extends MongoRepository<ChatMessage,String> {

}



