package nsu.ru.fit.action.param;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter @Setter @AllArgsConstructor @FieldDefaults(level= AccessLevel.PROTECTED)
public abstract class ActionParameters {
    double vectorX;
    double vectorY;
    double vectorZ;

    public abstract void reaction(ActionParameters actionParameters);


    public ActionParameters() {
        vectorX = 0;
        vectorY = 0;
        vectorZ = 0;
    }
}
