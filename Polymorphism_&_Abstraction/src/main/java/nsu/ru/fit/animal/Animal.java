package nsu.ru.fit.animal;

import lombok.*;
import lombok.experimental.FieldDefaults;
import nsu.ru.fit.action.param.acceleration.ActionParameterAcceleration;
import nsu.ru.fit.action.param.speed.ActionParameterSpeed;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Getter @Setter @RequiredArgsConstructor @AllArgsConstructor @FieldDefaults(level= AccessLevel.PROTECTED)
public abstract class Animal {

    @NonNull String name;
    @NonNull int age;
    @NonNull int mood;
    Set<String> favoriteFood = new HashSet<>();
    Set<String> hatedFood = new HashSet<>();
    final Random random = new Random();
    @NonNull ActionParameterSpeed actionParameterSpeed;
    @NonNull ActionParameterAcceleration actionParameterAcceleration;

    public Animal(@NonNull String name, @NonNull int age) {
        this.name = name;
        this.age = age;
        mood = 0;
        actionParameterSpeed = new ActionParameterSpeed();
        actionParameterAcceleration = new ActionParameterAcceleration();
    }
    public Animal(@NonNull String name, @NonNull int age, @NonNull int mood) {
        this.name = name;
        this.age = age;
        this.mood = mood;
        actionParameterSpeed = new ActionParameterSpeed();
        actionParameterAcceleration = new ActionParameterAcceleration();
    }

    public abstract void makeSound();
    public abstract void eat(String food);
    public abstract void sleep();
    public abstract void makeSound(Animal animal);
    public abstract void eat(String food, boolean preparation);
}
