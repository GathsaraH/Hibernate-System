package com.zenixo.hibernate.controller;

import com.zenixo.hibernate.bussiness.BOFactory;
import com.zenixo.hibernate.bussiness.BOType;
import com.zenixo.hibernate.bussiness.custom.UserBO;
import com.zenixo.hibernate.dto.UserDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginForumController {

    public RadioButton rdShowPassword;
    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtUserName;

    @FXML
    private TextField txtShowedPassword;

    @FXML
    private PasswordField pwd;

    UserBO userBO = BOFactory.getInstance().getBO(BOType.USER);

    public void initialize() {
        txtShowedPassword.setVisible(false);
    }

    @FXML
    void btnLogin(ActionEvent event) {
        if (txtUserName.getText().length() > 0 && pwd.getText().length() > 0) {
            try {
                UserDTO userDTO = userBO.getUser(txtUserName.getText(), pwd.getText());
                Stage stage = (Stage) this.root.getScene().getWindow();
                stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/MainForum.fxml"))));
                stage.centerOnScreen();
            } catch (Exception e) {
                new Alert(Alert.AlertType.ERROR, "User not found!", ButtonType.OK).show();
            }
        } else {
            new Alert(Alert.AlertType.ERROR, "Fields cannot be empty!", ButtonType.OK).show();
        }
    }

    @FXML
    void pwdOnKeyReleased(KeyEvent event) {
        txtShowedPassword.setText(pwd.getText());
    }

    @FXML
    void txtShowedPasswordOnKeyReleased(KeyEvent event) {
        pwd.setText(txtShowedPassword.getText());
    }

    public void rdShowPasswordOnAction(ActionEvent actionEvent) {
        if (rdShowPassword.isSelected()) {
            txtShowedPassword.setVisible(true);
            pwd.setVisible(false);
        } else {
            txtShowedPassword.setVisible(false);
            pwd.setVisible(true);
        }
    }
}
