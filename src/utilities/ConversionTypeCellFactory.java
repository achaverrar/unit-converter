package utilities;
import application.converters.UnitTypeConverter;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class ConversionTypeCellFactory implements Callback<ListView<UnitTypeConverter>, ListCell<UnitTypeConverter>>{
	@Override
	public ListCell<UnitTypeConverter> call(ListView<UnitTypeConverter> listview)
	{
		return new ConversionTypeCell();
	}
}
