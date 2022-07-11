package web.dao;



import web.model.User;

import java.util.List;

public interface UserDao {
   void saveUser(User user);

   User getUserById(Long id);

   void deleteUser(long id);

   List<User> getAllUsers();

}
