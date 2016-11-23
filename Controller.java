package ch.P1;

import java.util.Optional;
import java.util.Random;

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
import javafx.stage.Stage;

public class Controller implements ViewController{
	
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
	@FXML protected Button start;
	
	int i = 0;
	int k = 10;
	int s = 0;
	int t = 0;
	String b = "";
	String text = "";
	public char[] array;
	public String word;
	public boolean line = false;
	
	/** @Autor Patrick Gartenmann
	*
	* it gets a random word from the String words
	*/
	public Controller(){
		String[] words = {"writer", "that", "program","the","case",
				"difficulty","deciphering","word","depends","titel",
				"language","dictionaries","categorize","lexicon",
				"vocabulary","into"};
        int random = new Random().nextInt(words.length);
        word = (words[random]);
	}
	/** @Autor Patrick Gartenmann
	*
	* what its create after the Controller
	* create an char array with the length of the random word from Controller
	*/
	@Override
	public void init(Stage stage) {
		// TODO Auto-generated method stub
		array = new char[word.length()];
        for(int p=0; p<word.length();p++){
        	array[p] = '-';
        }
        String b = new String(array);
		label1.setText(b);
	}
	/** @Autor Patrick Gartenmann
	*
	* Pressing a button at the bottom
	* its read the text of the button and saves it as "b" 
 	* and checks the random word if "b" in it 
	* and sets the letter "b" at the correct location in the char array
	*/
	@FXML
	public void pruefen(ActionEvent event){
		Button btn = (Button) event.getSource();
		b = btn.getText();
		btn.setVisible(false);
		for(int p = 0; p < word.length(); p++){
			if(b.charAt(0)+32 == word.charAt(p)){
				line = true;
				s++;
				array[p] = b.charAt(0);
				String b = new String(array);
				label1.setText(b);
			}
		}
		/** @Autor Patrick Gartenmann
		*
		* the end if all words are correct 
		* Output of the option to end or to restart
		*/
		if(s==word.length()){
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Restart");
			alert.setHeaderText("You won! Do you want to Restart?");
			alert.setContentText("The word was: "+ word);
			ButtonType buttonTypeOne = new ButtonType("YES");
			ButtonType buttonTypeTwo = new ButtonType("NO");
			alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == buttonTypeOne){
				Start.loadScene("Main");
			} else if (result.get() == buttonTypeTwo){
				System.exit(0);
			}
		}
		/** @Autor Patrick Gartenmann
		*
		* showing the lines of the hangman
		*/
		if(!line){
			i++;
	        switch (i) {
	            case 1: ((Node) line1).setVisible(true); break;
	            case 2: ((Node) line2).setVisible(true); break;
	            case 3: ((Node) line3).setVisible(true); break;
	            case 4: ((Node) line4).setVisible(true); break;
	            case 5: line5.setVisible(true);break;
	            case 6: ((Node) line6).setVisible(true); break;
	            case 7:	((Node) line7).setVisible(true); break;
	            case 8: ((Node) line8).setVisible(true); break;
	            case 9: ((Node) line9).setVisible(true); break;
	            case 10:((Node) line10).setVisible(true); break;
	        }
		    /** @Autor Patrick Gartenmann
			*
			* the end if the timer "k" is on 0
		    * Output of the option to end or to restart
		    */
			k--;
			if(k==0){
				label2.setText("You are dead");
				label1.setText(word);
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Restart");
				alert.setHeaderText("You losse! Do you want to Restart?");
				alert.setContentText("The word was: "+ word);
				ButtonType buttonTypeOne = new ButtonType("YES");
				ButtonType buttonTypeTwo = new ButtonType("NO");
				alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == buttonTypeOne){
					Start.loadScene("Main");
					return;
				} else if (result.get() == buttonTypeTwo) {
					System.exit(0);
				}
			}else{
				label2.setText("Trys Left: "+k);
			}
		}
		line=false;
	}
}
