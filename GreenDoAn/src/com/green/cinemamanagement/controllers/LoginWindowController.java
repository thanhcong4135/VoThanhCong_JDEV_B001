package com.green.cinemamanagement.controllers;

import com.green.cinemamanagement.views.ViewFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LoginWindowController extends  BaseController {


        @FXML
        private Label lblPassword;

        @FXML
        private Button btnLogin;

        @FXML
        private TextField txtEmail;

        @FXML
        private TextField txtPassword;

        @FXML
        private Label lblEmail;

        @FXML
        private Label lblError;
        @FXML
        private Button btnExit;

        @FXML
        void btnExitAcction(ActionEvent event) {

        }

        @FXML
        public void loginButtonAction(ActionEvent event){

                if (txtEmail.getText().equals("")){
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.initStyle(StageStyle.UTILITY);
                        alert.setTitle("Warning Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Email khong duoc de trong !");
                        alert.showAndWait();
                }else if (txtPassword.getText().equals("")){
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.initStyle(StageStyle.UTILITY);
                        alert.setTitle("Warning Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Password khong duoc de trong !");
                        alert.showAndWait();
                }else{
                        try {
                                String bdURL = "jdbc:mysql://localhost/CINEMADB?user=vtcong&password=Vothanhcong070299";
                                Connection conn = DriverManager.getConnection(bdURL);


                        } catch (SQLException e) {
                                e.printStackTrace();
                        }
                }

                System.out.println("Login clicked");
                boolean loginSuccess = true;
                if (loginSuccess){
                        viewFactory.showMainWindow();
                        Stage stage = (Stage) lblError.getScene().getWindow();
                        stage.close();
                }
        }

        public LoginWindowController(ViewFactory viewFactory, String fxmlName) {
                super(viewFactory, fxmlName);
        }
}
