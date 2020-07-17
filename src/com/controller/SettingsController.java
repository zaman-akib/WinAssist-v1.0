package com.controller;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.view.ViewFactory;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SettingsController {
	
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
    private TextField newUsername;
    @FXML
    private PasswordField oldPassword;
    @FXML
    private PasswordField newPassword;
    @FXML
    private Label oldPassLabel;
    @FXML
    private Button cancelButton;
    @FXML
    private Button cancelButton2;
    
    @FXML
    private void saveChanges(ActionEvent event) {
    	String s=new String();
    	
        File f1=new File("Name&Pass.txt");
        FileReader fr_;
		
		try {
			fr_=new FileReader(f1);
			Scanner sc=new Scanner(fr_);
		    sc.next();
		    s=sc.next();
			sc.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
    	
    	if(oldPassword.getText().equals(s)) {
    		File f=new File("Name&Pass.txt");
    		FileWriter fr;
    		try {
    			fr=new FileWriter(f);
    			fr.write(newUsername.getText()+" "+newPassword.getText());
    			fr.flush();
    			fr.close();
    		}
    		catch(IOException e){
    			e.printStackTrace();
    		}
    		closeStage();
        	loadLogin();
    	}
    	
    	else {
    		oldPassLabel.setText("* Wrong old password !!!");
    		oldPassword.setText("");
    	}
    }
    
    private void loadLogin() {
    	Stage loginStage = new Stage();
    	ViewFactory viewFactory = new ViewFactory();
    	Scene scene = viewFactory.getLoginScene();
    	loginStage.setTitle("Login");
    	loginStage.initStyle(StageStyle.UNDECORATED);
    	loginStage.setResizable(false);
    	loginStage.setScene(scene);
    	loginStage.getIcons().add(viewFactory.getDefaultIcon());
    	loginStage.show();
		
	}
    
    private void closeStage() {
    	((Stage) newUsername.getScene().getWindow()).close();
    }

	@FXML
    private void manageSignUp(ActionEvent event) {
    	
    		File f=new File("Name&Pass.txt");
    		FileWriter fr;
    		try {
    			fr=new FileWriter(f);
    			fr.write(username.getText()+" "+password.getText());
    			fr.flush();
    			fr.close();
    		}
    		catch(IOException e){
    			e.printStackTrace();
    		}
    		
    		closeStage();
        	loadLogin();
    }
    
    @FXML
    private void closeSettings(ActionEvent event) {
    	Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void closeSignUp(ActionEvent event) {
    	Stage stage = (Stage) cancelButton2.getScene().getWindow();
        stage.close();
    }

}
