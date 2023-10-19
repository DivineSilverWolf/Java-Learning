package nsu.ru.fit.animal.species;

import lombok.NonNull;
import nsu.ru.fit.action.param.acceleration.ActionParameterAcceleration;
import nsu.ru.fit.action.param.speed.ActionParameterSpeed;
import nsu.ru.fit.animal.Animal;
import static org.icecream.IceCream.ic;
import java.util.Set;

public class Tiger extends Animal {


    public Tiger(@NonNull String name, @NonNull int age, @NonNull int mood, @NonNull ActionParameterSpeed actionParameterSpeed, @NonNull ActionParameterAcceleration actionParameterAcceleration) {
        super(name, age, mood, actionParameterSpeed, actionParameterAcceleration);
        hatedFood.add("Апельсин");
        favoriteFood.add("Лев");
    }

    public Tiger(@NonNull String name, @NonNull int age) {
        super(name, age);
        hatedFood.add("Апельсин");
        favoriteFood.add("Лев");
    }

    public Tiger(@NonNull String name, @NonNull int age, @NonNull int mood) {
        super(name, age, mood);
        hatedFood.add("Апельсин");
        favoriteFood.add("Лев");
    }

    public Tiger(@NonNull String name, @NonNull int age, @NonNull int mood, Set<String> favoriteFood, Set<String> hatedFood, @NonNull ActionParameterSpeed actionParameterSpeed, @NonNull ActionParameterAcceleration actionParameterAcceleration) {
        super(name, age, mood, favoriteFood, hatedFood, actionParameterSpeed, actionParameterAcceleration);
        hatedFood.add("Апельсин");
        favoriteFood.add("Лев");
    }

    @Override
    public void makeSound() {
        if(mood > 50)
            ic("РРРРР!");
        else
            ic("РРРРР...");
    }

    @Override
    public void eat(String food) {
        if(favoriteFood.contains(food))
            mood+=3;
        else if(hatedFood.contains(food))
            mood-=2;
        else
            mood+=random.nextInt()%2;
    }

    @Override
    public void sleep() {
        mood+=random.nextInt()%8;
    }

    @Override
    public void makeSound(Animal animal) {
        if(mood > 40)
            animal.setMood(animal.getMood() + 2);
        else
            animal.setMood(animal.getMood() - 2);
    }

    @Override
    public void eat(String food, boolean preparation) {
        eat(food);
        if(preparation)
            mood+=7;
        else
            mood-=2;
    }
}
