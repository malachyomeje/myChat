package chat.myChat.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class ChatRoom {
    @Id
    private  String Id;
    private  String chatId;
    private  String senderId;
    private  String receiverId;

}
