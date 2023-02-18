package application.converters;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	protected UnitTypeConverter(String standardBaseUnit, Map<String, BaseUnitConverter> baseUnitConverters) {
		this.standardBaseUnit = standardBaseUnit;
		this.baseUnitConverters = baseUnitConverters;
	}

	public BigDecimal convert(BigDecimal value, BaseUnitConverter from, BaseUnitConverter to) {

		if (to.getName().equals(from.getName())) {
			return value.setScale(4, RoundingMode.HALF_UP);
		} else {
			BigDecimal base = baseUnitConverters.get(from.getName()).convertToBase(value);
			if (to.getName().equals(standardBaseUnit)) {
				return base.setScale(4, RoundingMode.HALF_UP);
			} else {
				BigDecimal fromBase = baseUnitConverters.get(to.getName()).convertFromBase(base);
				return fromBase.setScale(4, RoundingMode.HALF_UP);
			}
		}
	}
}
