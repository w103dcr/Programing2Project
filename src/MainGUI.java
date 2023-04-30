
	
//Class MainGUI, C211 Group Project Spring 2023
//Author: Rhett Godwin

//**********MainGUI FINAL*****************
//Main Java file to start the GUI portion*
//Of the program                         *
//****************************************


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


public class MainGUI extends Application {
	

	public void start(Stage primaryStage) {
		try {
			Pane root = (Pane)FXMLLoader.load(getClass().getResource("MazeXML.fxml"));
			Scene scene = new Scene(root,800,600);
		
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
	    
		launch(args);
	}
	
}
