package com.example.storelocator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private TextField nameInput;

    @FXML
    protected void onHelloButtonClick() {
        String name = nameInput.getText();
        welcomeText.setText("Hello, " + name + "!");
    }
}
