package utilities;

import application.converters.BaseUnitConverter;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ConversionUnitCell extends ListCell<BaseUnitConverter>{

	@Override
	public void updateItem(BaseUnitConverter item, boolean empty)
	{
		super.updateItem(item, empty);

		if (empty)
		{
			setText(null);
			setGraphic(null);
		}
		else
		{
			setText(item.getName());
			String iconName = item.getIconName();
			if(iconName == null) {
				return;
			}
			Image image1 = new Image(getClass().getResourceAsStream("/images/flags/" + iconName));
			//Image image1 = new Image(getClass().getResourceAsStream("/images/flags/COP.png"));
			ImageView imageView1 = new ImageView(image1);
			imageView1.setPreserveRatio(true);
			imageView1.setFitWidth(48); 
			setGraphic(imageView1);
		}
	}

}
