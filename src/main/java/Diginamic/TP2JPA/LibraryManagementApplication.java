package Diginamic.TP2JPA;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import Diginamic.TP2JPA.Repositories.*;
import Diginamic.TP2JPA.Utilities.LiquidbaseUtil;
import org.springframework.boot.SpringApplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LibraryManagementApplication extends Application {

    private ConfigurableApplicationContext springContext;

    public static void main(String[] args) {
        SpringApplication.run(LibraryManagementApplication.class, args);
        launch(args);
    }

    @Override
    public void init() throws Exception {
        springContext = SpringApplication.run(LibraryManagementApplication.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Main.fxml"));
        fxmlLoader.setControllerFactory(springContext::getBean);
        primaryStage.setTitle("Library Management");
        primaryStage.setScene(new Scene(fxmlLoader.load()));
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        springContext.close();
    }
}