package com.example.storelocator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream; // Add this import
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private TextField nameInput;

    @FXML
    protected void onHelloButtonClick() {
        String name = nameInput.getText();

        if (name.contains("workwear")) {
            displayContentFromFile("src/main/java/com/example/storelocator/workwear_mens.txt");
        } else if (name.contains("casual")) {
            displayContentFromFile("casual.txt");
        } else if (name.contains("active")) {
            displayContentFromFile("active.txt");
        } else {
            welcomeText.setText("Hello, " + name + "!");
        }
    }

    private void displayContentFromFile(String filename) {
        try (InputStream inputStream = getClass().getResourceAsStream("/" + filename)) {
            if (inputStream == null) {
                System.err.println("Input stream is null for: " + filename);
                return;
            }

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] fields = line.split(",");
                    if (fields.length >= 3) {
                        String storeName = fields[0];
                        String storeSite = fields[1];
                        String styleType = fields[2];
                        content.append("Store Name: ").append(storeName).append("\n");
                        content.append("Store Site: ").append(storeSite).append("\n");
                        content.append("Type of Style: ").append(styleType).append("\n\n");
                    }
                }
                welcomeText.setText(content.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
