package application.converters.volume;

import application.converters.PartialRangeUnitConverter;
import application.converters.UnitTypeConverter;

public class VolumeConverter extends UnitTypeConverter {

	private static PartialRangeUnitConverter[] volumeConverters = new PartialRangeUnitConverter[] {
			new PartialRangeUnitConverter("Tazas", 0.24), new PartialRangeUnitConverter("Onzas Líquidas", 0.0295735),
			new PartialRangeUnitConverter("Galones", 3.78541), new PartialRangeUnitConverter("Litros", 1.0),
			new PartialRangeUnitConverter("Mililitros", 0.001), new PartialRangeUnitConverter("Pintas", 0.473176),
			new PartialRangeUnitConverter("Cuartos", 0.946353), new PartialRangeUnitConverter("Cucharadas", 0.0147868),
			new PartialRangeUnitConverter("Cucharaditas", 0.00492892) };

	public VolumeConverter() {
		super("Litros", volumeConverters);
	}

	@Override
	public String getUnitType() {
		return "Volumen";
	}

	@Override
	public String getIconName() {
		return "volume_filled1.png";
	}

}
