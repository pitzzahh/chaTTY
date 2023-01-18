package io.github.pitzzahh.chatbot.controllers;

import static io.github.pitzzahh.chatbot.util.ComponentUtil.initUserMessageCard;
import static io.github.pitzzahh.chatbot.util.ComponentUtil.initBotMessageCard;
import static io.github.pitzzahh.chatbot.util.ToolTipUtil.initToolTip;
import io.github.pitzzahh.chatbot.util.Style;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import javafx.fxml.FXML;

public class MainController {

    @FXML
    public VBox messagesContainer;

    @FXML
    public TextField messageField;

    @FXML
    public Button sendButton;

    @FXML
    public ScrollPane scrollPane;

    @FXML
    public void initialize() {
        sendButton.setTooltip(initToolTip("Click to send message", Style.normalToolTipStyle()));
        initBotMessageCard(messagesContainer, scrollPane, messageField.getText().trim(), true);
        scrollPane.setStyle("-fx-background-color: transparent;");
    }

    @FXML
    public void onEnter(ActionEvent actionEvent) {
        actionEvent.consume();
        final String RAW_MESSAGE = messageField.getText().trim();
        if (RAW_MESSAGE.isEmpty()) {
            sendButton.setDisable(true);
            messageField.setStyle(Style.errorInputStyle());
        }
        else {
            initUserMessageCard(messagesContainer, scrollPane, RAW_MESSAGE);
            initBotMessageCard(messagesContainer, scrollPane, RAW_MESSAGE, false);
            messageField.clear();
        }
    }

    @FXML
    public void onType(KeyEvent keyEvent) {
        if (keyEvent.getCode() != KeyCode.ENTER) {
            messageField.setStyle(Style.normalInputStyle());
            sendButton.setDisable(false);
        }
    }

}
