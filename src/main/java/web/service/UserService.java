package web.service;

import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;

public interface UserService {
    @Transactional
    User getUserById(Long id);

    @Transactional
    void deleteUser(Long id);

    void saveUser(User user);

    List<User> getAllUsers();

}
