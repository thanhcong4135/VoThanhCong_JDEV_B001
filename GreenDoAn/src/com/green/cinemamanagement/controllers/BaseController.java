package com.green.cinemamanagement.controllers;

import com.green.cinemamanagement.views.ViewFactory;

import java.net.URL;
import java.util.ResourceBundle;

public  class BaseController {
    protected ViewFactory viewFactory;
    private String fxmlName;

    public BaseController(ViewFactory viewFactory, String fxmlName){
        this.viewFactory = viewFactory;
        this.fxmlName = fxmlName;
    }

    public BaseController(ViewFactory viewFactory) {

    }

    public String getFxmlName(){
        return  fxmlName;
    }

}
