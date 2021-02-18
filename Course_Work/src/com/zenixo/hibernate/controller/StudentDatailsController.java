package com.zenixo.hibernate.controller;

import com.zenixo.hibernate.bussiness.BOFactory;
import com.zenixo.hibernate.bussiness.BOType;
import com.zenixo.hibernate.bussiness.custom.impl.StudentBOImpl;
import com.zenixo.hibernate.bussiness.custom.impl.StudentDatailsBOImpl;
import com.zenixo.hibernate.dto.CustomDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentDatailsController {

    @FXML
    private ComboBox<?> cmbStudentID;
    @FXML
    private TableView<CustomDTO> tblStudentDatails;

    @FXML
    private TableColumn<CustomDTO, String> colStudentName;

    @FXML
    private TableColumn<CustomDTO, String> colStudentID;

    @FXML
    private TableColumn<CustomDTO, String> colCourseID;

    StudentBOImpl studentBO= BOFactory.getInstance().getBO(BOType.STUDENT);
    StudentDatailsBOImpl studentDatailsBO=BOFactory.getInstance().getBO(BOType.STUDENTDATAILL);

    public void initialize(){
        loadAllStudentID();
    }

    private void loadAllStudentID(){
        try {
            ArrayList<String> list=studentBO.getAllStudentForCombo();
            ObservableList observableList= FXCollections.observableArrayList(list);
            cmbStudentID.setItems(observableList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btncmbStudentID(ActionEvent event) {
        try {
            List<CustomDTO>customDTOS=studentDatailsBO.getAllStudentDatails(String.valueOf(cmbStudentID.getValue()));
            ObservableList<CustomDTO> list=FXCollections.observableArrayList();
            list.addAll(customDTOS);
            tblStudentDatails.setItems(list);
            setTblStudentDatails();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void tblStudentDatails(ActionEvent event) {

    }

    private void setTblStudentDatails(){
        colStudentName.setCellValueFactory(new PropertyValueFactory<CustomDTO,String>("studentName"));
        colStudentID.setCellValueFactory(new PropertyValueFactory<CustomDTO,String>("studentID"));
        colCourseID.setCellValueFactory(new PropertyValueFactory<CustomDTO,String>("courseID"));
    }


    @FXML
    private AnchorPane Root;


    @FXML
    void btnBackToHome(MouseEvent event) throws IOException {
        Stage stage = (Stage) Root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/MainForum.fxml"))));
        stage.centerOnScreen();
    }
}
