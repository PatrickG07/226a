package ch.P1;

import javafx.stage.Stage;

/**
 * This is something that makes me very proud of my programming skills. When a view controller class implements
 * this interface, it will have the init method called as soon as the scene is ready.
 */
public interface ViewController {
	abstract void init(Stage stage);
}