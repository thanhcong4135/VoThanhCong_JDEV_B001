package com.green.cinemamanagement.views;

import com.green.cinemamanagement.controllers.BaseController;
import com.green.cinemamanagement.controllers.LoginWindowController;
import com.green.cinemamanagement.controllers.MainWindowController;
import com.green.cinemamanagement.controllers.OptionWindowController;
import com.green.cinemamanagement.dbhelper.daos.DBManager;
import com.green.cinemamanagement.enum1.ColorTheme;
import com.green.cinemamanagement.enum1.FontSize;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewFactory {
    private FontSize fontSize = FontSize.SMALL;
    private ColorTheme colorTheme = ColorTheme.DEFAULT;

    private DBManager dbManager;

    public ViewFactory(DBManager dbManager){
        this.dbManager = dbManager;
    }

    public ViewFactory() {
    }

    public void showLoginWindow(){
        System.out.println("Showing login window");
        BaseController controller = new LoginWindowController(this, "LoginWindow.fxml");
        initializeStage(controller);
    }

    public void showMainWindow(){
        System.out.println("Showing main window");
        BaseController controller = new MainWindowController(this, "MainWindow.fxml");
        initializeStage(controller);
    }

    public void showOptionWindow(){
        System.out.println("Showing option window");
        BaseController controller = new OptionWindowController(this,"OptionWindow.fxml");
        initializeStage(controller);
    }

    public void closeStage(Stage stage){
        stage.close();
    }

    private void initializeStage(BaseController controller){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(controller.getFxmlName()));
        fxmlLoader.setController(controller);

        Parent parent = null;
        try {
            parent = fxmlLoader.load();
        }catch (IOException e){
            System.out.println("initializeStage: fail to load fxml");
            e.printStackTrace();
            return;
        }

        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }

}
