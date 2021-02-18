package com.zenixo.hibernate.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.zenixo.hibernate.bussiness.BOFactory;
import com.zenixo.hibernate.bussiness.BOType;
import com.zenixo.hibernate.bussiness.SuperBO;
import com.zenixo.hibernate.bussiness.custom.impl.CourseBOImpl;
import com.zenixo.hibernate.dto.CourseDTO;
import com.zenixo.hibernate.entity.Course;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author Gathsara Umesh on 2/10/2021
 * @project Hibernate-Course-Work
 */
public class AddCourseController {


    @FXML
    private TextField txtCourseID;

    @FXML
    private TextField txtCourseName;

    @FXML
    private TextField txtCourseType;

    @FXML
    private TextField txtCourseDuration;

    //@FXML
    //private TextField txtSerchCourse;

    @FXML
    private TableView<CourseDTO> tblLoadAll;

    @FXML
    private TableColumn<CourseDTO, String> colCourse_ID;

    @FXML
    private TableColumn<CourseDTO, String> colCourse_Name;

    @FXML
    private TableColumn<CourseDTO, String> colCourse_Type;

    @FXML
    private TableColumn<CourseDTO, String> colCourse_Duration;

    @FXML
    private Button txtMain_Button;

    @FXML
    private Button txtAddButton;

    @FXML
    private Button txtUpdateButton;

    //@FXML
    //private Button txtSerchButton;

    @FXML
    private Button txtDeleteButton;


    CourseBOImpl courseBO = BOFactory.getInstance().getBO(BOType.COURSE);

    public void initialize() {
        generateCourseID();
        loadAllCourse();
        txtAddButton.setDisable(true);
        txtUpdateButton.setDisable(true);
        //txtSerchButton.setDisable(true);
        txtDeleteButton.setDisable(true);
        txtCourseID.setDisable(true);
        txtCourseName.setDisable(true);
        txtCourseType.setDisable(true);
        txtCourseDuration.setDisable(true);
        //txtSerchCourse.setDisable(true);

    }


    private void loadAllCourse() {
        try {
            List<CourseDTO> allCourse = courseBO.getAllCourse();
            ObservableList<CourseDTO> list = FXCollections.observableArrayList();
            list.addAll(allCourse);
            System.out.println("Test 3" + list);
            tblLoadAll.setItems(list);
            setTblManage_Courses();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void setTblManage_Courses() {

        colCourse_ID.setCellValueFactory(new PropertyValueFactory<CourseDTO, String>("courseID"));
        colCourse_Name.setCellValueFactory(new PropertyValueFactory<CourseDTO, String>("courseName"));
        colCourse_Type.setCellValueFactory(new PropertyValueFactory<CourseDTO, String>("courseType"));
        colCourse_Duration.setCellValueFactory(new PropertyValueFactory<CourseDTO, String>("courseDuration"));
    }


    public void btnUpdate(ActionEvent actionEvent) {
        try {
            boolean isUpdated = courseBO.updateItem(new CourseDTO(
                    txtCourseID.getText(),
                    txtCourseName.getText(),
                    txtCourseType.getText(),
                    txtCourseDuration.getText()
            ));

            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Updated", ButtonType.OK).showAndWait();
                loadAllCourse();
                generateCourseID();
                txtCourseType.clear();
                txtCourseDuration.clear();
                txtCourseName.clear();
            } else {
                new Alert(Alert.AlertType.ERROR, "error!", ButtonType.OK).show();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnSerch(ActionEvent actionEvent) {
    }

    public void btnDelete(ActionEvent actionEvent) {
        try {
            boolean isDeleted = courseBO.deleteItem(new CourseDTO(
                    txtCourseID.getText(),
                    txtCourseName.getText(),
                    txtCourseType.getText(),
                    txtCourseDuration.getText()
            ));
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "Deleted !", ButtonType.OK).showAndWait();
                loadAllCourse();
                generateCourseID();
                txtCourseType.clear();
                txtCourseDuration.clear();
                txtCourseName.clear();

            } else {
                new Alert(Alert.AlertType.WARNING, "Delete Failed !", ButtonType.OK).showAndWait();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnAdd_Course(ActionEvent actionEvent) {
        txtAddButton.setDisable(false);
        txtUpdateButton.setDisable(true);
        //txtSerchButton.setDisable(true);
        txtDeleteButton.setDisable(true);
        txtCourseID.setDisable(false);
        txtCourseName.setDisable(false);
        txtCourseType.setDisable(false);
        txtCourseDuration.setDisable(false);
        //txtSerchCourse.setDisable(false);
        txtCourseID.clear();
        txtCourseType.clear();
        txtCourseDuration.clear();
        txtCourseName.clear();
        generateCourseID();


    }

    public void btnAdd(ActionEvent actionEvent) {
        String id = txtCourseID.getText();
        String name = txtCourseName.getText();
        String type = txtCourseType.getText();
        String duration = txtCourseDuration.getText();

        CourseDTO courseDTO = new CourseDTO(id, name, type, duration);


        try {
            boolean added = courseBO.addCourse(courseDTO);
            if (added) {

                new Alert(Alert.AlertType.CONFIRMATION, "OK").showAndWait();
                loadAllCourse();
                generateCourseID();
                txtCourseType.clear();
                txtCourseDuration.clear();
                txtCourseName.clear();

            } else {
                new Alert(Alert.AlertType.WARNING, "FAILED").showAndWait();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Test" + courseDTO);
    }

    public void tblItemsOnMouseClicked(MouseEvent mouseEvent) {
        try {
            txtCourseID.setText(tblLoadAll.getSelectionModel().getSelectedItem().getCourseID());
            txtCourseName.setText(tblLoadAll.getSelectionModel().getSelectedItem().getCourseName());
            txtCourseType.setText(tblLoadAll.getSelectionModel().getSelectedItem().getCourseType());
            txtCourseDuration.setText(tblLoadAll.getSelectionModel().getSelectedItem().getCourseDuration());
            txtUpdateButton.setDisable(false);
            txtDeleteButton.setDisable(false);
            txtCourseID.setDisable(false);
            txtCourseName.setDisable(false);
            txtCourseType.setDisable(false);
            txtCourseDuration.setDisable(false);
            //txtSerchCourse.setDisable(false);
        } catch (NullPointerException ex) {

        }
    }

    private void generateCourseID() {
        try {
            String lastID = courseBO.getCourseID();
            int newId = Integer.parseInt(lastID.substring(1, 4)) + 1;
            if (newId < 10) {
                txtCourseID.setText("C00" + newId);
            } else if (newId < 100) {
                txtCourseID.setText("C0" + newId);
            } else {
                txtCourseID.setText("C" + newId);
            }


        } catch (Exception e) {
            txtCourseID.setText("C001");
        }
    }

    @FXML
    private AnchorPane context;

    @FXML
    void btnBacktoHome(MouseEvent event) throws IOException {
        Stage stage = (Stage) context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/MainForum.fxml"))));
        stage.centerOnScreen();
    }

}
