package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.util.StringConverter;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import application.converters.BaseUnitConverter;
import application.converters.UnitTypeConverter;
import application.converters.length.LengthConverter;
import application.converters.temperature.TemperatureConverter;
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
	private ComboBox<BaseUnitConverter> leftUnitTypeMenu;

	@FXML
	private ComboBox<BaseUnitConverter> rightUnitTypeMenu;

	private List<UnitTypeConverter> allUnitTypeConverters = Arrays.asList(
			new LengthConverter(),
			new VolumeConverter(),
			new TemperatureConverter()
			);

	@FXML
	public void initialize() {
		
		unitTypeMenu.getItems().addAll(allUnitTypeConverters);
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
		rightUnitTypeMenu.getItems().addAll(baseUnitConverters);

		leftUnitTypeMenu.getSelectionModel().select(0);
		rightUnitTypeMenu.getSelectionModel().select(1);

		StringConverter<BaseUnitConverter> baseUnitStringConverter = new StringConverter<BaseUnitConverter>() {

			@Override
			public BaseUnitConverter fromString(String converter) {
				return null;
			}

			@Override
			public String toString(BaseUnitConverter converter) {
				return converter == null ? null: converter.getName();
			}

		};

		leftUnitTypeMenu.setConverter(baseUnitStringConverter);
		rightUnitTypeMenu.setConverter(baseUnitStringConverter);
	}

	// Event handlers
	public void onUnitTypeChange(ActionEvent e) {
		ObservableList<BaseUnitConverter> newBaseConverters = FXCollections.observableArrayList(unitTypeMenu.getValue().getBaseUnitConvertersList());
		
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
		if (leftTextField.getText().isBlank()) {
			rightTextField.setText("");
		} else {
			UnitTypeConverter unitConverter = unitTypeMenu.getValue();
			BigDecimal leftUnit = new BigDecimal(Double.parseDouble(leftTextField.getText()));
			BigDecimal rightUnit = unitConverter.convert(leftUnit, leftUnitTypeMenu.getValue(),
					rightUnitTypeMenu.getValue());
			rightTextField.setText(rightUnit.stripTrailingZeros().toPlainString());
		}
	}

	private void convertRightToLeft() {
		if (rightTextField.getText().isBlank()) {
			leftTextField.setText("");
		} else {
			UnitTypeConverter unitConverter = unitTypeMenu.getValue();
			BigDecimal rightUnit = new BigDecimal(Double.parseDouble(rightTextField.getText()));
			BigDecimal leftUnit = unitConverter.convert(rightUnit, rightUnitTypeMenu.getValue(),
					leftUnitTypeMenu.getValue());
			leftTextField.setText(leftUnit.stripTrailingZeros().toPlainString());
		}
	}
}
