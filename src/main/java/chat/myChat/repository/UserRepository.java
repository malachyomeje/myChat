package chat.myChat.repository;

import chat.myChat.enums.Status;
import chat.myChat.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User,String> {
    Optional<User>findByNickName (String nickName);

    List<User> findAllByStatus(Status onLine);
}

