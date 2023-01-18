package io.github.pitzzahh.chatbot.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class UserCardController {

    @FXML
    public Label message;

    public void setData(String userMessage) {
        message.setText(userMessage);
    }
}
