package ru.nsu.fit.forming.detachment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter @AllArgsConstructor
public class ContextArmy {
    private Class<?> armyClass;
    private int countArmyUnits;
    private int countArmy;

}
