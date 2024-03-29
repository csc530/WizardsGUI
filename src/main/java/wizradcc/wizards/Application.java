package wizradcc.wizards;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application{
	public static void main(String[] args){
		launch();
	}
	
	@Override
	public void start(Stage stage) throws IOException{
		FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("wizardView.fxml"));
		Scene scene = new Scene(fxmlLoader.load());
		stage.setTitle("Wizard's Magickry!");
		stage.setScene(scene);
		stage.show();
	}
}