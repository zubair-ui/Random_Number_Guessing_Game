package application;
	
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application {
	private String randomNumber;
	int numberOfAttempts;
	
	public void setRandomNumber() {
		numberOfAttempts=0;
		randomNumber="";
		randomNumber+=((int) (Math.random()*100))+1;
	}
	
	@Override
	public void start(Stage stage) {
		setRandomNumber();
		
		
		
		Text header = new Text();
		header.setText("Random Number Guessing Game:");
		header.setLayoutX(120);
		header.setLayoutY(100);
		header.setFill(Color.BLACK);
		header.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 35));
		header.setUnderline(true);
		
		
		
		
		Label label2 = new Label("Guess the Number(1-100):");
		label2.setFont(Font.font("Times New Roman", FontWeight.BOLD, 23));
		label2.setLayoutX(80);
		label2.setLayoutY(240);
        TextField tf= new TextField();
        tf.setLayoutX(340);
        tf.setLayoutY(240);
        tf.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
		
        
        Button enter = new Button("→");
        enter.setLayoutX(580);
        enter.setLayoutY(240);
        enter.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD,18));
        
        
        enter.setOnAction(e ->{
        	numberOfAttempts++;
        	String guessedNumber=tf.getText();
        	
        	if(!guessedNumber.equals("")) {
        		if(guessedNumber.matches("\\d++")) {
        			if(!(Integer.parseInt(guessedNumber)>100)) {
        				if(guessedNumber.equals(randomNumber)) {
        					Alert a = new Alert(Alert.AlertType.INFORMATION);
                            a.setContentText("Congratulations! You Guessed the Random Number"
                            		+ "\n Number Of Attempts = "+numberOfAttempts);
                            a.setHeaderText(null);
                            a.setTitle("Winner");
                            a.showAndWait();
                            
                            Alert prompt = new Alert(Alert.AlertType.CONFIRMATION);
                            prompt.setContentText("Would You like to Play Again?");
                            prompt.setHeaderText(null);
                            prompt.showAndWait();
                            if(prompt.getResult() == ButtonType.OK) {
                            	start(stage);
                            }
                            else {
                            	stage.close();
                            }
        				}
        				else if(Integer.parseInt(guessedNumber)>Integer.parseInt(randomNumber)) {
        					Alert a = new Alert(Alert.AlertType.INFORMATION);
                            a.setContentText("The Random Number is less than "+guessedNumber);
                            a.setHeaderText(null);
                            a.showAndWait();
        				}
        				else {
        					Alert a = new Alert(Alert.AlertType.INFORMATION);
                            a.setContentText("The Random Number is Greater than "+guessedNumber);
                            a.setHeaderText(null);
                            a.showAndWait();
        				}
        			}
        			else {
        				Alert a = new Alert(Alert.AlertType.ERROR);
                        a.setContentText("The Number cannot be greater than 100");
                        a.setHeaderText(null);
                        a.showAndWait();
        			}
        		}
        		else {
        			Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setContentText("Please Enter Positive Integer Value Only");
                    a.setHeaderText(null);
                    a.showAndWait();
        		}
        	}
        	else {
        		Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("Empty");
                a.setHeaderText(null);
                a.showAndWait();
        	}
        });
        
        
        
        Button refresh = new Button("Refresh");
        refresh.setLayoutX(380);
        refresh.setLayoutY(350);
        refresh.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD,18));
		
        refresh.setOnAction(e ->{
        	start(stage);
        });
        
        
		
		Group root = new Group(tf,label2,enter,header,refresh);
        Scene scene = new Scene(root, 800, 600);
        scene.setFill(Color.CYAN);
        
        Image icon = new Image("file:icon.png");
        stage.setScene(scene);
        stage.getIcons().add(icon);
        stage.setResizable(false);
        stage.setTitle("Number Guessing Game");
        stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
