package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class Controller {
	
	// Define controllers
	@FXML
	private ComboBox<String> unitTypeMenu;
	
	@FXML
	private TextField leftTextField;
	
	@FXML
	private TextField rightTextField;
	
	@FXML
	private ComboBox<String> leftUnitTypeMenu;
	
	@FXML
	private ComboBox<String> rightUnitTypeMenu;
	
	@FXML 
	public void initialize() {
		unitTypeMenu.getItems().addAll("Currency", "Temperature", "Length");
		leftUnitTypeMenu.getItems().addAll("Unit 1", "Unit 2", "Unit 3");
		rightUnitTypeMenu.getItems().addAll("Unit 4", "Unit 5", "Unit 6");
	}
	
	// Event handlers
	public void onUnitTypeChange(ActionEvent e) {
		System.out.println("unit type changed");
	}
	
	public void onLeftUnitMenuChange(ActionEvent e) {
		System.out.println("left menu changed");
	}
	
	public void onRightUnitMenuChange(ActionEvent e) {
		System.out.println("right menu changed");
	}
	
	public void onLeftTextFieldChange(KeyEvent e) {
		System.out.println("left text changed");
	}
	
	public void onRightTextFieldChange(KeyEvent e) {
		System.out.println("left text changed");
	}
}
