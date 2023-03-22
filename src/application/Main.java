package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Controller.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Convertidor de unidades");
			
		    Font.loadFont(getClass().getResourceAsStream("/fonts/Inter-Medium"), 24);
		    Font.loadFont(getClass().getResourceAsStream("/fonts/Inter-Regular"), 24);
			
			Image windowIcon = new Image("icon.png");
			primaryStage.getIcons().add(windowIcon);
			
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.maxHeightProperty().bind(primaryStage.heightProperty());
			primaryStage.minHeightProperty().bind(primaryStage.heightProperty());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
