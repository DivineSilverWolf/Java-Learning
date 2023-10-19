package nsu.ru.fit.action.param.acceleration;

import nsu.ru.fit.action.param.ActionParameters;
import nsu.ru.fit.action.param.speed.ActionParameterSpeed;

public class ActionParameterAcceleration extends ActionParameters {
    @Override
    public void reaction(ActionParameters actionParametersSpeed) {
        try {
            ActionParameterSpeed actionParameterSpeed = (ActionParameterSpeed) actionParametersSpeed;
            actionParameterSpeed.setVectorX(actionParametersSpeed.getVectorX() + vectorX);
            actionParameterSpeed.setVectorY(actionParametersSpeed.getVectorY() + vectorY);
            actionParameterSpeed.setVectorZ(actionParametersSpeed.getVectorZ() + vectorZ);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
