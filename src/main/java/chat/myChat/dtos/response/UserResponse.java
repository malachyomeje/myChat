package chat.myChat.dtos.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse<T> {

    private String message;
    private T data;

    public UserResponse(String message) {
        this.message = message;
    }
}
