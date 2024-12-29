import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        HelloWorld bean =
                (HelloWorld) applicationContext.getBean("helloworld");
        HelloWorld againBeanOne = (HelloWorld) applicationContext.getBean("helloworld");
        Cat firstCat = (Cat) applicationContext.getBean("cat");
        Cat secondCat = (Cat) applicationContext.getBean("cat");
        System.out.println(bean.getMessage());
        System.out.println(bean.equals(againBeanOne));
        System.out.println(firstCat.equals(secondCat));
    }
}