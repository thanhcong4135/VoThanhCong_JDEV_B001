package com.green.cinemamanagement.controllers;

import com.green.cinemamanagement.views.ViewFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class OptionWindowController extends BaseController{


    @FXML
    private Label lblFontSize;

    @FXML
    private Label lblColorTheme;

    @FXML
    private Button btnApply;

    @FXML
    private Button btnCancel;

    @FXML
    void btnApplyAction(ActionEvent event) {

    }

    @FXML
    void btnCancelAction(ActionEvent event) {

    }

    public OptionWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle){
//
//    }

    private void initSliderFontSize(){

    }

}
