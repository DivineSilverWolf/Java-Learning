package ru.nsu.fit;

import ru.nsu.fit.army.Army;
import ru.nsu.fit.army.types.ArmyHelicopters;
import ru.nsu.fit.army.types.ArmySolder;
import ru.nsu.fit.army.types.ArmyTanks;
import ru.nsu.fit.forming.detachment.ContextArmy;
import ru.nsu.fit.forming.detachment.TypeArmyBarracks;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ContextArmy contextSolder = new ContextArmy(ArmySolder.class, 100, 10);
        ContextArmy contextHelicopter = new ContextArmy(ArmyHelicopters.class, 100, 10);
        ContextArmy contextTanks = new ContextArmy(ArmyTanks.class, 100, 10);
        Set<Army> armySet = new HashSet<>();
        Set<ContextArmy> contextArmies = new HashSet<>();
        contextArmies.add(contextSolder);
        contextArmies.add(contextHelicopter);
        contextArmies.add(contextTanks);
        TypeArmyBarracks.moreType(contextArmies, armySet);

        for (Army army: armySet) {
            army.takePosition(armySet, army);
        }

        System.out.println("\n***********************************************************************\n");

        Set<ArmySolder> armySoldersSet = new HashSet<>();
        TypeArmyBarracks.oneType(contextSolder, armySoldersSet);
        for (ArmySolder army: armySoldersSet) {
            army.takePosition(armySoldersSet, army);
        }
    }
}
