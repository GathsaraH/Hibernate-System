package com.zenixo.hibernate.controller;

import com.zenixo.hibernate.stage.StageList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;



/**
 * @author Gathsara Umesh on 2/10/2021
 * @project Hibernate-Course-Work
 */
public class MainForumController extends StageList {

    public AnchorPane txtRoot;

    @FXML
    void addCourse(MouseEvent event) throws IOException {
        Stage stage = (Stage) this.txtRoot.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/AddCourse.fxml"))));
        stage.centerOnScreen();
    }

    @FXML
    void addStudent(MouseEvent event) throws IOException {
        Stage stage = (Stage) this.txtRoot.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/RegistrationForm.fxml"))));
        stage.centerOnScreen();

    }

    @FXML
    void studentDetails(MouseEvent event) throws IOException {
        Stage stage = (Stage) this.txtRoot.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/StudentDatails.fxml"))));
        stage.centerOnScreen();

    }
}
