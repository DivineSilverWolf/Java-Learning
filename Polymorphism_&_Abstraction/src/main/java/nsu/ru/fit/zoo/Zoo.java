package nsu.ru.fit.zoo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import nsu.ru.fit.animal.Animal;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Setter
public class Zoo {
    private Set<Animal> animalSet = new HashSet<>();

    public Set<Animal> getAnimalSet() {
        return new HashSet<>(animalSet);
    }
    public Zoo(){}
    public Zoo(Set<Animal> animalSet){
        this.animalSet = animalSet;
    }

    public boolean addAnimals(Animal... animals) {
        return animalSet.addAll(Arrays.asList(animals));
    }

    public boolean addAnimals(Set<Animal> animalSet) {
        return this.animalSet.addAll(animalSet);
    }
    public boolean removeAnimal(Animal animal){
        return animalSet.remove(animal);
    }

    public void makeAllAnimalsSound(){
        animalSet.forEach(Animal :: makeSound);
        animalSet.forEach(animal -> animal.eat("Апельсин"));
    }
    public void makeAllAnimalEat(Class<?> animalClass, String food, boolean preparation){
        animalSet.stream()
                .filter(animal -> animal.getClass().equals(animalClass))
                .forEach(animal -> animal.eat(food, preparation));
    }
    public void makeAllAnimalEat(Class<?> animalClass, String food){
        animalSet.stream()
                .filter(animal -> animal.getClass().equals(animalClass))
                .forEach(animal -> animal.eat(food));
    }
}
