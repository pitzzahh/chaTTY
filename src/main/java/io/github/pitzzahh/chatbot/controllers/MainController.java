package io.github.pitzzahh.chatbot.controllers;

import static io.github.pitzzahh.chatbot.util.ToolTipUtil.initToolTip;
import io.github.pitzzahh.chatbot.util.Style;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import java.util.ResourceBundle;
import javafx.scene.layout.VBox;
import javafx.fxml.FXML;
import java.net.URL;

public class MainController implements Initializable {

    @FXML
    public VBox messagesContainer;

    @FXML
    public TextField messageField;

    @FXML
    public Button sendButton;

    public static VBox messageContainerCopy;

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        messageContainerCopy = messagesContainer;
        sendButton.setTooltip(initToolTip("Click to send message", Style.normalToolTipStyle()));
    }

    @FXML
    public void onEnter(ActionEvent actionEvent) {
        actionEvent.consume();
        if (messageField.getText().trim().isEmpty()) {
            sendButton.setDisable(true);
            messageField.setStyle(Style.errorInputStyle());
        }
        else {
            messageField.setStyle(Style.normalInputStyle());
            sendButton.setDisable(false);
        }
        System.out.println("Entered");
    }

    @FXML
    public void onType(KeyEvent keyEvent) {
        if (keyEvent.getCode() != KeyCode.ENTER) {
            messageField.setStyle(Style.normalInputStyle());
            sendButton.setDisable(true);
        } else sendButton.setDisable(false);
    }

    public static VBox getCardStorage() {
        return messageContainerCopy;
    }
}
