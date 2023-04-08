package application.converters.time;

import application.converters.PartialRangeUnitConverter;
import application.converters.UnitTypeConverter;

public class TimeConverter extends UnitTypeConverter {

    private static PartialRangeUnitConverter[] timeConverters = new PartialRangeUnitConverter[] {
            new PartialRangeUnitConverter("Días", 86400), new PartialRangeUnitConverter("Horas", 3600),
            new PartialRangeUnitConverter("Milisegundos", 0.001), new PartialRangeUnitConverter("Minutos", 60),
            new PartialRangeUnitConverter("Meses", 2628000), new PartialRangeUnitConverter("Segundos", 1.0),
            new PartialRangeUnitConverter("Años", 31536000) };

    public TimeConverter() {
        super("Segundos", timeConverters);
    }

    @Override
    public String getUnitType() {
        return "Tiempo";
    }

    @Override
    public String getIconName() {
        return "time_filled.png";
    }

}