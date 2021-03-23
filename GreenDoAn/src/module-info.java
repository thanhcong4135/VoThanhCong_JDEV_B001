module GreenDoAn {
    requires javafx.fxml;
    requires javafx.controls;
    requires java.sql;

    opens com.green.cinemamanagement;
    opens com.green.cinemamanagement.controllers;
}