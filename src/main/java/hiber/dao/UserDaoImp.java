package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().saveOrUpdate(user);
   }

   @Override
   public List<User> listUsers() {
      return sessionFactory.getCurrentSession().createQuery("from User",User.class).getResultList();
   }

   @Override
   public List<User> getUsersWithCar(String model, int series){
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("select p from User p where p.car.series = :series and p.car.model = :model",User.class);
      query.setParameter("series",series);
      query.setParameter("model",model);
      return query.getResultList();
   }

}
