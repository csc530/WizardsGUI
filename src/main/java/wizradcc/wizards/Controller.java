package wizradcc.wizards;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
	
	@FXML
	private TextField txtName;
	@FXML
	private TextField txtElement;
	@FXML
	private Spinner<Integer> spnPwrLvl;
	@FXML
	private RadioButton rbtnEvil;
	@FXML
	private Separator seperator;
	@FXML
	private Label blurb;
	
	@FXML
	protected void create(){
		String name = txtName.getText();
		String element = txtElement.getText();
		int power = spnPwrLvl.getValue();
		char affinity = rbtnEvil.isSelected() ? 'E' : 'G';
		Wizard wiz = new Wizard(name, element, power, affinity);
		blurb.setText(wiz.toString());
		seperator.setVisible(true);
		blurb.setPrefSize(290, 230);
	}
	
	@FXML
	void limitText(KeyEvent event){
		String numbers = "1230456798";
		String text = spnPwrLvl.getEditor().getText();
		if(numbers.contains(event.getText()))
			spnPwrLvl.getEditor().setText(text + event.getText());
		else if(event.getText().equals("\b") && text.length() > 1)
			spnPwrLvl.getEditor().setText(text.substring(0, text.length() - 1));
		else if(event.getText().equals("\b"))
			spnPwrLvl.getEditor().setText("0");
		spnPwrLvl.getValueFactory().setValue(Integer.parseInt(spnPwrLvl.getEditor().getText()));
	}
	
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle){
		spnPwrLvl.valueFactoryProperty().setValue(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 1999999999, 20));
		spnPwrLvl.getValueFactory().setWrapAround(true);
		seperator.setVisible(false);
		blurb.setPrefSize(0, 0);
	}
}