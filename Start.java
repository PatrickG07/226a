package ch.P1;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Start extends Application {
	//public static Stage mainStage;
	public static Stage mainStage;
	public static void main(String... args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		mainStage = primaryStage;
		Stage stage = loadScene("Main",false);
		stage.show();
	}
	public static Stage loadScene(String name, boolean newWindow) {
		Parent parentToLoad = null;
		FXMLLoader loader = new FXMLLoader();
		try {
			URL resourcePath = Start.class.getResource(name + ".fxml");
			loader.setLocation(resourcePath);
			parentToLoad = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene sceneToLoad = new Scene(parentToLoad);
		if (!newWindow) {
			mainStage.setScene(sceneToLoad);
			((ViewController)loader.getController()).init(mainStage);
			return mainStage;
		}
		else {
			Stage newStage = new Stage();
			newStage.setScene(sceneToLoad);
			newStage.setTitle(name);
			newStage.show();
			((ViewController)loader.getController()).init(newStage);
			return newStage;
		}
	}
	/**
	 * Used to load the passed scene into the main window.
	 * @param name
	 */
	public static void loadScene(String name) {
		loadScene(name, false);
	}
}
