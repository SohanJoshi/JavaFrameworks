package com.media.main;

import com.media.alert.ConfirmBox;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainClass extends Application {

	private Scene sceneWithStackPane;
	private Scene sceneWithVerticalBoxPane;
	private Stage window;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		
		primaryStage.setTitle("Media Player");
		initializeStackPaneLayoutScene();
		initializeVerticalPaneLayout();
		
		primaryStage.setScene(sceneWithVerticalBoxPane);
		
		primaryStage.setOnCloseRequest(e -> {
			e.consume();
			closeWindow();
		});
		
		primaryStage.show();
	}

	private void closeWindow() {
		System.out.println("Finishing the program.. Confirming from User");
		boolean userConfirm = new ConfirmBox().display("Close the window");
		if(userConfirm)
			window.close();
	}

	public void initializeStackPaneLayoutScene() {
		StackPane layout = new StackPane();
		
		
		layout.getChildren().addAll(new Label("This is Scene 1")
				,createButton("Change to Vertical Box Scene")
				);

		sceneWithStackPane =  new Scene(layout, 600, 300);
	}

	private Button createButton(String text) {
		Button button = new Button();
		
		button.setText(text);
		button.setOnAction((event) -> window.setScene(
				((Button)event.getSource())
						.getText()
							.contains("Stack") ? sceneWithStackPane: sceneWithVerticalBoxPane));

		return button;
	}
	
	public void initializeVerticalPaneLayout() {
		VBox layout = new VBox();
		
		Button button = new Button("Click for Alert Box");
		
		button.setOnAction(e -> System.out.println(new ConfirmBox().display("Alert Box")));
		
		layout.getChildren().addAll(new Label("This is Scene 2")
				,button
				//,createButton("Change to Stack Pane Scene")
				);
				
		sceneWithVerticalBoxPane = new Scene(layout, 400, 400);
	}
}
