package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.util.StringConverter;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import application.converters.BaseUnitConverter;
import application.converters.UnitTypeConverter;
import application.converters.currency.CurrencyConverter;
import application.converters.length.LengthConverter;
import application.converters.mass.MassConverter;
import application.converters.speed.SpeedConverter;
import application.converters.temperature.TemperatureConverter;
import application.converters.time.TimeConverter;
import application.converters.volume.VolumeConverter;

public class Controller {

	// Define controllers
	@FXML
	private ComboBox<UnitTypeConverter> unitTypeMenu;

	@FXML
	private TextField leftTextField;

	@FXML
	private TextField rightTextField;
	
	@FXML
	private StackPane hboxStack;
	
	@FXML
	private HBox currencyUnits;
	
	@FXML
	private HBox otherUnits;

	@FXML
	private ComboBox<BaseUnitConverter> leftUnitTypeMenu;

	@FXML
	private ComboBox<BaseUnitConverter> rightUnitTypeMenu;
	
	@FXML
	private ComboBox<BaseUnitConverter> leftCurrencyMenu;
	
	@FXML
	private ComboBox<BaseUnitConverter> rightCurrencyMenu;

	@FXML
	private Label errorLabel;

	private UnitTypeConverter currencyConverter = new CurrencyConverter();
	private UnitTypeConverter[] allUnitTypeConverters = new UnitTypeConverter[] {new CurrencyConverter(),
			new LengthConverter(), new MassConverter(), new SpeedConverter(), new TemperatureConverter(),
			new TimeConverter(), new VolumeConverter()};

	@FXML
	public void initialize() {

		unitTypeMenu.getItems().addAll(allUnitTypeConverters);
		
		unitTypeMenu.setCellFactory(new ConversionTypeCellFactory());
		unitTypeMenu.setButtonCell(new ConversionTypeCell());
		
		unitTypeMenu.getSelectionModel().selectFirst();
		unitTypeMenu.setConverter(new StringConverter<UnitTypeConverter>() {

			@Override
			public String toString(UnitTypeConverter converter) {
				return converter.getUnitType();
			}

			@Override
			public UnitTypeConverter fromString(String converter) {
				return null;
			}
		});

		List<BaseUnitConverter> baseUnitConverters = unitTypeMenu.getValue().getBaseUnitConvertersList();
		leftUnitTypeMenu.getItems().addAll(baseUnitConverters);
		leftUnitTypeMenu.setCellFactory(new ConversionUnitCellFactory());
		leftUnitTypeMenu.setButtonCell(new ConversionUnitCell());
		
		rightUnitTypeMenu.getItems().addAll(baseUnitConverters);
		rightUnitTypeMenu.setCellFactory(new ConversionUnitCellFactory());
		rightUnitTypeMenu.setButtonCell(new ConversionUnitCell());

		leftUnitTypeMenu.getSelectionModel().select(0);
		rightUnitTypeMenu.getSelectionModel().select(1);

		StringConverter<BaseUnitConverter> baseUnitStringConverter = new StringConverter<BaseUnitConverter>() {

			@Override
			public BaseUnitConverter fromString(String converter) {
				return null;
			}

			@Override
			public String toString(BaseUnitConverter converter) {
				return converter == null ? null : converter.getName();
			}

		};

		leftUnitTypeMenu.setConverter(baseUnitStringConverter);
		rightUnitTypeMenu.setConverter(baseUnitStringConverter);
	}

	// Event handlers
	public void onUnitTypeChange(ActionEvent e) {
		ObservableList<BaseUnitConverter> newBaseConverters = FXCollections
				.observableArrayList(unitTypeMenu.getValue().getBaseUnitConvertersList());

		leftTextField.setText("");
		rightTextField.setText("");

		leftUnitTypeMenu.setItems(newBaseConverters);
		rightUnitTypeMenu.setItems(newBaseConverters);

		leftUnitTypeMenu.getSelectionModel().select(0);
		rightUnitTypeMenu.getSelectionModel().select(1);
	}

	public void onLeftUnitMenuChange(ActionEvent e) {
		convertRightToLeft();
	}

	public void onRightUnitMenuChange(ActionEvent e) {
		convertLeftToRight();
	}

	public void onLeftTextFieldChange(KeyEvent e) {
		convertLeftToRight();
	}

	public void onRightTextFieldChange(KeyEvent e) {
		convertRightToLeft();
	}

	private void convertLeftToRight() {
		leftTextField.setStyle("-fx-border: none;");
		errorLabel.setText("");
		if (leftTextField.getText().isBlank()) {
			rightTextField.setText("");
		} else {
			UnitTypeConverter unitConverter = unitTypeMenu.getValue();
			try {
				BigDecimal rightUnit = unitConverter.convert(leftTextField.getText(), leftUnitTypeMenu.getValue(),
						rightUnitTypeMenu.getValue());
				rightTextField.setText(rightUnit.stripTrailingZeros().toPlainString());
			} catch (InvalidInputException e) {
				rightTextField.setText("");
				if(!e.getMessage().equals("")) {
					leftTextField.setStyle("-fx-border-color: red; -fx-border-width: 0 0 2 0;");
					errorLabel.setText(e.getMessage());	
				}
			}
		}
	}

	private void convertRightToLeft() {
		rightTextField.setStyle("-fx-border: none;");
		errorLabel.setText("");
		if (rightTextField.getText().isBlank()) {
			leftTextField.setText("");
		} else {
			try {
			UnitTypeConverter unitConverter = unitTypeMenu.getValue();
			BigDecimal leftUnit = unitConverter.convert(rightTextField.getText(), rightUnitTypeMenu.getValue(),
					leftUnitTypeMenu.getValue());
			leftTextField.setText(leftUnit.stripTrailingZeros().toPlainString());
			} catch (InvalidInputException e) {
				leftTextField.setText("");
				if(!e.getMessage().equals("")) {
					rightTextField.setStyle("-fx-border-color: red; -fx-border-width: 0 0 2 0;");
					errorLabel.setText(e.getMessage());					
				}
			}
		}
	}
}
