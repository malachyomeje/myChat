package chat.myChat.service;

import chat.myChat.dtos.request.UserDto;
import chat.myChat.dtos.response.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse saveUser (UserDto userDto);

    UserResponse disconnectUser(String nickName);

    List<UserDto> findAllConnectedUser();
}
