package chat.myChat.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class ChatMessage {
    @Id
    private  String Id;
    private  String chatId;
    private  String senderId;
    private  String recipientId;
    private String content;
    private Date timestamp;

}
