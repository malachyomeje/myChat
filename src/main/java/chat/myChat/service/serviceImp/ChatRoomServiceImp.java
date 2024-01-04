package chat.myChat.service.serviceImp;


import chat.myChat.model.ChatRoom;
import chat.myChat.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatRoomServiceImp {
    private final ChatRoomRepository chatRoomRepository;

    public Optional<String> getChatRoomId(String senderId, String recipientId,Boolean createNewRoomIfNotExist){


        return chatRoomRepository.findBySenderIdAndRecipientId(senderId ,recipientId)
                .map(ChatRoom::getChatId)
                .or(()-> {
            if (createNewRoomIfNotExist) {
                var chatId = createChatId(senderId,recipientId);
                return Optional.of(chatId);
            }
                    return Optional.empty();
                });
    }

    private String createChatId(String senderId, String recipientId) {

        var chatId = String.format("%s_%s", senderId, recipientId);

        ChatRoom senderRecipient = ChatRoom
                .builder()
                .chatId(chatId)
                .senderId(senderId)
                .recipientId(recipientId)
                .build();

        ChatRoom recipientSender = ChatRoom
                .builder()
                .chatId(chatId)
                .senderId(recipientId)
                .recipientId(senderId)
                .build();

        chatRoomRepository.save(senderRecipient);
        chatRoomRepository.save(recipientSender);

        return chatId;
    }
}



