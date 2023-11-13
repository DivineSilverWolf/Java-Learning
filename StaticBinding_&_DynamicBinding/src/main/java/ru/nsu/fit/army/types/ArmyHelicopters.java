package ru.nsu.fit.army.types;

import ru.nsu.fit.army.Army;
import ru.nsu.fit.army.ConstructionRank;

import java.util.Set;

import static ru.nsu.fit.army.ArmyTools.returnInConsole;

public class ArmyHelicopters extends Army {

    public ArmyHelicopters(Integer countSolder, ConstructionRank constructionRank, String nameArmy) {
        super(countSolder, constructionRank, nameArmy);
    }
     public static <T> void takePosition(Set<T> armySet, T armyT) {
        ArmyHelicopters army = (ArmyHelicopters) armyT;
        if(!sameClassCheck(armySet, army.getClass()))
            return;
        Army minArmy = null;
        Army maxArmy = null;
        int coeffArmy = army.getCountSolder() * (army.getConstructionRank().ordinal() + 1);
        for (T armyX : armySet) {
            ArmyHelicopters army1 = (ArmyHelicopters) armyX;
            if(army1 == army)
                break;
            int coeffArmy1 = army1.getCountSolder() * (army1.getConstructionRank().ordinal() + 1);
            if(coeffArmy1 > coeffArmy){
                int coeffMaxArmy = maxArmy != null ? maxArmy.getCountSolder() * (maxArmy.getConstructionRank().ordinal() + 1) : -1;
                maxArmy = coeffMaxArmy == -1 || coeffMaxArmy > coeffArmy1? army1 : maxArmy;
            }
            else if(coeffArmy1 < coeffArmy){
                int coeffMinArmy = minArmy != null ? (minArmy.getCountSolder() * minArmy.getConstructionRank().ordinal() + 1): -1;
                minArmy = coeffMinArmy == -1 || coeffMinArmy < coeffArmy1? army1 : minArmy;
            }
        }
        returnInConsole(army, minArmy, maxArmy);
    }
}
