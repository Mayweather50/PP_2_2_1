package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);


      userService.addUser(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.addUser(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.addUser(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.addUser(new User("User4", "Lastname4", "user4@mail.ru"));


      carService.addCar(new Car("Mercedes", 2023));
      carService.addCar(new Car("Lambo", 666));
      carService.addCar(new Car("Bugatti", 999));
      carService.addCar(new Car("Ferrari", 690));


      System.out.println("\nResult: " + userService.getUserByCar("Mercedes", 2023).getCar() + "\n");
      System.out.println();
      System.out.println("\nResultCar: " + carService.getCarByUser
              ("User1", "Lastname1", "user1@mail.ru").getUser() + "\n");


      context.close();
   }
}
