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
import utilities.ConversionTypeCell;
import utilities.ConversionTypeCellFactory;
import utilities.ConversionUnitCell;
import utilities.ConversionUnitCellFactory;
import utilities.InvalidInputException;

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
	private HBox lastUpdatedBox;
	
	@FXML
	private Label date;
	
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
	private HBox errorsHbox;

	@FXML
	private Label errorLabel;

	private CurrencyConverter currencyConverter = new CurrencyConverter();
	private String currentConversionType = currencyConverter.getUnitType();
	private UnitTypeConverter[] allConverters = new UnitTypeConverter[] { currencyConverter,
			new LengthConverter(), new MassConverter(), new SpeedConverter(), new TemperatureConverter(),
			new TimeConverter(), new VolumeConverter()};

	@FXML
	public void initialize() {

		unitTypeMenu.getItems().addAll(allConverters);
		
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

		leftCurrencyMenu.getItems().addAll(baseUnitConverters);
		rightCurrencyMenu.getItems().addAll(baseUnitConverters);

		List<ComboBox<BaseUnitConverter>> comboboxes = Arrays.asList(leftUnitTypeMenu, rightUnitTypeMenu, leftCurrencyMenu, rightCurrencyMenu);
		comboboxes.forEach(combobox ->{
			combobox.setCellFactory(new ConversionUnitCellFactory());
			combobox.setButtonCell(new ConversionUnitCell());
		});
		
		leftCurrencyMenu.getSelectionModel().select(0);
		rightCurrencyMenu.getSelectionModel().select(1);

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
		
		leftCurrencyMenu.setConverter(baseUnitStringConverter);
		rightCurrencyMenu.setConverter(baseUnitStringConverter);
		
		date.setText(currencyConverter.getDate());
		lastUpdatedBox.setOpacity(1);
		
		leftTextField.focusedProperty().addListener((obs, oldVal, newVal) -> {
			if(newVal) {
				highlightLeftRegion("#6BD1FF");
				highlightRightRegion("#316F9B");
			} else {
				highlightRightRegion("#6BD1FF");
				highlightLeftRegion("#316F9B");				
			}			
		});
		
		rightTextField.focusedProperty().addListener((obs, oldVal, newVal) -> {
			if(newVal) {
				highlightRightRegion("#6BD1FF");
				highlightLeftRegion("#316F9B");
			} else {
				highlightLeftRegion("#6BD1FF");
				highlightRightRegion("#316F9B");			
			}			
		});
	}

	// Event handlers
	public void onUnitTypeChange(ActionEvent e) {
		ObservableList<BaseUnitConverter> newBaseConverters = FXCollections
				.observableArrayList(unitTypeMenu.getValue().getBaseUnitConvertersList());

		currentConversionType = unitTypeMenu.getValue().getUnitType();
		leftTextField.setText("");
		rightTextField.setText("");

		if(currentConversionType.equals(currencyConverter.getUnitType())) {
			lastUpdatedBox.setOpacity(1);
			leftCurrencyMenu.getSelectionModel().select(0);
			rightCurrencyMenu.getSelectionModel().select(1);
			currencyUnits.toFront();
		} 
		else {
			lastUpdatedBox.setOpacity(0);
			leftUnitTypeMenu.setItems(newBaseConverters);
			rightUnitTypeMenu.setItems(newBaseConverters);
			
			leftUnitTypeMenu.getSelectionModel().select(0);
			rightUnitTypeMenu.getSelectionModel().select(1);
			
			otherUnits.toFront();
		}
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
		highlightLeftRegion("#6BD1FF");
		String prevStyles = leftTextField.getStyle();
		leftTextField.setStyle("-fx-text-fill: #6BD1FF;" + prevStyles );
		errorsHbox.setOpacity(0);
		if (leftTextField.getText().isBlank()) {
			rightTextField.setText("");
		} else {
			UnitTypeConverter unitConverter = unitTypeMenu.getValue();
			try {
				BigDecimal rightUnit = null;
				if(currentConversionType.equals(currencyConverter.getUnitType()) ) {
					rightUnit = unitConverter.convert(leftTextField.getText(), leftCurrencyMenu.getValue(),
							rightCurrencyMenu.getValue());
				} else {
					rightUnit = unitConverter.convert(leftTextField.getText(), leftUnitTypeMenu.getValue(),
							rightUnitTypeMenu.getValue());
				}
				rightTextField.setText(rightUnit.stripTrailingZeros().toPlainString());
			} catch (InvalidInputException e) {
				rightTextField.setText("");
				if(!e.getMessage().equals("")) {
					highlightLeftRegion("#F16165");
					prevStyles = leftTextField.getStyle();
					leftTextField.setStyle("-fx-text-fill: #F16165;" + prevStyles );
					errorLabel.setText(e.getMessage());	
					errorsHbox.setOpacity(1);
				}
			}
		}
	}

	private void convertRightToLeft() {
		highlightRightRegion("#6BD1FF");
		String prevStyles = rightTextField.getStyle();
		rightTextField.setStyle("-fx-text-fill: #6BD1FF;" + prevStyles );
		errorsHbox.setOpacity(0);
		if (rightTextField.getText().isBlank()) {
			leftTextField.setText("");
		} else {
			try {
			UnitTypeConverter unitConverter = unitTypeMenu.getValue();
			BigDecimal leftUnit = null;
			if(currentConversionType.equals(currencyConverter.getUnitType()) ) {
				leftUnit = unitConverter.convert(rightTextField.getText(), rightCurrencyMenu.getValue(),
						leftCurrencyMenu.getValue());
			} else {
				leftUnit = unitConverter.convert(rightTextField.getText(), rightUnitTypeMenu.getValue(),
						leftUnitTypeMenu.getValue());
			}
			leftTextField.setText(leftUnit.stripTrailingZeros().toPlainString());
			} catch (InvalidInputException e) {
				leftTextField.setText("");
				if(!e.getMessage().equals("")) {
					highlightRightRegion("#F16165");
					prevStyles = rightTextField.getStyle();
					rightTextField.setStyle("-fx-text-fill: #F16165;" + prevStyles );
					errorLabel.setText(e.getMessage());
					errorsHbox.setOpacity(1);
				}
			}
		}
	}
	
	private void highlightLeftRegion(String color) {
		leftTextField.setStyle("-fx-border-color: " + color + ";");
		leftCurrencyMenu.setStyle("-fx-background-color: "+ color +", #051D3B, #051D3B, #051D3B;\r\n"
				+ "	-fx-control-inner-background: #051D3B;");
		leftUnitTypeMenu.setStyle("-fx-background-color: "+ color +", #051D3B, #051D3B, #051D3B;\r\n"
				+ "	-fx-control-inner-background: #051D3B;");
	}
	
	private void highlightRightRegion(String color) {
		rightTextField.setStyle("-fx-border-color: " + color + ";");
		rightCurrencyMenu.setStyle("-fx-background-color: "+ color +", #051D3B, #051D3B, #051D3B;\r\n"
				+ "	-fx-control-inner-background: #051D3B;");
		rightUnitTypeMenu.setStyle("-fx-background-color: "+ color +", #051D3B, #051D3B, #051D3B;\r\n"
				+ "	-fx-control-inner-background: #051D3B;");
	}
}
