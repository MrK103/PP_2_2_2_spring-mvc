package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.*;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @PersistenceContext
   private EntityManager entityManager;

   @Override
   public void saveUser(User user) {
      entityManager.merge(user);
      entityManager.flush();
   }

   @Override
   public User getUserById(Long id) {
      return entityManager.find(User.class, id);
   }


   @Override
   public void deleteUser(long id) throws NullPointerException {
      User user = getUserById(id);
      if (user == null) {
         throw new NullPointerException("User not found");
      }
      entityManager.remove(user);
      entityManager.flush();
   }
   @Override
   @SuppressWarnings("unchecked")
   public List<User> getAllUsers() {
      return entityManager.createQuery("from User", User.class).getResultList();
   }
}
