package ru.nsu.fit.forming.detachment;

import ru.nsu.fit.army.Army;
import ru.nsu.fit.army.ConstructionRank;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

public class TypeArmyBarracks {
    private static ConstructionRank getRank(int countArmy){
        return switch (countArmy%3) {
            case 0 -> ConstructionRank.ONE;
            case 1 -> ConstructionRank.TWO;
            default -> ConstructionRank.THREE;
        };
    }
    public static final <T> void oneType(ContextArmy contextArmy, Set<T> armySet) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        for (int i = 0; i < contextArmy.getCountArmy(); i++) {
            ConstructionRank constructionRank = getRank(i);
            armySet.add((T) contextArmy.getArmyClass().cast(contextArmy.getArmyClass().getConstructor(Integer.class, ConstructionRank.class, String.class).newInstance(contextArmy.getCountArmyUnits(), constructionRank, "name: " + i)));
        }
    }
    public static void moreType(Set<ContextArmy> contextsArmy, Set<Army> armySet) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        for (ContextArmy contextArmy: contextsArmy) {
            for (int i = 0; i < contextArmy.getCountArmy(); i++) {
                ConstructionRank constructionRank = getRank(i);
                Army army = (Army) contextArmy.getArmyClass().getConstructor(Integer.class, ConstructionRank.class, String.class).newInstance(contextArmy.getCountArmyUnits(), constructionRank, "name: " + i);
                armySet.add(army);
            }
        }
    }
}
