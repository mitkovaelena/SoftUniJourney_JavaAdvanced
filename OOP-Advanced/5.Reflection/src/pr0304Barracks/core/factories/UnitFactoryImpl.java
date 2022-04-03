package pr0304Barracks.core.factories;

import pr0304Barracks.contracts.Unit;
import pr0304Barracks.contracts.UnitFactory;

import java.lang.reflect.Constructor;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"pr0304Barracks.models.units.";

	@Override
	public Unit createUnit(String unitType) {
		try {
			Class<Unit> unitClass = (Class<Unit>) Class.forName(UNITS_PACKAGE_NAME + unitType);
			Constructor constructor = unitClass.getDeclaredConstructor();
			Unit unit = (Unit) constructor.newInstance();
			return unit;
		} catch (ClassNotFoundException cnfe) {
			throw new RuntimeException("Invalid command!");
		} catch (Exception e) {
			throw new RuntimeException("Something went wrong");
		}
	}
}
