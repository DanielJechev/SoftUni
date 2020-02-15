package pr0304Barracks.core.commands;

import jdk.jshell.spi.ExecutionControl;
import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.UnitFactory;

import java.lang.reflect.InvocationTargetException;
import java.security.InvalidParameterException;

public class RetireCommand extends Command {
    protected RetireCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() throws ClassNotFoundException, InvocationTargetException, InstantiationException, ExecutionControl.NotImplementedException, IllegalAccessException {

        String unitType = super.getData()[1];
        try{
             super.getRepository().removeUnit(unitType);
         }
         catch (InvalidParameterException ex){
             return ex.getMessage();
         }
         return unitType+ " retired!";
    }
}
