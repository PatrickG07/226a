package ch.P4;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class Controller {
	
	@FXML protected Line line1;
	@FXML protected Line line2;
	@FXML protected Line line3;
	@FXML protected Line line4;
	@FXML protected Circle line5;
	@FXML protected Line line6;
	@FXML protected Line line7;
	@FXML protected Line line8;
	@FXML protected Line line9;
	@FXML protected Line line10;
	@FXML protected Label label1;
	@FXML protected Label label2;
	
	int i = 0;
	int k = 10;
	String b = "";
	
	@FXML
	public void pruefen(ActionEvent event){
		Button btn = (Button) event.getSource();
		b = b+btn.getText();
		btn.setVisible(false);
		label1.setText(b);
		
		i++;
		if(i==1){
			((Node) line1).setVisible(true);
		}else if(i==2){
			((Node) line2).setVisible(true);
		}else if(i==3){
			((Node) line3).setVisible(true);
		}else if(i==4){
			((Node) line4).setVisible(true);
		}else if(i==5){
			line5.setVisible(true);
		}else if(i==6){
			((Node) line6).setVisible(true);
		}else if(i==7){
			((Node) line7).setVisible(true);
		}else if(i==8){
			((Node) line8).setVisible(true);
		}else if(i==9){
			((Node) line9).setVisible(true);
		}else if(i==10){
			((Node) line10).setVisible(true);
		}
		k--;
		if(k==0){
			label2.setText("You are dead");
		}else if(k==-1){
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Restart");
			alert.setHeaderText("Do you want to Restart?");
			alert.setContentText("Choose your option.");

			ButtonType buttonTypeOne = new ButtonType("YES");
			ButtonType buttonTypeTwo = new ButtonType("NO");

			alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == buttonTypeOne){
			    //restart Fehlt
				return;
			} else if (result.get() == buttonTypeTwo) {
				System.exit(0);
			}
		}else{
			label2.setText("Trys Left: "+k);
		}
	}
	@FXML
	public void restart(ActionEvent event){
		
	}
}
