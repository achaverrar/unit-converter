package application.converters.speed;

import application.converters.FullRangeBaseUnitConverter;
import application.converters.UnitTypeConverter;

public class SpeedConverter extends UnitTypeConverter {

    private static FullRangeBaseUnitConverter[] speedConverters = new FullRangeBaseUnitConverter[] {
            new FullRangeBaseUnitConverter("Kilómetros / Hora", 0.277778), new FullRangeBaseUnitConverter("Nudos", 0.514444),
            new FullRangeBaseUnitConverter("Metros / Segundos", 1.0), new FullRangeBaseUnitConverter("Millas / Hora", 0.44704), };

    public SpeedConverter() {
        super("Metros / Segundos", speedConverters);
    }

    @Override
    public String getUnitType() {
        return "Velocidad";
    }

    @Override
    public String getIconName() {
        return "speed_filled.png";
    }

}