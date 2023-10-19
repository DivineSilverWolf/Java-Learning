package nsu.ru.fit.action.param.speed;

import nsu.ru.fit.action.param.ActionParameters;
import nsu.ru.fit.action.param.acceleration.ActionParameterAcceleration;

public class ActionParameterSpeed extends ActionParameters {
    @Override
    public void reaction(ActionParameters actionParametersAcceleration) {
        try{
            ActionParameterAcceleration actionParameterAcceleration = (ActionParameterAcceleration) actionParametersAcceleration;
            this.vectorX += actionParameterAcceleration.getVectorX();
            this.vectorY += actionParameterAcceleration.getVectorY();
            this.vectorZ += actionParameterAcceleration.getVectorZ();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
