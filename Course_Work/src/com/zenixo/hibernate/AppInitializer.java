package com.zenixo.hibernate;/**
 * @project Hibernate-Course-Work
 * @author Gathsara Umesh on 2/9/2021
 */

import com.zenixo.hibernate.stage.StageList;
import com.zenixo.hibernate.util.FactoryConfiguration;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        session.getTransaction().begin();
        session.getTransaction().commit();
        session.close();

        StageList.Main1=primaryStage;
        try {


            primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("view/MainForum.fxml"))));
            primaryStage.setResizable(false);
            primaryStage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
