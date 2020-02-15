package barracksWars.core.factories;

import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import barracksWars.models.units.*;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException {
		Unit unit = null;

		switch (unitType){
			case "Swordsman":
				unit=new Swordsman();
				break;
			case "Archer":
				unit=new Archer();
				break;case "Pikeman":
				unit=new Pikeman();
				break;case "Horseman":
				unit=new Horseman();
				break;case "Gunner":
				unit=new Gunner();
				break;
		}

		return unit;
	}
}
