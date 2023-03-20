package utilities;

import application.converters.BaseUnitConverter;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class ConversionUnitCellFactory implements Callback<ListView<BaseUnitConverter>, ListCell<BaseUnitConverter>> {

	@Override
	public ListCell<BaseUnitConverter> call(ListView<BaseUnitConverter> listview) {
		return new ConversionUnitCell();
	}

}