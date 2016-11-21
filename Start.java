package ch.P4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Start extends Application {
	
	//public static Stage mainStage;
	
	public static void main(String... args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		Scene scene = new Scene(root);

		primaryStage.setTitle("Hangman");
		primaryStage.centerOnScreen();
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
