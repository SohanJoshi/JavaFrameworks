package com.media.alert;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {

	public void display(String title, String message) {
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		
		Button button = new Button("Click to close.");
		button.setOnAction(e -> window.close());
		
		VBox layout = new VBox();
		
		layout.getChildren().addAll(new Label(message),button);
		
		Scene scene = new Scene(layout, 200, 200);
		
		window.setScene(scene);
		
		window.showAndWait();
	}
	
}
