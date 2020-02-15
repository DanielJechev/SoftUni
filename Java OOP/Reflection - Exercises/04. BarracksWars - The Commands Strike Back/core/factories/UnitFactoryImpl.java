package pr0304Barracks.core.factories;

import jdk.jshell.spi.ExecutionControl;
import pr0304Barracks.contracts.Unit;
import pr0304Barracks.contracts.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"pr0304Barracks.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
		Class cl = Class.forName(UNITS_PACKAGE_NAME + unitType);

		Constructor<?> constructor = cl.getConstructors()[0];
		constructor.setAccessible(true);
		Unit unit  = (Unit)constructor.newInstance();

		return unit;

	}
}
