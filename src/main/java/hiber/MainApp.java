package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("first", "first2","asd");
      user1.setCar(new Car(1,"bmw"));
      User user2 = new User("second", "second2","asd");
      user2.setCar(new Car(2,"bmw"));
      User user3 = new User("three", "three2","asd");
      user3.setCar(new Car(3,"bmw"));
      User user4 = new User("four", "four2","asd");
      user4.setCar(new Car(4,"bmw"));
      User user5 = new User("five", "five2","asd");
      User user6 = new User("six", "six2","asd");
      User user7 = new User("seven", "seven2","asd");


      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);
      userService.add(user5);
      userService.add(user6);
      userService.add(user7);

      List<User> users = userService.getUsersWithCar("bmw",2);
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         if(user.getCar().isPresent()){
            System.out.println(user.getCar().get().getSeries());
            System.out.println(user.getCar().get().getModel());
         }
      }
      context.close();
   }
}
