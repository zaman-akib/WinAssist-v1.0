package com.controller;

import com.view.ViewFactory;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        ViewFactory viewFactory = new ViewFactory();

        Scene scene = viewFactory.getSplashScene();

        primaryStage.setTitle("WinAssist");
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(viewFactory.getDefaultIcon());
        primaryStage.show();
    }


    @Override
    public void init() throws Exception {

        super.init();
    }

    @Override
    public void stop() throws Exception {

        super.stop();
    }

    public void openLink(String url) {

        getHostServices().showDocument(url);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
