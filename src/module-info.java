module converter {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.base;
	requires org.json;
	
	opens application to javafx.graphics, javafx.fxml;
}
