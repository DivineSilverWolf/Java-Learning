package nsu.ru.fit.animal.species;

import static org.icecream.IceCream.ic;
import lombok.NonNull;
import nsu.ru.fit.action.animal.Swim;
import nsu.ru.fit.action.param.ActionParameters;
import nsu.ru.fit.action.param.acceleration.ActionParameterAcceleration;
import nsu.ru.fit.action.param.speed.ActionParameterSpeed;
import nsu.ru.fit.animal.Animal;

import java.util.Random;
import java.util.Set;

public class Fish extends Animal implements Swim {
    public Fish(@NonNull String name, @NonNull int age, @NonNull int mood, Set<String> favoriteFood, Set<String> hatedFood, @NonNull ActionParameterSpeed actionParameterSpeed, @NonNull ActionParameterAcceleration actionParameterAcceleration) {
        super(name, age, mood, favoriteFood, hatedFood, actionParameterSpeed, actionParameterAcceleration);
    }

    public Fish(@NonNull String name, @NonNull int age, @NonNull int mood, @NonNull ActionParameterSpeed actionParameterSpeed, @NonNull ActionParameterAcceleration actionParameterAcceleration) {
        super(name, age, mood, actionParameterSpeed, actionParameterAcceleration);
    }

    public Fish(@NonNull String name, @NonNull int age) {
        super(name, age);
    }

    public Fish(@NonNull String name, @NonNull int age, @NonNull int mood) {
        super(name, age, mood);
    }

    @Override
    public void makeSound() {
        mood += random.nextInt()%10;
        ic("...");
    }

    @Override
    public void eat(String food) {
        Random random = new Random();
        mood += random.nextInt()%10;
    }

    @Override
    public void sleep() {
        mood += random.nextInt()%11;
    }
    @Override
    public void makeSound(Animal animal) {
        if(animal.getClass().getName().equals(Fish.class.getName())){
            animal.setMood(animal.getMood() + 10);
        }
        else
            mood--;
    }

    @Override
    public void eat(String food, boolean preparation) {
        eat(food);
        if (preparation) setMood(getMood() + 5);
        else setMood(getMood() - 3);
    }

    private void printVectors(ActionParameters actionParameters){
        System.out.println(actionParameters.getClass().getName() + ": vector x: " + actionParameters.getVectorX() + "; vector y: " +
                actionParameters.getVectorY() + "; vector z: " + actionParameters.getVectorZ());
    }
    @Override
    public void swim() {
        printVectors(actionParameterSpeed);
        printVectors(actionParameterAcceleration);
        actionParameterSpeed.reaction(actionParameterAcceleration);
        printVectors(actionParameterSpeed);
        printVectors(actionParameterAcceleration);
    }
}
