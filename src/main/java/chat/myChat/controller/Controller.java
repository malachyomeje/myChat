package chat.myChat.controller;


import chat.myChat.dtos.request.UserDto;
import chat.myChat.dtos.response.UserResponse;
import chat.myChat.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final UserService userService;

    @MessageMapping("/user.addUser")
    @SendTo("/user/topic")
    public UserResponse saveUser(@Payload UserDto userDto){
        return userService.saveUser(userDto);
    }

    @MessageMapping("/user.disconnectUser")
    @SendTo("/user/topic")
    public UserResponse disconnectUser(@Payload String nickName){
        return userService.disconnectUser(nickName);

    }
    @GetMapping("/users")
    public List<UserDto> findAllConnectedUser() {
        return  userService.findAllConnectedUser();
    }
}
