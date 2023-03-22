package application.converters;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utilities.InvalidInputException;

public abstract class UnitTypeConverter {
	private String standardBaseUnit;
	private Map<String, BaseUnitConverter> baseUnitConverters = new HashMap<>();

	public Map<String, BaseUnitConverter> getBaseUnitConvertersMap() {
		return baseUnitConverters;
	}

	public List<BaseUnitConverter> getBaseUnitConvertersList() {
		return new ArrayList<BaseUnitConverter>(baseUnitConverters.values());
	}

	public abstract String getUnitType();

	protected UnitTypeConverter(String standardBaseUnit, BaseUnitConverter[] converters) {
		this.standardBaseUnit = standardBaseUnit;
		this.baseUnitConverters = createHashMap(converters);
	}

	public BigDecimal convert(String value, BaseUnitConverter from, BaseUnitConverter to) throws InvalidInputException {
		/*
		 * If we're converting to the same unit type, just return our value as is if
		 * (to.getName().equals(from.getName())) { return value.setScale(4,
		 * RoundingMode.HALF_UP); }
		 */
		// If we're converting from our base unit, then we only need one conversion
		if (from.getName().equals(standardBaseUnit)) {
			BigDecimal fromBase = baseUnitConverters.get(to.getName()).convertFromBase(value);
			return fromBase.setScale(4, RoundingMode.HALF_UP);
		}
		// If we're not converting from our base unit...
		else {
			// Then first convert to our base unit
			BigDecimal base = baseUnitConverters.get(from.getName()).convertToBase(value);

			// If we're converting to our base unit, then we can just return this value
			if (to.getName().equals(standardBaseUnit)) {
				return base.setScale(4, RoundingMode.HALF_UP);
			}
			// Else, now we need to convert from our base unit to the unit we're converting
			// to
			else {
				BigDecimal fromBase = baseUnitConverters.get(to.getName()).convertFromBase(base);
				return fromBase.setScale(4, RoundingMode.HALF_UP);
			}
		}
	}

	public static HashMap<String, BaseUnitConverter> createHashMap(BaseUnitConverter[] converters) {
		HashMap<String, BaseUnitConverter> newHashMap = new HashMap<>();

		for (BaseUnitConverter converter : converters) {
			newHashMap.put(converter.getName(), converter);
		}

		return newHashMap;
	}
	
	public abstract String getIconName();
}
