package com.zenixo.hibernate.controller;

import com.zenixo.hibernate.bussiness.BOFactory;
import com.zenixo.hibernate.bussiness.BOType;
import com.zenixo.hibernate.bussiness.custom.RegistrationBO;
import com.zenixo.hibernate.bussiness.custom.impl.CourseBOImpl;
import com.zenixo.hibernate.bussiness.custom.impl.RegistrationBOImpl;
import com.zenixo.hibernate.bussiness.custom.impl.StudentBOImpl;
import com.zenixo.hibernate.dao.custom.impl.RegistrationDAOImpl;
import com.zenixo.hibernate.dto.CourseDTO;
import com.zenixo.hibernate.dto.CustomDTO;
import com.zenixo.hibernate.dto.RegistrationDTO;
import com.zenixo.hibernate.entity.Student;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RegistrationFormController {

    @FXML
    private TextField txtRegistrationID;

    @FXML
    private TextField txtStudentID;

    @FXML
    private TextField txtStudentName;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtDateBday;

    @FXML
    private ComboBox<?> txtGender;

    @FXML
    private DatePicker txtRegDate;

    @FXML
    private TextField txtCourseID;


    @FXML
    private DatePicker cmbDatBday;

    @FXML
    private TableView<CourseDTO> tblCourseTable;

    @FXML
    private TableColumn<CourseDTO, String> colCourseID;

    @FXML
    private TableColumn<CourseDTO, String> colCourseName;

    @FXML
    private TableColumn<CourseDTO, String> colCourseFee;

    @FXML
    private TableColumn<CourseDTO, String> colCourseDuration;

    @FXML
    private ComboBox<?> cmbStudentID;


    @FXML
    private ComboBox<String> cmbGender;

    @FXML
    private TableView<CustomDTO> tblStudentDtails;

    @FXML
    private TableColumn<CustomDTO, String> colSregID;

    @FXML
    private TableColumn<CustomDTO, String> colSstudentID;

    @FXML
    private TableColumn<CustomDTO, String> colScourseID;

    @FXML
    private TableColumn<CustomDTO, String> colSregFee;

    @FXML
    private TextField txtRegistrationFee;

    @FXML
    private Button txtbtnAdd;

    @FXML
    private Button txtbtnDelete;

    @FXML
    private Button txtbtnUpdate;
    @FXML
    private DatePicker txtbdayDate;

    @FXML
    private TextField txtSecondBday;

    @FXML
    private Button txtbtnAddTwo;


    CourseBOImpl courseBO=BOFactory.getInstance().getBO(BOType.COURSE);
    StudentBOImpl studentBO=BOFactory.getInstance().getBO(BOType.STUDENT);
    RegistrationBOImpl registrationBO=BOFactory.getInstance().getBO(BOType.REGISTRATION);

    public void initialize(){
        loadStudentID();
        loadAllReg();
        loadStudent();
        loadGender();
        loadAllCourse();
        loadRegistrationID();
        cmbStudentID.setVisible(false);

        //txtSecondBday.setVisible(false);
        txtbtnAddTwo.setVisible(false);

        txtStudentID.setDisable(true);
        txtRegistrationID.setDisable(true);
        txtStudentName.setDisable(true);
        txtAddress.setDisable(true);
        txtContact.setDisable(true);
        cmbGender.setDisable(true);
        txtCourseID.setDisable(true);
        //txtbdayDate.setDisable(true);
        txtSecondBday.setDisable(true);
        txtRegDate.setDisable(true);
        txtRegistrationFee.setDisable(true);
        tblStudentDtails.setDisable(true);
        tblCourseTable.setDisable(true);
        txtbtnAdd.setDisable(true);
        txtbtnUpdate.setDisable(true);
        txtbtnDelete.setDisable(true);




    }
    private void loadAllCourse(){
        try {
            List<CourseDTO> allCourse=courseBO.getAllCourse();
            ObservableList<CourseDTO> list= FXCollections.observableArrayList();
            list.addAll(allCourse);
            tblCourseTable.setItems(list);
            setTblCourseTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadStudentID(){
        try {
            String LastID=registrationBO.loadStudentID();
            int newID=Integer.parseInt(LastID.substring(1,4))+1;
            if (newID<10){
                txtStudentID.setText("S00"+newID);
            }else if (newID<100){
                txtStudentID.setText("S0"+newID);
            }else {
                txtStudentID.setText("S"+newID);
            }
        } catch (Exception e) {
            txtStudentID.setText("S001");
        }
    }

  private void   loadRegistrationID(){
      try {
          String lastID=registrationBO.loadRegistrationID();
          int newID=Integer.parseInt(lastID.substring(1,4))+1;
          if (newID<10){
              txtRegistrationID.setText("R00"+newID);
          }else if (newID<100){
              txtRegistrationID.setText("R0"+newID);
          }else {
              txtRegistrationID.setText("R"+newID);
          }
      } catch (Exception e) {
          txtRegistrationID.setText("R001");
      }
  }

    private void loadAllReg(){
        try {
            List<CustomDTO> allReg=registrationBO.getAllReg();
            ObservableList<CustomDTO> list=FXCollections.observableArrayList();
            list.addAll(allReg);
            tblStudentDtails.setItems(list);
            setTblStudentDtails();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setTblStudentDtails(){
        colSregID.setCellValueFactory(new PropertyValueFactory<CustomDTO,String>("regNumber"));
        colSstudentID.setCellValueFactory(new PropertyValueFactory<CustomDTO,String>("studentID"));
        colScourseID.setCellValueFactory(new PropertyValueFactory<CustomDTO,String>("CourseID"));
        colSregFee.setCellValueFactory(new PropertyValueFactory<CustomDTO,String>("regFee"));
    }

    private  void setTblCourseTable(){
        colCourseID.setCellValueFactory(new PropertyValueFactory<CourseDTO,String>("courseID"));
        colCourseName.setCellValueFactory(new PropertyValueFactory<CourseDTO,String>("courseName"));
        colCourseFee.setCellValueFactory(new PropertyValueFactory<CourseDTO,String>("courseType"));
        colCourseDuration.setCellValueFactory(new PropertyValueFactory<CourseDTO,String>("courseDuration"));
    }


    public void loadStudent(){
        try {
            ArrayList<String> list=studentBO.getAllStudentForCombo();
            ObservableList observableList=FXCollections.observableArrayList(list);
            cmbStudentID.setItems(observableList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @FXML
    void btnAdd(ActionEvent event) {
        String stid = txtStudentID.getText();
        String stname = txtStudentName.getText();
        String address = txtAddress.getText();
        String contatc = txtContact.getText();

        //String bday= String.valueOf(txtbdayDate.getValue());

        //String bday = String.valueOf(txtbdayDate.getValue());

        String bday=txtSecondBday.getText();
        System.out.println("DATE CHECK 01"+bday);
        String gender = (String) cmbGender.getValue();
        String regid = txtRegistrationID.getText();
        String value = String.valueOf(txtRegDate.getValue());
        double regfee = Double.parseDouble(txtRegistrationFee.getText());
        String courseid = txtCourseID.getText();

        CustomDTO customDTO=new CustomDTO(
          stid,stname,address,contatc,bday,gender,regid,value,regfee,courseid
        );
        System.out.println("Degug"+customDTO);
        try {
            boolean issAdded = studentBO.addStudent(customDTO);
            if (issAdded){
                new Alert(Alert.AlertType.CONFIRMATION,"Added !",ButtonType.OK).showAndWait();
                System.out.println("Degug"+customDTO);
                System.out.println("DATE CHECK 02"+bday);
                loadStudentID();
                loadAllReg();
                loadStudent();
                loadGender();
                loadAllCourse();
                loadRegistrationID();
            }else {
                new Alert(Alert.AlertType.WARNING,"Failed !",ButtonType.OK).showAndWait();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void loadGender(){
        cmbGender.getItems().removeAll(cmbGender.getItems());
        cmbGender.getItems().addAll("Male","Female");
        cmbGender.getSelectionModel().getSelectedItem();
    }


    @FXML
    void btnDelete(ActionEvent event) {
        String studentid = txtStudentID.getText();
        String regid = txtRegistrationID.getText();
        String sname = txtStudentName.getText();
        String address = txtAddress.getText();
        String bday = txtSecondBday.getText();
        String gender = cmbGender.getValue();
        String regdate = String.valueOf(txtRegDate.getValue());
        String courseid = txtCourseID.getText();
        String contatc = txtContact.getText();
        double regfree = Double.parseDouble(txtRegistrationFee.getText());

        CustomDTO customDTO=new CustomDTO(studentid,regid,sname,address,bday,gender,regdate,courseid,contatc,regfree);
        try {
            boolean isDeleted = registrationBO.deleteStudent(customDTO);
            if (isDeleted){
                new Alert(Alert.AlertType.CONFIRMATION,"Deleted !",ButtonType.OK).showAndWait();

            }else {
                new Alert(Alert.AlertType.WARNING,"Failed !",ButtonType.OK).showAndWait();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnRe_Registration(ActionEvent event) {
        loadStudentID();
        loadAllReg();
        loadStudent();
        loadGender();
        loadAllCourse();
        loadRegistrationID();

        txtbtnAddTwo.setVisible(true);

        cmbStudentID.setVisible(true);
        txtStudentID.setDisable(false);
        txtRegistrationID.setDisable(false);
        txtStudentName.setDisable(false);
        txtAddress.setDisable(false);
        txtContact.setDisable(false);
        cmbGender.setDisable(false);
        txtCourseID.setDisable(false);
        //txtbdayDate.setVisible(false);
        txtSecondBday.setDisable(false);
        txtSecondBday.setVisible(true);
        txtRegDate.setDisable(false);
        txtRegistrationFee.setDisable(false);
        tblStudentDtails.setDisable(false);
        tblCourseTable.setDisable(false);
        txtbtnAdd.setVisible(false);
        txtbtnUpdate.setDisable(false);
        txtbtnDelete.setDisable(false);



    }

    @FXML
    void btnRegistration(ActionEvent event) {
        cmbStudentID.setVisible(false);
        txtStudentID.setDisable(true);
        txtRegistrationID.setDisable(true);
        txtStudentName.setDisable(false);
        txtAddress.setDisable(false);
        txtContact.setDisable(false);
        cmbGender.setDisable(false);
        txtCourseID.setDisable(false);
        //txtbdayDate.setDisable(false);
        txtSecondBday.setDisable(false);
        txtRegDate.setDisable(false);
        txtRegistrationFee.setDisable(false);
        tblStudentDtails.setDisable(false);
        tblCourseTable.setDisable(false);
        txtbtnAdd.setDisable(false);
        txtbtnUpdate.setDisable(false);
        txtbtnDelete.setDisable(false);


    }

    @FXML
    void btnUpdate(ActionEvent event) {
        boolean isUpdated = false;
        try {
            isUpdated = registrationBO.updateReg(new RegistrationDTO(
                    txtRegistrationID.getText(),
                    String.valueOf(txtRegDate.getValue()),
                    Double.parseDouble(txtRegistrationFee.getText()),
                    txtStudentID.getText(),
                    txtCourseID.getText()

            ));
            if (isUpdated){
                new Alert(Alert.AlertType.CONFIRMATION,"Updated",ButtonType.OK).showAndWait();

            }else {
                new Alert(Alert.AlertType.WARNING,"Updated",ButtonType.OK).showAndWait();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void tblMouseClickStudentTableLoad(MouseEvent event) {
        txtRegistrationID.setText(tblStudentDtails.getSelectionModel().getSelectedItem().getRegNumber());
        txtStudentID.setText(tblStudentDtails.getSelectionModel().getSelectedItem().getStudentID());
        txtCourseID.setText(tblStudentDtails.getSelectionModel().getSelectedItem().getCourseID());
        //txtRegistrationFee.setText(String.valueOf(tblStudentDtails.getSelectionModel().getSelectedItem().getRegFee()));
    }

    @FXML
    void btncmbStudentID(ActionEvent event) {

        try {
            CustomDTO customDTO=registrationBO.searchStudent(cmbStudentID.getValue()+"");
            if (customDTO!=null){
                txtStudentName.setText(customDTO.getStudentName());
                txtStudentID.setText(customDTO.getStudentID());
                txtAddress.setText(customDTO.getStudentAddress());

                //txtbdayDate.setValue(LocalDate.parse(customDTO.getStudentDob()));

                txtSecondBday.setText(customDTO.getStudentDob());

                txtSecondBday.setText(customDTO.getStudentDob());
                cmbGender.setValue(customDTO.getStudentGender());
                txtRegDate.setValue(LocalDate.parse(customDTO.getRegDate()));
                txtContact.setText(customDTO.getStudentContact());
                txtRegistrationFee.setText(String.valueOf(customDTO.getRegFee()));


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @FXML
    void btnAddTwo(ActionEvent event) {
        String regid = txtRegistrationID.getText();
        String regdate = String.valueOf(txtRegDate.getValue());
        double regfee = Double.parseDouble(txtRegistrationFee.getText());
        String studentid = txtStudentID.getText();
        String courseid = txtCourseID.getText();

        RegistrationDTO registrationDTO=new RegistrationDTO(
          regid,regdate,regfee,studentid,courseid
        );
        try {
            boolean isAdded = registrationBO.addReRegStudent(registrationDTO);
            if (isAdded){
                new Alert(Alert.AlertType.CONFIRMATION,"Added !",ButtonType.OK).showAndWait();
                loadStudentID();
                loadAllReg();
                loadStudent();
                loadGender();
                loadAllCourse();
                loadRegistrationID();
            }else {
                new Alert(Alert.AlertType.CONFIRMATION,"Added !",ButtonType.OK).showAndWait();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public void tblCourseMouseClick(MouseEvent mouseEvent) {
        txtCourseID.setText(tblCourseTable.getSelectionModel().getSelectedItem().getCourseID());
    }

    public void tblMouseClickStudent(MouseEvent mouseEvent) {
        txtRegistrationID.setText(tblStudentDtails.getSelectionModel().getSelectedItem().getRegNumber());
        txtStudentID.setText(tblStudentDtails.getSelectionModel().getSelectedItem().getStudentID());
        txtCourseID.setText(tblStudentDtails.getSelectionModel().getSelectedItem().getCourseID());
        txtRegistrationFee.setText(String.valueOf(tblStudentDtails.getSelectionModel().getSelectedItem().getRegFee()));
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
