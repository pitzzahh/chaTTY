package io.github.pitzzahh.chatbot.controllers;

import io.github.pitzzahh.chatbot.util.Utility;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import java.util.Map;

public class BotCardController {

    @FXML
    public Label message;

    public void setData(String userMessage, boolean isStart) {
        Map<String, String> responses = Utility.readJson("responses.json");
        if (isStart) message.setText(responses.get("hello"));
        else {
            responses.entrySet()
                    .stream()
                    .filter(entry -> userMessage.contains(entry.getKey()) || userMessage.startsWith(entry.getKey()))
                    .findAny()
                    .ifPresentOrElse(entry -> message.setText(entry.getValue()), () -> message.setText("Sorry I don't understand"));
        }
    }
}
