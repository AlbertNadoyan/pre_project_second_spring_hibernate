package app.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AnimalsCage {
    private Animal animal;
    private Animal secondAnimal;
    private Timer timer;

    @Autowired
    public AnimalsCage(@Qualifier("cat") Animal animal,
                       @Qualifier("dog") Animal secondAnimal,
                       Timer timer) {
        this.animal = animal;
        this.secondAnimal = secondAnimal;
        this.timer = timer;
    }

    public void whatAnimalSay() {
        System.out.println("Say:");
        System.out.println(animal.toString() + ", " + secondAnimal.toString());
        System.out.println("At:");
        System.out.println(new Timer().getTime());
        System.out.println("________________________");
    }

    public Timer getTimer() {
        return timer;
    }
}
