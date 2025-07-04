package org.prak;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.prak.ui.MainView;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage)  {
        MainView view = new MainView();
        Scene scene = new Scene(view.getRoot(), 800, 600);
        stage.setScene(scene);
        stage.setTitle("PostgreSQL viewer");
        stage.show();
    }
}