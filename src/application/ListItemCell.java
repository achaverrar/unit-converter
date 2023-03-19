package application;

import application.converters.UnitTypeConverter;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;

public class ListItemCell extends ListCell<UnitTypeConverter>{
	@Override
	public void updateItem(UnitTypeConverter item, boolean empty)
	{
		super.updateItem(item, empty);

		if (empty)
		{
			setText(null);
			setGraphic(null);
		}
		else
		{
			setText(item.getUnitType());
			/*Shape shape = this.getShape(item);*/
			//Image image1 = new Image(getClass().getResourceAsStream("colombia.png"));
			Image image1 = new Image(getClass().getResourceAsStream("/images/converters/"+item.getIconName()));
			ImageView imageView1 = new ImageView(image1);
			imageView1.setPreserveRatio(true);
			imageView1.setFitWidth(64); 
			setGraphic(imageView1);
		}
	}
	
	/*
	public Shape getShape(String shapeType)
	{
		Shape shape = null;

		switch (shapeType.toLowerCase())
		{
			case "line":
				shape = new Line(0, 10, 20, 10);
				break;
			case "rectangle":
				shape = new Rectangle(0, 0, 20, 20);
				break;
			case "circle":
				shape = new Circle(20, 20, 10);
				break;
			case "Text":
				shape = new Text(10, 50, "This is a Text");
				break;
			default:
				shape = null;
		}

		return shape;
	}
	*/
}
