package ru.nsu.fit.army;

import static org.icecream.IceCream.ic;

public class ArmyTools {
    public final static void returnInConsole(Army army, Army minArmy, Army maxArmy) {
        ic("nameArmy: " + army.getNameArmy() + "countSolder: " + army.getCountSolder() + "; constructionRank: "
                + army.getConstructionRank() + ";");
        ic("class: " + army.getClass().getName() + "; coeff: ");
        if(minArmy != null) {
            ic(minArmy);
            ic("До текущей армии находится армия: " + minArmy.getNameArmy());
        }
        if(maxArmy != null) {
            ic(maxArmy);
            ic("После текущей армии находится армия: " + maxArmy.getNameArmy());
        }
        ic("Тип построения: линия");
    }
}
