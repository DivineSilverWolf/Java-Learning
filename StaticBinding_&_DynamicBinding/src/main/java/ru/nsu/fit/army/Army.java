package ru.nsu.fit.army;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import ru.nsu.fit.army.types.ArmySolder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

import static org.icecream.IceCream.ic;
@FieldDefaults(level= AccessLevel.PROTECTED) @Getter @Setter @AllArgsConstructor
public abstract class Army {
    protected Integer countSolder;
    protected ConstructionRank constructionRank;
    protected String nameArmy;

    public static boolean sameClassCheck(Set<?> armySet, Class<?> classArmy){
        try {
            for (Army typeArmy :
                    (Set<Army>)armySet) {
                if (!typeArmy.getClass().getName().equals(classArmy.getName())) {
                    throw new Exception("Вы использовали: " + typeArmy.getClass().getName() +
                            " Здесь должен быть использован " + classArmy.getName() + " Если вам нужны различные войска "
                            + " используйте класс Army");
                }
            }
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    private static Map<Class<?>, Integer> returnTypesArmyAndCoefficient(){
        ClassLoader classLoader = Army.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("factory_classes_types_army.cfg");
        Map<Class<?>, Integer> hashMap = new HashMap<>();
        try {
            assert inputStream != null;
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    Integer coefficient = Integer.parseInt(line.substring(0, line.indexOf(' ')));
                    line = line.substring(line.indexOf(' ') + 1);
                    Class<?> myClass = Class.forName(line);
                    hashMap.put(myClass, coefficient);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return hashMap;
        }
        return hashMap;
    }
    public static <T> void takePosition(Set<T> armySet, T armyN) {
        Army minArmy = null;
        Army maxArmy = null;
        Army army = (Army) armyN;
        Map<Class<?>, Integer> classIntegerMap = returnTypesArmyAndCoefficient();
        int coeffArmy = army.getCountSolder() * (army.getConstructionRank().ordinal() + 1) * classIntegerMap.get(army.getClass());
        for (T armyX : armySet) {
            Army army1 = (Army) armyX;
            if(army1 == army)
                break;
            int coeffArmy1 = army1.getCountSolder() * (army1.getConstructionRank().ordinal() + 1) * classIntegerMap.get(army1.getClass());
            if(coeffArmy1 > coeffArmy){
                int coeffMaxArmy = maxArmy != null ? maxArmy.getCountSolder() * (maxArmy.getConstructionRank().ordinal() + 1) * classIntegerMap.get(maxArmy.getClass()) : -1;
                maxArmy = coeffMaxArmy == -1 || coeffMaxArmy > coeffArmy1? army1 : maxArmy;
            }
            else if(coeffArmy1 < coeffArmy){
                int coeffMinArmy = minArmy != null ? minArmy.getCountSolder() * (minArmy.getConstructionRank().ordinal() + 1) * classIntegerMap.get(minArmy.getClass()) : -1;
                minArmy = coeffMinArmy == -1 || coeffMinArmy < coeffArmy1? army1 : minArmy;
            }
        }
        ic("nameArmy: " + army.getNameArmy() + "countSolder: " + army.getCountSolder() + "; constructionRank: "
                + army.getConstructionRank() + ";");
        ic("class: " + army.getClass().getName() + "; coeff: " + classIntegerMap.get(army.getClass()));
        if(minArmy != null) {
            ic(minArmy);
            ic("До текущей армии находится армия: " + minArmy.getNameArmy());
        }
        if(maxArmy != null) {
            ic(maxArmy);
            ic("После текущей армии находится армия: " + maxArmy.getNameArmy());
        }
        ic("Тип построения: каша");
    }
}
