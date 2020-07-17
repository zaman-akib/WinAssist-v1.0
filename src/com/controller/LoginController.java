package com.controller;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.model.TextToSpeech;
import com.view.ViewFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginController {
	
	@FXML
    public AnchorPane rootPane;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label passLabel;

    @FXML
    private void handleLoginButtonAction(ActionEvent event) {
        String uname=new String();
        String pass=new String();
    	
        File f1=new File("Name&Pass.txt");
        FileReader fr_;
		
		try {
			fr_=new FileReader(f1);
			Scanner sc=new Scanner(fr_);
		    uname=sc.next();
		    pass=sc.next();
			sc.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
    	
    	if(username.getText().equals(uname) && password.getText().equals(pass) ) {
    		TextToSpeech.speak("Logging in.");
    		closeStage();
    		loadMain();
    	}
        else {
        	passLabel.setText("* Wrong Password !!");
        	TextToSpeech.speak("Wrong Username or Password. Please enter correctly.");
        	password.setText("");
        }
    }

    @FXML
    private void handleCancelButtonAction(ActionEvent event) {
        System.exit(0);
    }
    
    @FXML
    private void signUp(ActionEvent event) {
    	closeStage();
    	
    	Stage signUpStage = new Stage();
    	ViewFactory viewFactory = new ViewFactory();
    	Scene scene = viewFactory.getSignUpScene();
    	signUpStage.setTitle("Sign Up");
    	signUpStage.initStyle(StageStyle.UNDECORATED);
    	signUpStage.setResizable(false);
    	signUpStage.setScene(scene);
    	signUpStage.getIcons().add(viewFactory.getDefaultIcon());
    	signUpStage.show();
    }

    private void closeStage() {
        ((Stage) username.getScene().getWindow()).close();
    }

    void loadMain() {
    	Stage mainStage = new Stage();
    	ViewFactory viewFactory = new ViewFactory();
    	Scene scene = viewFactory.getMainScene();
        mainStage.setTitle("WinAssist");
        mainStage.initStyle(StageStyle.TRANSPARENT);
        mainStage.setResizable(false);
        mainStage.setScene(scene);
        mainStage.getIcons().add(viewFactory.getDefaultIcon());
        mainStage.show();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        TextToSpeech.speak("Hello sir. I Am Arya. Your Personal Assistant. How Can I Help You?");
    }

}
