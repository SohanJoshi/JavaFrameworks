package com.media.main;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridPaneLayout extends Application{

	Stage window;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(10);
		grid.setHgap(8);
		
		grid.add(new Label("Username : "), 0, 0);
		grid.add(new TextField("Bucky"), 0, 1);
		
		grid.add(new Label("Password : "), 1, 0);
		
		TextField password = new TextField();
		password.setPromptText("Password");
		
		grid.add(password, 1, 1);
		
		Scene scene = new Scene(grid, 400, 400);
		
		window.setScene(scene);
		
		window.show();
		
	}

}
