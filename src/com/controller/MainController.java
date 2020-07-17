package com.controller;

import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import com.model.*;
import com.view.ViewFactory;

public class MainController {

    public static final String API_KEY = "$$ENTER YOUR API KEY HERE$$";
    public static int w;
    public WebView browser;
    
    public void loadEngine(String u) {
		WebEngine webEngine = browser.getEngine();
		Worker<Void> worker = webEngine.getLoadWorker();
		bar.progressProperty().bind(worker.progressProperty());
		String url = u;
		webEngine.load(url);
    }
    
    @FXML
    public TextField txtEnter;
    
    @FXML
    public Button closeButton;
    
    @FXML
    public Circle topClose;
    
    @FXML
    public Circle topMin;
    
    @FXML
    public TextField txtGoogle;
    
    @FXML
    public TextField txtYoutube;
    
    @FXML
    public ProgressBar bar;
    
    @FXML
    public Button gSearch;
    
    @FXML
    public Button ySearch;
    
    @FXML
    public TextField transtaleText;
    
    @FXML
    private void txtFieldTask(ActionEvent event) {
    	txtEnter.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	String uText = txtEnter.getText();

				String g=Grammar.chat(uText);
				String m=Mathematics.calculation(uText);
				String d=DateTime.CurrentDateTime(uText);
				String url=WebSite.browse(uText);
				String gys=GoogleSearch.search(uText);
				DesktopTask.run(uText);
				String r=Reminder.remind(uText);
				
				switch (w) {
				case 1:  botSay(g);
                break;
                case 2:  botSay(m);
                break;
                case 3:  loadEngine(url);
                break;
                case 4:  botSay("Opening from Desktop...");
                break;
                case 5:  botSay(d);
                break;
                case 6: botSay(gys);
                break;
                case 7: botSay(r);
                break;
                default: 
                {
                	int decider = (int) (Math.random()*3+1);
            		if(decider == 1){
            			botSay("Sorry could not understand. Click on the 'Help' button for help.");
            		}
            		else if(decider == 2){
            			botSay("Sorry. You can click on the 'Help' button for help.");
            		}
                    else if(decider == 3){
                    	botSay("Please again. You can click on the 'Help' button for help.");
            		}
                }
                break;
				
				}
				w=0;
				
				txtEnter.setText("");
            }
        });
    }
    
    @FXML
    private void openTranslator(ActionEvent event) {
		loadEngine("https://translate.google.com/?hl=bn");
    }
    
    @FXML
    private void openCalculator(ActionEvent event) {
    	DesktopTask.run("open>>calc");
    	TextToSpeech.speak("Opening Calculator.");
    }
    
    @FXML
    private void googleSearch(ActionEvent event) {
    	 WebEngine webEngine = browser.getEngine();
    	 Worker<Void> worker = webEngine.getLoadWorker();
    	 bar.progressProperty().bind(worker.progressProperty());
         String s=txtGoogle.getText();
         String s1=s.replaceAll(" ", "+");
         String url = "https://www.google.com/search?q="+s1;
         webEngine.load(url);
         TextToSpeech.speak("Searching in google.");
         txtGoogle.setText("");
    }

	@FXML
    private void youtubeSearch(ActionEvent event) {
		 WebEngine webEngine = browser.getEngine();
         Worker<Void> worker = webEngine.getLoadWorker();
    	 bar.progressProperty().bind(worker.progressProperty());
         String s=txtYoutube.getText();
         String s1=s.replaceAll(" ", "+");
         String url = "https://www.youtube.com/results?search_query="+s1;
         webEngine.load(url);
         TextToSpeech.speak("Searching in youtube.");
         txtYoutube.setText("");
    }
    
    @FXML
    private void openRecentFiles(ActionEvent event) {
    	TextToSpeech.speak("Shwoing the recent file list you accessed.");
		try {
			Desktop.getDesktop().open(new File("C:\\Users\\"+System.getProperty("user.name")+"\\Recent"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
    
    @FXML
    private void helpButton(ActionEvent event) {
    	DesktopTask.run("run>>Help.txt");
    }
    
    @FXML
    private void aboutButton(ActionEvent event) {
    	DesktopTask.run("run>>About.txt");
    }
    
    @FXML
    private void takeScreenshot(ActionEvent event) {
    	TextToSpeech.speak("Taking screenshot and opening the driectory.");
    	try {
			Thread.sleep (500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new ScreenShot();
		try {
			Thread.sleep (2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
    
    
    @FXML
    private void handleCloseButtonAction(ActionEvent event) {
    	TextToSpeech.speak("Closing application.");
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        System.out.println("{+(*)+} Application was closed.");
    }
    
    @FXML
    private void exitAction(MouseEvent event) {
    	topClose.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent me) {
            	TextToSpeech.speak("Closing application.");
            	Stage stage = (Stage) topClose.getScene().getWindow();
                stage.close();
                System.out.println("{+(*)+} Application was closed.");
            }
        });
    }

    @FXML
    private void minimizeProgram(MouseEvent event) {
        topMin.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent me) {
            	Stage stage = (Stage) topMin.getScene().getWindow();
                stage.toBack();
                System.out.println("{*} Program Minimized.");
            }
        });
    }
    
    @FXML
    private void feedback(ActionEvent event) {
    	botSay("Sir please contact us through email.");
    	loadEngine("https://mail.google.com/");
    }
    
    @FXML
    private void manageSettings(ActionEvent event) {
    	Stage settingsStage = new Stage();
    	ViewFactory viewFactory = new ViewFactory();
    	Scene scene = viewFactory.getSettingsScene();
    	settingsStage.setTitle("Settings");
    	settingsStage.initStyle(StageStyle.UNDECORATED);
    	settingsStage.setResizable(false);
    	settingsStage.setScene(scene);
    	settingsStage.getIcons().add(viewFactory.getDefaultIcon());
    	settingsStage.show();
    }
    
    public void closeMain() {
        Stage stage = (Stage) txtEnter.getScene().getWindow();
        stage.close();
    }

    public void botSay(String s) {
    	String html = "<html><h1>"+"You: "+txtEnter.getText()+"</h1><h1>"+"Arya: "+s+"</h1></html>";
    	
    	WebEngine webEngine=browser.getEngine();
        webEngine.loadContent(html);
    	TextToSpeech.speak(s);
    }

}
