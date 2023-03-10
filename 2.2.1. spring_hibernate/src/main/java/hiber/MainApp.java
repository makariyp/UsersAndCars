package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      List<User> list = new ArrayList<>();

      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
      User user4 = new User("User4", "Lastname4", "user4@mail.ru");

      user1.setCar(new Car("BMV", 13));
      user2.setCar(new Car("Mers", 77));
      user3.setCar(new Car("Audi", 1));
      user4.setCar(new Car("Zhiguli", 86));

      list.addAll(List.of(new User[]{user1, user2, user3, user4}));
      list.forEach(userService::add);

      List<User> users = userService.listUserByCar("BMV", 13);
      for (User user : users) {
         System.out.println(user);
      }

      context.close();
   }
}
