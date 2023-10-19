package nsu.ru.fit.animal.species;

import lombok.NonNull;
import nsu.ru.fit.action.param.acceleration.ActionParameterAcceleration;
import nsu.ru.fit.action.param.speed.ActionParameterSpeed;
import nsu.ru.fit.animal.Animal;
import static org.icecream.IceCream.ic;
import java.util.HashSet;
import java.util.Set;

public class Lion extends Animal {

    public Lion(@NonNull String name, @NonNull int age, @NonNull int mood, @NonNull ActionParameterSpeed actionParameterSpeed, @NonNull ActionParameterAcceleration actionParameterAcceleration) {
        super(name, age, mood, actionParameterSpeed, actionParameterAcceleration);
        hatedFood = new HashSet<>();
        favoriteFood = new HashSet<>();
        hatedFood.add("Яблоко");
        favoriteFood.add("Тюлень");
    }

    public Lion(@NonNull String name, @NonNull int age) {
        super(name, age);
        hatedFood.add("Яблоко");
        favoriteFood.add("Тюлень");
    }

    public Lion(@NonNull String name, @NonNull int age, @NonNull int mood) {
        super(name, age, mood);
        hatedFood.add("Яблоко");
        favoriteFood.add("Тюлень");
    }

    public Lion(@NonNull String name, @NonNull int age, @NonNull int mood, Set<String> favoriteFood, Set<String> hatedFood, @NonNull ActionParameterSpeed actionParameterSpeed, @NonNull ActionParameterAcceleration actionParameterAcceleration) {
        super(name, age, mood, favoriteFood, hatedFood, actionParameterSpeed, actionParameterAcceleration);
        hatedFood.add("Яблоко");
        favoriteFood.add("Тюлень");
    }

    @Override
    public void makeSound() {
        if(mood > 100)
            ic("РРРРРООООО!");
        else
            ic("РРРРРЁЁЁ...");
    }

    @Override
    public void eat(String food) {
        if(favoriteFood.contains(food))
            mood+=5;
        else if(hatedFood.contains(food))
            mood-=5;
        else
            mood+=random.nextInt()%2;

    }

    @Override
    public void sleep() {
        mood+=random.nextInt()%10;
    }

    @Override
    public void makeSound(Animal animal) {
        if(mood > 100)
            animal.setMood(animal.getMood() + 5);
        else
            animal.setMood(animal.getMood() - 5);
    }

    @Override
    public void eat(String food, boolean preparation) {
        eat(food);
        if(preparation)
            mood+=15;
        else
            mood-=5;
    }
}
