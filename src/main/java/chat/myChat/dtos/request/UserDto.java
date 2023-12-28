package chat.myChat.dtos.request;

import chat.myChat.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String nickName;
    private String fullName;
    private Status status;
}
