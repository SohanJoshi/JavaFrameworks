package com.media.main;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Validation extends Application{

	Stage window ;
	
	String[] vegMenuItems = {"Paneer", "Cheese Pizza", "Soya Curry"};
	String[] nonVegMenuItems = {"Fish", "Meat", "Pizza"};
	
	String[] listMenuItems = vegMenuItems;
	CheckBox boxes[] ;
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		
		window.setTitle("The Menu Window");
		
		/*TextField input = new TextField();
		Button validateButton = new Button("Validate");
		Label message = new Label();
		
		validateButton.setOnAction(e -> 
			System.out.println("Age validation : " + validateInteger(input, message))
		);
		*/
		ChoiceBox<String> menuOptions = new ChoiceBox<>();
		
		menuOptions.getItems().addAll("Veg","Non-Veg");
		menuOptions.setValue("Veg");
		
		menuOptions.getSelectionModel().selectedItemProperty().addListener((v, o, n) -> {
			setListMenuItems(menuOptions);
		});
		
		Button checkBox = new Button("Order now");
		
		Label orderStatus = new Label();
		checkBox.setOnAction(e -> orderStatus.setText(handleOrder()));		
		
		initializeCheckBoxes();
		
		VBox layout = new VBox();
		
		layout.setPadding(new Insets(10, 10, 10, 10));
		
		layout.getChildren().addAll(menuOptions);
		layout.getChildren().addAll(boxes);
		layout.getChildren().addAll(checkBox, orderStatus);
		
		Scene scene = new Scene(layout, 400, 400);
		
		window.setScene(scene);
		window.show();
	}


	private void setListMenuItems(ChoiceBox<String> menuOptions) {
		if(menuOptions.getValue().contains("Non"))
			listMenuItems = nonVegMenuItems;
		else
			listMenuItems = vegMenuItems;
		initializeCheckBoxes();
	}

	private void initializeCheckBoxes() {
		if(boxes == null) {
			boxes = new CheckBox[listMenuItems.length];
			for(int i = 0; i < listMenuItems.length; i++) {
				boxes[i] = new CheckBox();
				boxes[i].setSelected(false);
			}
		}
		
		for (int i = 0; i < boxes.length; i++) 
			boxes[i].setText(listMenuItems[i]);
	}

	private String handleOrder() {
		StringBuffer order = new StringBuffer("Order is : Nothing  ");
		
		for(CheckBox c : boxes) { 
			if(c.isSelected()) {
				if(order.toString().contains("Nothing"))
						order = new StringBuffer(order.substring(0, order.length() - "Nothing  ".length()));
					order.append(c.getText() + ", ");
			}
		}
		
		return order.toString().substring(0,order.length() - 2);
	}

	/*private boolean validateInteger(TextField input, Label output) {
		String message = input.getText();
		try {
			int age = Integer.parseInt(message.trim());
			output.setText("User age is : "+ age);
			return true;
		}catch(NumberFormatException ex) {
			output.setText("Validation Failed");
			return false;
		}
		
	}*/

}
