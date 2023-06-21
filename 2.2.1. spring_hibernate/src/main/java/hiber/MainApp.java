package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car("Toyota", Math.abs(new Random().nextInt()));
      Car car2 = new Car("BMW", Math.abs(new Random().nextInt()));

      User user1 = new User("User1", "Lastname1", String.format("user%smail.ru",Math.abs(new Random().nextInt())), car1);
      User user2 = new User("User2", "Lastname2", String.format("user%smail.ru",Math.abs(new Random().nextInt())), car2);

      userService.add(user1);
      userService.add(user2);


      List<User> users = userService.listUsers();
      for (User user : users) {
       System.out.println(user.toString());
      }

     User user =  userService.getUserFromModelAndSerial("Toyota",544604492);
       System.out.println(user.toString());

      context.close();
   }
}
