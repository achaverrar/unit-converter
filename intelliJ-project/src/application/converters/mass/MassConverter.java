package application.converters.mass;

import application.converters.PartialRangeUnitConverter;
import application.converters.UnitTypeConverter;

public class MassConverter extends UnitTypeConverter {

    private static PartialRangeUnitConverter[] massConverters = new PartialRangeUnitConverter[] {
            new PartialRangeUnitConverter("Gramos", 0.001), new PartialRangeUnitConverter("Kilogramos", 1.0),
            new PartialRangeUnitConverter("Miligramos", 0.000001), new PartialRangeUnitConverter("Toneladas Métricas", 1000),
            new PartialRangeUnitConverter("Onzas", 0.0283495), new PartialRangeUnitConverter("Libras", 0.453592), };

    public MassConverter() {
        super("Kilogramos", massConverters);
    }

    @Override
    public String getUnitType() {
        return "Masa";
    }

    @Override
    public String getIconName() {
        return "mass.png";
    }

}