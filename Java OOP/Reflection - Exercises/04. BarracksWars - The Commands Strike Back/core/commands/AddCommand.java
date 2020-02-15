package pr0304Barracks.core.commands;

import jdk.jshell.spi.ExecutionControl;
import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.Unit;
import pr0304Barracks.contracts.UnitFactory;

import java.lang.reflect.InvocationTargetException;

public class AddCommand extends Command {
    protected AddCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() throws ClassNotFoundException, InvocationTargetException, InstantiationException, ExecutionControl.NotImplementedException, IllegalAccessException {
        String unitType = super.getData()[1];
        Unit unitToAdd = super.getUnitFactory().createUnit(unitType);
        super.getRepository().addUnit(unitToAdd);
        return unitType + " added!";
    }
}
