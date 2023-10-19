package nsu.ru.fit;

import nsu.ru.fit.animal.species.Fish;
import nsu.ru.fit.animal.species.Lion;
import nsu.ru.fit.animal.species.Tiger;
import nsu.ru.fit.zoo.Zoo;
import org.icecream.IceCream;

import static org.icecream.IceCream.ic;


public class Main {
    public static void main(String[] args) {
//        https://github.com/Akshay-Thakare/icecream-java
        Zoo zoo = new Zoo();
        Fish fish = new Fish("Petr", 1);
        Lion lion = new Lion("Leo", 2);
        Tiger tiger = new Tiger("Ti", 0);
        ic(zoo.addAnimals(fish, lion, tiger));
        zoo.makeAllAnimalEat(Fish.class, "apple", true);
        zoo.makeAllAnimalEat(Lion.class, "meet");
        zoo.makeAllAnimalsSound();
    }
}
