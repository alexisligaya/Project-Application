package com.example;

import java.io.IOException;

import java.util.Date;

import com.model.Application;

import java.text.SimpleDateFormat;
import java.text.ParseException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class SignUpController {
    @FXML
    private TextField txt_firstName;
    @FXML
    private TextField txt_lastName;
    @FXML
    private TextField txt_username;
    @FXML
    private TextField txt_email;
    @FXML
    private TextField txt_password;
    @FXML
    private TextField txt_company;
    @FXML
    private TextField txt_dob;

    @FXML
    private void signUp() throws IOException {
        Application application = Application.getInstance();

        SimpleDateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
        Date date = null;
        try {   
            date = dateFormat.parse(txt_dob.getText());
        } catch (ParseException e) {
            System.out.println("Invalid date format");
        }

        application.signUp(txt_firstName.getText(), txt_lastName.getText(), txt_username.getText(), txt_email.getText(), txt_password.getText(), txt_company.getText(), date);

        App.setRoot("login");
    }

}
