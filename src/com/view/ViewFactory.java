package com.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

import java.io.IOException;

public class ViewFactory {

    private final String MAIN_LAYOUT_FXML_PATH = "MainLayout.fxml";
    private final String SPLASH_LAYOUT_FXML_PATH = "SplashLayout.fxml";
    private final String LOGIN_LAYOUT_FXML_PATH= "LoginLayout.fxml";
    private final String SETTINGS_LAYOUT_FXML_PATH="SettingsLayout.fxml";
    private final String SIGN_UP_LAYOUT_FXML_PATH="SignUpLayout.fxml";
    private final String DEFAULT_CSS_PATH = "main-css.css";
    private final String DEFAULT_ICON_PATH = "assets/images/default_icon.png";


    private Scene initializeScene(String fxmlPath, int width, int height) {

        Parent parent;
        FXMLLoader loader;
        Scene scene;

        try {

            loader = new FXMLLoader(getClass().getResource(fxmlPath));
            parent = loader.load();


        } catch (IOException ioe) {

            System.out.println("[X] Exception in ViewFactory.java class." +
                    "Cannot load *.fxml file.");

            System.out.println(ioe.getMessage());
            return null;
        }

        scene = new Scene(parent, width, height);
        scene.getStylesheets().add(getClass().getResource(DEFAULT_CSS_PATH).toExternalForm());

        return scene;
    }

    public Scene getMainScene() {

        System.out.println("{+(*)+} Main scene was initialized.");
        return initializeScene(MAIN_LAYOUT_FXML_PATH, 700, 650);
    }
    
    public Scene getLoginScene() {

        System.out.println("{+(*)+} Login scene was initialized.");
        return initializeScene(LOGIN_LAYOUT_FXML_PATH, 461, 387);
    }
    
    public Scene getSignUpScene() {

        System.out.println("{+(*)+} Settings scene was initialized.");
        return initializeScene(SIGN_UP_LAYOUT_FXML_PATH, 518, 307);
    }

    public Scene getSplashScene() {

        System.out.println("{+(*)+} Splash scene was initialized.");
        return initializeScene(SPLASH_LAYOUT_FXML_PATH, 800, 445);
    }
    
    public Scene getSettingsScene() {

        System.out.println("{+(*)+} Settings scene was initialized.");
        return initializeScene(SETTINGS_LAYOUT_FXML_PATH, 544, 396);
    }

    public Image getDefaultIcon() {

        return new Image(getClass().getResource(DEFAULT_ICON_PATH).toString());
    }

    
}
