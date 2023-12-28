package chat.myChat.service;


import chat.myChat.dtos.request.UserDto;
import chat.myChat.dtos.response.UserResponse;
import chat.myChat.enums.Status;
import chat.myChat.model.User;
import chat.myChat.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService{

    private final UserRepository userRepository;

    @Override
    public UserResponse saveUser(UserDto userDto){
        Optional<User> user = userRepository.findByNickName(userDto.getNickName());
        if (user.isPresent()){
            return new UserResponse<>("NickName has been taken",userDto.getNickName());
        }
        User user1 = new User();
        user1.setNickName(userDto.getNickName());
        user1.setFullName(userDto.getFullName());
        user1.setStatus(Status.ONLINE);
        userRepository.save(user1);
        return new UserResponse<>("User Saved Successfully",userDto.getFullName());
    }


    @Override
    public UserResponse disconnectUser(String nickName){
        Optional<User> user = userRepository.findByNickName(nickName);
        if (user.isEmpty()){
            return new UserResponse<>("User Not Found " ,nickName);
        }
       User user1 = user.get();
        user1.setStatus(Status.OFFLINE);
        userRepository.save(user1);
        return new UserResponse<>(user1.getNickName(), " Is Offline" );
    }

    @Override

    public List<UserDto> findAllConnectedUser() {
        List<User> userList = userRepository.findAllByStatus(Status.ONLINE);
        List<UserDto> userDto = new ArrayList<>();
        for (User list : userList) {

            UserDto user = new UserDto();
            user.setStatus(Status.ONLINE);
            user.setNickName(list.getNickName());

            userDto.add(user);
        }
        return userDto;
    }

}
