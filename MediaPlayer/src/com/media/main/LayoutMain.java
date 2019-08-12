package com.media.main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LayoutMain extends Application {

	Stage window ;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		
		window.setTitle("LayoutManager");
		
		HBox topMenu = new HBox();
		Button fileButton = new Button("File");
		Button editButton = new Button("Edit");
		Button helpButton = new Button("Help");
		
		topMenu.getChildren().addAll(fileButton, editButton, helpButton);
		
		VBox leftMenu = new VBox();
		Button dButton = new Button("D");
		Button eButton = new Button("E");
		Button fButton = new Button("F");
		
		leftMenu.getChildren().addAll(dButton, eButton, fButton);
		
		BorderPane borderPane = new BorderPane();
		
		borderPane.setTop(topMenu);
		borderPane.setLeft(leftMenu);
		
		Scene scene = new Scene(borderPane, 600, 600);
		window.setScene(scene);
		window.show();
		
	}

}
