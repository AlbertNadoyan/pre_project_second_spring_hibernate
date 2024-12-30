package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        CarService carService = context.getBean(CarService.class);

        userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

        Car car1 = new Car("BMW", 7);
        Car car2 = new Car("AUDI", 5);
        Car car3 = new Car("PORSCHE", 919);
        Car car4 = new Car("ROLLS-ROYCE", 8);

        carService.addCarWithUser(car1);
        carService.addCarWithUser(car2);
        carService.addCarWithUser(car3);
        carService.addCarWithUser(car4);

        userService.add(new User("NewUser1", "NewLastName1", "new1@gmail.com", car1));
        userService.add(new User("NewUser2", "NewLastName2", "new2@gmail.com", car2));
        userService.add(new User("NewUser3", "NewLastName3", "new3@gmail.com", car3));
        userService.add(new User("NewUser4", "NewLastName4", "new4@gmail.com", car4));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = "+user.getId());
            System.out.println("First Name = "+user.getFirstName());
            System.out.println("Last Name = "+user.getLastName());
            System.out.println("Email = "+user.getEmail());
            if(user.getCar() != null){
                System.out.println("Car = " + user.getCar().getModel() + " " + user.getCar().getSeries());
            }else {
                System.out.println("Car = None");
            }
            System.out.println();
        }

        String getModel = "AUDI";
        int getSeries = 5;
        User userByCarModelAndSeries = userService.getUserByCarModelAndSeries(getModel, getSeries);
        if(userByCarModelAndSeries != null){
            System.out.println("Id = " + userByCarModelAndSeries.getId());
            System.out.println("First Name = " + userByCarModelAndSeries.getFirstName());
            System.out.println("Last Name = " + userByCarModelAndSeries.getLastName());
            System.out.println("Email = " + userByCarModelAndSeries.getEmail());
        }else {
            System.out.println("There isn't/aren't user with this model and series");
        }

        context.close();
    }
}
