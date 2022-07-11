package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().merge(user);
   }

   @Override
   public User getUserById(Long id){
      TypedQuery<User> query = sessionFactory.getCurrentSession()
              .createQuery("from User WHERE id = :id")
              .setParameter("id", id);
      return query.getSingleResult();}

   @Override
   public void delete(long id){
      sessionFactory.getCurrentSession()
              .createQuery("DELETE from User WHERE id = :id")
              .setParameter("id", id)
              .executeUpdate();
   }
   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }
}
