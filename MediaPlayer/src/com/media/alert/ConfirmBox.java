package com.media.alert;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {

	boolean answer;

	public boolean display(String title) {
		Stage window = new Stage();
		window.setTitle(title);
		
		window.initModality(Modality.APPLICATION_MODAL);

		Button yesButton = new Button("Yes");
		Button noButton = new Button("No");

		yesButton.setOnAction(e -> {
			answer = true;
			window.close();
		});

		noButton.setOnAction(e -> {
			answer = false;
			window.close();
		});
		
		
		VBox layout = new VBox();
		
		layout.getChildren().addAll(new Label("Are you sure you want to do this ?")
				,yesButton
				,noButton);

		Scene scene = new Scene(layout, 200, 150);
		
		window.setScene(scene);
		window.showAndWait();		
		
		return answer;
	}
}
