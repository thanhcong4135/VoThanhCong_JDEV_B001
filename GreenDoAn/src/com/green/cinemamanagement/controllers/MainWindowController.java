package com.green.cinemamanagement.controllers;

import com.green.cinemamanagement.views.ViewFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class MainWindowController extends BaseController{

    @FXML
    private MenuBar menu;

    @FXML
    private Menu menuOption;
    @FXML
    private MenuItem menuOption1;

    @FXML
    private Label lblABC;

    @FXML
    public void menuOptionAction(ActionEvent event) {
        System.out.println("Menu Option clicked");
        boolean menuOptionClick = true;
        if (menuOptionClick){
            viewFactory.showOptionWindow();
            Stage stage = (Stage) lblABC.getScene().getWindow();
            stage.close();
        }

    }

    public MainWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

}
