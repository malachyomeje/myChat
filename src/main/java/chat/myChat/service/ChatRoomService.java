package chat.myChat.service;

import java.util.Optional;

public interface ChatRoomService {
    Optional<String> getChatRoomId(String senderId, String recipientId, Boolean createNewRoomIfNotExist);
}
